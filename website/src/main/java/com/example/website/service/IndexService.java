package com.example.website.service;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
public interface IndexService {

    public String delete(String id);

    public String queryRedis(String type);

    public String getKey(String key);
}
