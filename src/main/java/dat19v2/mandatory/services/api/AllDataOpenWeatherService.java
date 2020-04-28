package dat19v2.mandatory.services.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.api.mapper.IApiDataMapper;
import dat19v2.mandatory.model.*;
import dat19v2.mandatory.services.api.save.ISaveOpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Service for REST API that calls OpenWeatherApi, returns JSON and calls ISaveOpenWeatherService to save JSON objects
 */
@Service
@Component
public class AllDataOpenWeatherService implements IAllDataOpenWeatherService
{
    private final RestTemplate restTemplate;
    private final ISaveOpenWeatherService<ApiData> iSaveApiDataService;
    private final ISaveOpenWeatherService<Clouds> iSaveApiCloudsService;
    private final ISaveOpenWeatherService<Coord> iSaveApiCoordService;
    private final ISaveOpenWeatherService<MainModel> iSaveApiMainModelService;
    private final ISaveOpenWeatherService<Sys> iSaveApiSysService;
    private final ISaveOpenWeatherService<Weather> iSaveApiWeatherService;
    private final ISaveOpenWeatherService<Wind> iSaveApiWindService;
    private final String api_url;
    @Autowired
    private final IApiDataMapper iApiDataMapper;

    @Autowired
    public AllDataOpenWeatherService(RestTemplate restTemplate, ISaveOpenWeatherService<ApiData> iSaveApiDataService,
                                     ISaveOpenWeatherService<Clouds> iSaveApiCloudsService,
                                     ISaveOpenWeatherService<Coord> iSaveApiCoordService,
                                     ISaveOpenWeatherService<MainModel> iSaveApiMainModelService,
                                     ISaveOpenWeatherService<Sys> iSaveApiSysService,
                                     ISaveOpenWeatherService<Weather> iSaveApiWeatherService,
                                     ISaveOpenWeatherService<Wind> iSaveApiWindService,
                                     @Value("${api.url}") String api_url, IApiDataMapper iApiDataMapper)
    {
        this.restTemplate = restTemplate;
        this.iSaveApiCloudsService = iSaveApiCloudsService;
        this.iSaveApiDataService = iSaveApiDataService;
        this.iSaveApiCoordService = iSaveApiCoordService;
        this.iSaveApiMainModelService = iSaveApiMainModelService;
        this.iSaveApiSysService = iSaveApiSysService;
        this.iSaveApiWeatherService = iSaveApiWeatherService;
        this.iSaveApiWindService = iSaveApiWindService;
        this.api_url = api_url;
        this.iApiDataMapper = iApiDataMapper;
    }

    /**
     * Get called by RestApiDataController getApiDataList(), and calls the OpenWeatherApi with restTemplate.getforObject
     * so the returned JSON can be loaded into ApiDataDTO object.
     * To save the ApiDataDTO we uses the generated-source code that @IApiDataMapper (@Mapper) has generated, where
     * it maps the DTO classes to there respective Entity classes.
     *
     * It then calls the respective Entity classes services save methods to get the data saved.
     * apiData needs to be saved last because it is the owner entity. With Weather it is a little bit different
     * because it weather is a list, so ApiData has an @OnetoMany relationship with a @JoinTable with the id from
     * Weather and ApiData in it.
     *
     * We returns the ApiDataDTO, so the RestApiDataController can display our JSON.
     * @return ApiDataDTO
     * @throws JsonProcessingException
     */
    @Scheduled(fixedRateString = "600000")
    @Override
    public ApiDataDTO getAllOpenWeatherData() throws JsonProcessingException
    {
        UriComponentsBuilder uriBuilder = getUriComponentsBuilder();

        String test ="{\"coord\":{\"lon\":12.57,\"lat\":55.68},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":283.53,\"feels_like\":278.9,\"temp_min\":283.15,\"temp_max\":283.71,\"pressure\":1005,\"humidity\":81},\"visibility\":10000,\"wind\":{\"speed\":5.7,\"deg\":170},\"clouds\":{\"all\":63},\"dt\":1588012669,\"sys\":{\"type\":1,\"id\":1575,\"country\":\"DK\",\"sunrise\":1587958507,\"sunset\":1588012753},\"timezone\":7200,\"id\":2618425,\"name\":\"Copenhagen\",\"cod\":200}";
        //ApiDataDTO apiDataDTO = new ObjectMapper().readerFor(ApiDataDTO.class).readValue(test);
        ApiDataDTO apiDataDTO = restTemplate.getForObject(uriBuilder.toUriString(), ApiDataDTO.class);

        assert apiDataDTO != null;

        ApiData apiData = iApiDataMapper.apiDataDTOToApiData(apiDataDTO);

        iSaveApiCloudsService.save(apiData.getClouds());
        iSaveApiCoordService.save(apiData.getCoord());
        iSaveApiMainModelService.save(apiData.getMainModel());
        iSaveApiSysService.save(apiData.getSys());
        iSaveApiWeatherService.save(apiData.getWeatherList().get(0));
        iSaveApiWindService.save(apiData.getWind());
        iSaveApiDataService.save(apiData);
        return apiDataDTO;
    }

    /**
     * Method that makes the uri with url (api_url) and urn (id, appid, units)
     * @return UriComponentsBuilder
     */
    private UriComponentsBuilder getUriComponentsBuilder()
    {
        return UriComponentsBuilder
                    .fromUriString(api_url)
                    .queryParam("id", 2618425)
                    .queryParam("appid", "c296fe19c765289ba2b1f4ce756b35ad")
                    .queryParam("units", "metric");
    }
}
