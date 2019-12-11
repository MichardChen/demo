package com.etc.rest.service.impl;

import com.etc.rest.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ChenDang
 * @date 2019/11/17 0017
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String index() {

        //String retData = restTemplate.getForObject("http://localhost:8080/index/index",String.class);
        String retData = restTemplate.getForObject("http://orders/order/index",String.class);
        return retData;
    }
}
