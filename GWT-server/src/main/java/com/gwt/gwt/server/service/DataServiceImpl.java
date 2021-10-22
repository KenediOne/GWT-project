package com.gwt.gwt.server.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    private List<Integer> integerList;

    @Override
    public List<Integer> getList() {
        return integerList;
    }

    @Override
    public List<Integer> createList(int data) {
        integerList = new ArrayList<>();
        for(int i = 0;i<=1000;i++){
            integerList.add(i);
        }
        Collections.shuffle(integerList);
        integerList = integerList.subList(0,data);
        return integerList;
    }

    @Override
    public List<Integer> sortList(boolean variable) {
        if(variable){
            Collections.sort(integerList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        }else {
            Collections.sort(integerList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
        }
        return null;
    }

}
