package dat19v2.mandatory.resttemplate.services;

import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.api.domain.ApiDataListDTO;
import dat19v2.mandatory.api.mapper.IApiDataWeatherMapper;
import dat19v2.mandatory.resttemplate.controllers.v1.RestApiDataController;
import dat19v2.mandatory.resttemplate.repositories.IApiDataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiDataService implements IApiDataService
{
    private RestTemplate restTemplate;
    private final String api_url;
    private final IApiDataWeatherMapper iApiDataWeatherMapper;
    private final IApiDataRepository iApiDataRepository;

    public ApiDataService(RestTemplate restTemplate, @Value("${api.url}") String api_url, IApiDataWeatherMapper iApiDataWeatherMapper, IApiDataRepository iApiDataRepository)
    {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        this.iApiDataWeatherMapper = iApiDataWeatherMapper;
        this.iApiDataRepository = iApiDataRepository;
    }

    @Override
    public ApiDataListDTO getApiData()
    {
        List<ApiDataDTO> apiDataDTOS = iApiDataRepository
                .findAll()
                .stream()
                .map(apiData -> {
                    ApiDataDTO apiDataDTO = iApiDataWeatherMapper.apiDataToApiDataDTO(apiData);
                    apiDataDTO.setApiDataUrl(getOpenWeatherUrl(apiData.getId()));
                    return apiDataDTO;
                })
                .collect(Collectors.toList());

        /*
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("id", 2618425)
                .queryParam("appid", "c296fe19c765289ba2b1f4ce756b35ad");


        ApiDataWeather apiDataWeather = restTemplate.getForObject(uriBuilder.toUriString(), ApiDataWeather.class);
        assert apiDataWeather != null;
        return apiDataWeather.getApiDataList();

         */
        return new ApiDataListDTO(apiDataDTOS);
    }

    private String getOpenWeatherUrl(Long id)
    {
        return RestApiDataController.BASE_URL + "/" + id;
    }
}
