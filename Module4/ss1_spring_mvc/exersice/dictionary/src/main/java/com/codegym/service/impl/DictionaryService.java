package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    @Override
    @Autowired
    public Map<String, String> search() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("school", "Trường học");
        map.put("car", "Xe");
        map.put("dog", "Con chó");
        return map;
    }
}
