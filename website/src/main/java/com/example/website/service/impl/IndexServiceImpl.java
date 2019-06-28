package com.example.website.service.impl;

import com.example.website.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String delete(String id) {

        String body = "";
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        if(redisTemplate.hasKey(id)){
            body = ops.get(id);
        }else{
            body = "8888";
            ops.set(id,body);
        }
        return body;
    }
}
