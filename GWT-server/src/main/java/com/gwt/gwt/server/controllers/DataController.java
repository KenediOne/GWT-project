package com.gwt.gwt.server.controllers;

import com.gwt.gwt.server.service.DataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController extends BaseController{

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value = BaseController.SAVE_DATA, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> saveData(
            @PathVariable("data") int data
    ) {
        return dataService.createList(data);
    }

    @GetMapping(value = BaseController.GET_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getList(
    ) {
        return dataService.getList();
    }

    @GetMapping(value = BaseController.SORT_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> sortList(
            @PathVariable("sortway") boolean sortway
    ) {
        return dataService.sortList(sortway);
    }


}
