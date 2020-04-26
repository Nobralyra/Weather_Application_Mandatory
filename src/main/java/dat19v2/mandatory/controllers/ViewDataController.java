package dat19v2.mandatory.controllers;

import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("weather", iApiDataService.getApiDataListDTO());
        return "/weather";
    }
}
