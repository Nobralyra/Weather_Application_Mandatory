package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.api.domain.ApiDataListDTO;
import dat19v2.mandatory.api.domain.CloudsDTO;
import dat19v2.mandatory.api.domain.CloudsListDTO;
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

        ArrayList<ApiDataListDTO> apiDataListDTO = iApiDataService.getApiDataListDTO();
        model.addAttribute("apiDataAll", cloudsListDTO);
        return "weather";
    }
}
