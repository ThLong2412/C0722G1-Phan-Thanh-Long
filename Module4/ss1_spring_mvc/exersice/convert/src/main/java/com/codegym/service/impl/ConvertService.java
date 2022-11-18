package com.codegym.service.impl;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public Double convert(double usd) {
       double vnd = usd * 22000;
        return vnd ;
    }

}
