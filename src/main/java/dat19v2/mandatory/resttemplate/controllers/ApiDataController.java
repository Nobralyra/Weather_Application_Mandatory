package dat19v2.mandatory.resttemplate.controllers;

import dat19v2.mandatory.resttemplate.services.IApiDataService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ApiDataController
{
    public ApiDataController(IApiDataService iApiDataService)
    {
        this.iApiDataService = iApiDataService;
    }

    private final IApiDataService iApiDataService;


    @GetMapping({"", "/", "/weather"})
    @ResponseStatus(HttpStatus.OK)
    public String getApiDataList(Model model)
    {
        model.addAttribute("weather", iApiDataService.getApiData());
        return "/weather";
    }
}
