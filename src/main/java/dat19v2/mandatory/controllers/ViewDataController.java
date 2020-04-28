package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewDataController
{
    private final IApiDataService iApiDataService;

    public ViewDataController(IApiDataService iApiDataService)
    {
        this.iApiDataService = iApiDataService;
    }

    @GetMapping({"", "/", "/weather"})
    public String getApiDataList(Model model, @RequestParam(defaultValue = "0") Integer firstPageNumber,
                                 @RequestParam(defaultValue = "1") Integer pageSize,
                                 @RequestParam(defaultValue = "createDate") String sortBy)
    {
        ApiDataListDTO apiDataListDTO = iApiDataService.getApiDataListDTO(firstPageNumber, pageSize, sortBy);

        model.addAttribute("apiDataListDTO", apiDataListDTO);
        return "weather";
    }

    @GetMapping({"/historic"})
    public String getLast5ApiDataListDTO(Model model, @RequestParam(defaultValue = "0") Integer pageNumber,
                                 @RequestParam(defaultValue = "5") Integer pageSize,
                                 @RequestParam(defaultValue = "createDate") String sortBy)
    {

        ApiDataListDTO historicLast5ApiDataListDTO = iApiDataService.getLast5ApiDataListDTO(pageNumber, pageSize, sortBy);
        model.addAttribute("historicLast5ApiDataListDTO", historicLast5ApiDataListDTO);
        return "historic";
    }
}
