package com.demo1.testes.domain;

import com.demo1.testes.constant.ElasticsearchConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Document(indexName = ElasticsearchConstant.USER_INDEX, type = ElasticsearchConstant.USER_INDEX_TYPE)
public class User extends BaseEntity {
    private String username;
    private String password;
    private Date createDate;
    private String remark;
}
