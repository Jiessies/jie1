package com.demo1.testmongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Authority {
    @Id
    private String id;
    @Field("authority_name")
    private String name;
}
