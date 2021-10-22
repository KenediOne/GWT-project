package com.gwt.gwt.server.service;

import java.util.List;

public interface DataService {

    List<Integer> getList();

    List<Integer> createList(int data);

    List<Integer> sortList(boolean variable);

}
