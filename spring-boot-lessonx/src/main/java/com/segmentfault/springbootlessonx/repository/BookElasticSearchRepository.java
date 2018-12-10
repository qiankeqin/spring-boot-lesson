package com.segmentfault.springbootlessonx.repository;

import com.segmentfault.springbootlessonx.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.MappingElasticsearchEntityInformation;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-09 08:36
 **/
@Repository("bookRepository1")
public class BookElasticSearchRepository extends AbstractElasticsearchRepository<Book,String>{

    /**
     * 从容器中获取到ElasticSearchOperations，并注入
     * @param elasticsearchOperations
     */
    @Autowired
    public BookElasticSearchRepository(ElasticsearchOperations elasticsearchOperations) {
        super(createElasticsearchEntityInformation(),elasticsearchOperations);
        super.setEntityClass(Book.class);
    }

    private static ElasticsearchEntityInformation<Book,String> createElasticsearchEntityInformation() {
        TypeInformation<Book> typeInformation = ClassTypeInformation.from(Book.class);
        ElasticsearchPersistentEntity<Book> elasticsearchPersistentEntity = new SimpleElasticsearchPersistentEntity(typeInformation);
        ElasticsearchEntityInformation<Book, String> entityInformation= new MappingElasticsearchEntityInformation<>(elasticsearchPersistentEntity);
        return entityInformation;

    }

    @Override
    protected String stringIdRepresentation(String s) {
        return s;
    }
}
