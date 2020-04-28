package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller that returns the view to the user
 */
@Controller
public class ViewDataController
{
    @Autowired
    private final IApiDataService iApiDataService;

    public ViewDataController(IApiDataService iApiDataService)
    {
        this.iApiDataService = iApiDataService;
    }

    /**
     * Return what the weather is right now in a list.
     * It calls the iApiDataService.getApiDataListDTO() that has been implemented by ApiDataService
     *
     * On the HTML we use Thymeleaf to fetch out values from the DTO fields and display them
     * @param model
     * @return String
     */
    @GetMapping({"", "/", "/weather"})
    public String getApiDataListDTO(Model model)
    {
        ApiDataListDTO apiDataListDTO = iApiDataService.getApiDataListDTO();

        model.addAttribute("apiDataListDTO", apiDataListDTO);
        return "weather";
    }

    /**
     * Return what the weather was for the last 5 inserts in the database in a list
     * It calls the iApiDataService.getLast5ApiDataListDTO() that has been implemented by ApiDataService
     *
     * On the HTML we use Thymeleaf to fetch out values from the DTO fields and display them
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
