package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller that returns the view to the user
 */
@Controller
public class ViewDataController
{
    private final IApiDataService iApiDataService;

    public ViewDataController(IApiDataService iApiDataService)
    {
        this.iApiDataService = iApiDataService;
    }

    /**
     * Return what the weather is right now in a list
     * @param model
     * @return String
     */
    @GetMapping({"", "/", "/weather"})
    public String getApiDataList(Model model)
    {
        ApiDataListDTO apiDataListDTO = iApiDataService.getApiDataListDTO();

        model.addAttribute("apiDataListDTO", apiDataListDTO);
        return "weather";
    }

    /**
     * Return what the weather was for the last 5 inserts in the database in a list
     * @param model
     * @return String
     */
    @GetMapping({"/historic"})
    public String getLast5ApiDataListDTO(Model model)
    {
        ApiDataListDTO historicLast5ApiDataListDTO = iApiDataService.getLast5ApiDataListDTO();

        model.addAttribute("historicLast5ApiDataListDTO", historicLast5ApiDataListDTO);
        return "historic";
    }
}
