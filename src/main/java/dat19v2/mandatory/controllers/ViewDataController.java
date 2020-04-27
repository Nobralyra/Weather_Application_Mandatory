package dat19v2.mandatory.controllers;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.services.view.IApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    public String dateAndTimeFormat(long longDateAndTimeFormat)
    {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date(longDateAndTimeFormat));
    }

    public String timeFormat(long longtimeFormat)
    {
        return new SimpleDateFormat("HH:mm").format(new Date(longtimeFormat));
    }
}
