package com.gwt.gwt.server.controllers;

public abstract class BaseController {

    //Base url
    private static final String BASE_URL = "/api";

    //Api save data and create list
    public static final String SAVE_DATA = BASE_URL + "/savedata/{data}";

    //Api get list
    public static final String GET_LIST = BASE_URL + "/get_list";

    //Api sort list
    public static final String SORT_LIST = BASE_URL + "/sort_list/{sortway}";

}
