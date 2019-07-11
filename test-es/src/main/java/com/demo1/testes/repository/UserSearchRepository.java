package com.demo1.testes.repository;

import com.demo1.testes.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {
    User findUserById(Long id);
}
