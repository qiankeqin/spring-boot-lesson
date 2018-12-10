package com.segmentfault.springbootlessonx;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-07 15:42
 **/
@Configuration
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")
public class ElasticSearchConfiguration {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(){
        NodeBuilder nodeBuilder = nodeBuilder();
        nodeBuilder.settings().put("path.home",System.getenv("ES_HOME"));
        return new ElasticsearchTemplate(nodeBuilder.local(true).node().client());
    }
}
