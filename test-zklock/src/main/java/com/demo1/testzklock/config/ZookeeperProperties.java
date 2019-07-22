package com.demo1.testzklock.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {

    private int baseSleepTimeMs;
    private int maxRetries;
    private String connectString;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
}
