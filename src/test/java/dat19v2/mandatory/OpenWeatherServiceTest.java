package dat19v2.mandatory;

import dat19v2.mandatory.services.view.IApiDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OpenWeatherServiceTest
{
    @Autowired
    IApiDataService iApiDataService;

    @Test
    void testGetWeatherDatas()
    {
        /*
        ApiDataWeather apiDataDTO = new ApiDataWeather();
        List<ApiData> apiData = iApiDataService.getWeatherDatas();
        List<ApiDataWeather> list1 = new ArrayList<>();
        list1.add("{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 800,\n" +
                "      \"mainModel\": \"Clear\",\n" +
                "      \"description\": \"clear sky\",\n" +
                "      \"icon\": \"01n\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"base\": \"stations\",\n" +
                "  \"mainModel\": {\n" +
                "    \"temp\": 281.52,\n" +
                "    \"feels_like\": 278.99,\n" +
                "    \"temp_min\": 280.15,\n" +
                "    \"temp_max\": 283.71,\n" +
                "    \"pressure\": 1016,\n" +
                "    \"humidity\": 93\n" +
                "  },\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 0.47,\n" +
                "    \"deg\": 107.538\n" +
                "  },\n" +
                "  \"clouds\": {\n" +
                "    \"all\": 2\n" +
                "  },\n" +
                "  \"dt\": 1560350192,\n" +
                "  \"sys\": {\n" +
                "    \"type\": 3,\n" +
                "    \"id\": 2019346,\n" +
                "    \"message\": 0.0065,\n" +
                "    \"country\": \"JP\",\n" +
                "    \"sunrise\": 1560281377,\n" +
                "    \"sunset\": 1560333478\n" +
                "  },\n" +
                "  \"timezone\": 32400,\n" +
                "  \"id\": 1851632,\n" +
                "  \"name\": \"Shuzenji\",\n" +
                "  \"cod\": 200\n" +
                "}");
        assertEquals(list1, apiData);

         */
    }
}