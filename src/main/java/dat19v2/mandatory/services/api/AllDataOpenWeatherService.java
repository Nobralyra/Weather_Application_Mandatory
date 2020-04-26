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

import java.util.List;

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

    @Scheduled(fixedRateString = "600000")
    @Override
    public ApiDataDTO getAllOpenWeatherData() throws JsonProcessingException
    {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("id", 2618425)
                .queryParam("appid", "c296fe19c765289ba2b1f4ce756b35ad");

        String test = "{\"coord\":{\"lon\":12.57,\"lat\":55.68},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":283.23,\"feels_like\":275.82,\"temp_min\":282.15,\"temp_max\":284.26,\"pressure\":1016,\"humidity\":66},\"visibility\":10000,\"wind\":{\"speed\":8.7,\"deg\":290},\"clouds\":{\"all\":59},\"dt\":1586943853,\"sys\":{\"type\":1,\"id\":1575,\"country\":\"DK\",\"sunrise\":1586923432,\"sunset\":1586974502},\"timezone\":7200,\"id\":2618425,\"name\":\"Copenhagen\",\"cod\":200}";

        ApiDataDTO apiDataDTO = new ObjectMapper().readerFor(ApiDataDTO.class).readValue(test);
        //ApiDataDTO apiDataDTO = restTemplate.getForObject(uriBuilder.toUriString(), ApiDataDTO.class);

        assert apiDataDTO != null;
        System.out.println(apiDataDTO.toString());
        System.out.println(apiDataDTO.getCloudsDTO());
        System.out.println(apiDataDTO.getWeatherDTOList().get(0));

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
}
