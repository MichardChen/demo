package com.etc.component.solr.entity;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * solr new_core实体类
 * @author ChenDang
 * @date 2019/9/6 0006
 */
@Data
@SolrDocument(solrCoreName = "new_core")
public class News {

    @Id
    @Field
    private String id;

    @Field
    private String title;
}

