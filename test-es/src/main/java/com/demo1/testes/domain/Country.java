package com.demo1.testes.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
@Document(indexName = "word", type = "country")
public class Country implements Serializable {

    @Id
    private Integer id;

    @Field(searchAnalyzer = "ik_max_word", analyzer = "ik_smart")
    private String name;
}
