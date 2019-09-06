package com.etc.component.solr;

import com.etc.component.solr.entity.News;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Solr作为独立的企业搜索应用服务器，它对外提供类似于
 * webservice的接口，用户可以通过http请求，向搜索引擎
 * 服务器提交一定格式的xml文件，生成索引，也可以通过
 * http get提出查找请求，并得到xml的返回结果。
 * @author ChenDang
 * @date 2019/9/5 0005
 */
@Component
public class SolrUtil {

    @Autowired
    private SolrClient solrClient;

    /**
     * 添加
     * @param news
     * @return
     * @throws Exception
     */
    public String add(News news) throws Exception{

        SolrInputDocument document = new SolrInputDocument();
        document.setField("id",news.getId());
        document.setField("title",news.getTitle());
        //这里的collection就相当于数据库的概念
        solrClient.add("new_core",document);
        //记住要commint,不然数据不会提交
        solrClient.commit("new_core");
        return "add ok";
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    public String delete(String id) throws Exception{
        solrClient.deleteById("new_core",id);
        solrClient.commit("new_core");
        return "delete ok";
    }

    /**
     * 查询
     * @param id
     * @return
     * @throws Exception
     */
    public String queryById(String id) throws Exception{
        SolrDocument document = solrClient.getById("new_core",id);
        return document.toString();
    }

    /**
     * 更新
     * @param news
     * @return
     * @throws Exception
     */
    public String update(News news) throws Exception{

        SolrInputDocument document = new SolrInputDocument();
        document.setField("id",news.getId());
        document.setField("title",news.getTitle());
        solrClient.add("new_core",document);
        solrClient.commit("new_core");
        return "update ok";
    }

    public List<News> queryList() throws Exception{
        List<News> list = new ArrayList<>();
        ModifiableSolrParams params = new ModifiableSolrParams();
        //查询条件,*:*代表所有属性所有值
        params.set("q","*:*");
        //分页，start=0就是从0开始，rows=5当前返回5条记录
        params.set("start",0);
        params.set("rows",Integer.MAX_VALUE);
        //排序
        params.set("sort","id");

        QueryResponse response = solrClient.query(params);
        SolrDocumentList documents = response.getResults();
        News news = null;
        for(SolrDocument d : documents){
            news.setId((String)d.getFieldValue("id"));
            news.setTitle((String)d.getFieldValue("title"));
            list.add(news);
        }
        return list;
    }

    public List<News> queryAllList() throws Exception{
        List<News> list = new ArrayList<>();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");


        QueryResponse response = solrClient.query(query);
        if(response != null){
            list = response.getBeans(News.class);
        }
        return list;
    }
}
