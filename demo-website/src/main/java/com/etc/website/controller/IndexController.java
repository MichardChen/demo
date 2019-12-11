package com.etc.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.etc.base.util.HttpClientUtils;
import com.etc.website.service.J2cacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@Api(value = "index接口")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @Autowired
    J2cacheService j2cacheService;
    /*@Autowired
    BusinessLogRecordService businessLogRecordService;*/
    @Autowired
    GridFsTemplate gridFsTemplate;
   /* @Autowired
    SolrUtil solrUtil;*/

    /**
     * 使用@PostMapping和@GetMapping可以禁用tomcat不安全的请求方法，
     * 但是使用@RequestMapping则不能禁用，所以需要配置下bean
     * @param key
     * @param value
     * @return
     */
   @ApiOperation("j2cache存储")
   @ApiImplicitParams({
   @ApiImplicitParam(name = "key",value = "存储key", paramType="query",required = true,dataType = "String"),
    @ApiImplicitParam(name = "value",value = "存储value", paramType="query",required = true,dataType = "String")})
    @PostMapping("/j2cache")
    public String j2cache(@RequestParam("key")String key,@RequestParam("value")String value){
        return j2cacheService.addCache(key,value);
    }

    @PostMapping("/queryCache")
    public String queryRedis(@RequestParam("type")String type){
        return j2cacheService.queryCache(type);
    }

    @PostMapping("/getKey")
    public String getKey(@RequestParam("key")String key){
        return j2cacheService.getKey(key);
    }

    @PostMapping("/deleteKey")
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

    @PostMapping("/test")
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


   @GetMapping("/orders")
   public String orders(){
       ServiceInstance serviceInstance = this.loadBalancerClient.choose("orders");
       return serviceInstance.getHost()+":"+serviceInstance.getPort();
   }
}
