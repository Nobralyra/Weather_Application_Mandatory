package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        model.addAttribute("apiDataListDTO", apiDataListDTO);
        return "weather";
    }

    @GetMapping({"/historic"})
    public String getLast5ApiDataListDTO(Model model)
    {
        ApiDataListDTO historicLast5ApiDataListDTO = iApiDataService.getLast5ApiDataListDTO();
        model.addAttribute("historicLast5ApiDataListDTO", historicLast5ApiDataListDTO);
        return "historic";
    }
}
