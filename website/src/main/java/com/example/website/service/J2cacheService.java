package com.example.website.service;

/**
 * @author ChenDang
 * @date 2019/6/28 0028
 */
public interface J2cacheService {

    public String addCache(String key,String value);

    public String queryCache(String type);

    public String getKey(String key);

    public String deleteKey(String key);
}
