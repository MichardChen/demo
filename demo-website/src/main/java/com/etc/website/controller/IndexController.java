package com.etc.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.etc.base.util.HttpClientUtils;
import com.etc.website.service.J2cacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    J2cacheService j2cacheService;
    /*@Autowired
    BusinessLogRecordService businessLogRecordService;*/
    @Autowired
    GridFsTemplate gridFsTemplate;
   /* @Autowired
    SolrUtil solrUtil;*/

    @RequestMapping("/j2cache")
    public String j2cache(@RequestParam("key")String key,@RequestParam("value")String value){
        return j2cacheService.addCache(key,value);
    }

    @RequestMapping("/queryCache")
    public String queryRedis(@RequestParam("type")String type){
        return j2cacheService.queryCache(type);
    }

    @RequestMapping("/getKey")
    public String getKey(@RequestParam("key")String key){
        return j2cacheService.getKey(key);
    }

    @RequestMapping("/deleteKey")
    public String deleteKey(@RequestParam("key")String key){
        return j2cacheService.deleteKey(key);
    }

   /* @RequestMapping("/count")
    public String count(){
        return businessLogRecordService.count();
    }

    @RequestMapping("/saveFile")
    public String saveFile(){
        return businessLogRecordService.count();
    }*/

    @RequestMapping("/test")
    public String test(){
        JSONObject ret = HttpClientUtils.httpGet("http://localhost:8088/test");
        return ret.toJSONString();
    }

   /* @RequestMapping("/solr")
    public String query() throws Exception{
        return solrUtil.queryById("100");
    }

    @RequestMapping("/solrUpdate")
    public String solrUpdate() throws Exception{
        News news = new News();
        news.setId("100");
        news.setTitle("更新测试title");
        return solrUtil.update(news);
    }*/

   /* @RequestMapping("/solrAll")
    public String solrAll() throws Exception{
        List<News> list = solrUtil.queryAllList();
        for(News news : list){
            System.out.println(news.getId()+":"+news.getTitle());
        }
        return "query all ok";
    }*/
}
