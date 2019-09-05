package com.etc.component.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public String add(Object id,Object title) throws Exception{

        SolrInputDocument document = new SolrInputDocument();
        document.setField("id",id);
        document.setField("title",title);
        //这里的collection就相当于数据库的概念
        solrClient.add("new_core",document);
        //记住要commint,不然数据不会提交
        solrClient.commit("new_core");
        return "add ok";
    }

    public String delete(String id) throws Exception{
        solrClient.deleteById("new_core",id);
        solrClient.commit("new_core");
        return "delete ok";
    }

    public String queryById(String id) throws Exception{
        SolrDocument document = solrClient.getById("new_core",id);
        return document.toString();
    }
}
