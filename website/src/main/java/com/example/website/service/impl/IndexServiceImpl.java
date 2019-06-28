package com.example.website.service.impl;

import com.example.website.service.IndexService;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CacheChannel cacheChannel;

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

    @Override
    public String queryRedis(String type) {

        StringBuilder sb = new StringBuilder();
        if("1".equals(type)){
            System.out.println("ehcache缓存==================");
            //CacheProvider l1 = cacheChannel.getL1Provider();
            Collection<String> keys = cacheChannel.keys("Euser");
            for(String key : keys){
                sb.append("key:"+key+",value:"+cacheChannel.get("Euser",key));
            }
        }else if("2".equals(type)){
            System.out.println("redis二级缓存================");
            //CacheProvider l2 = cacheChannel.getL2Provider();
            Collection<String> keys = cacheChannel.keys("Euser");
            for(String key : keys){
                sb.append("key:"+key+",value:"+cacheChannel.get("Euser",key));
            }
        }
        return sb.toString();
    }

    @Override
    public String getKey(String key) {
        Object v = cacheChannel.get("Euser",key);
        String l1 = "";
        if(v == null){
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            l1 = ops.get("j2cache:Euser:"+key);
        }else{
            l1 = v.toString();
        }
        return l1;
    }
}
