package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ViewDataController
{
    private final IApiDataService iApiDataService;

    public ViewDataController(IApiDataService iApiDataService)
    {
        this.iApiDataService = iApiDataService;
    }

    @GetMapping({"", "/", "/weather"})
    public String getApiDataList(Model model)
    {

        ApiDataListDTO apiDataListDTO = iApiDataService.getApiDataListDTO();
        ApiDataDTO apiDataDTO = apiDataListDTO.getApiDataDTOList().get(0);
        WeatherDTO weatherDTO = apiDataDTO.getWeatherDTOList().get(0);
        String img = apiDataDTO.getWeatherDTOList().get(0).getIcon();
        double windDTO = apiDataDTO.getWindDTO().getDeg();
        model.addAttribute("img", img);
        model.addAttribute("windDTO", windDTO);
        model.addAttribute("weatherDTO", weatherDTO);
        return "weather";
    }
}
