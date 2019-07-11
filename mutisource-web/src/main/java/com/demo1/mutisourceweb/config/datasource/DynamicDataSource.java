package com.demo1.mutisourceweb.config.datasource;

import com.demo1.mutisourceweb.config.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        // 获取切面放在ThreadLocal里面的目标数据源名称，作为本次请求操作的数据源
        return DynamicDataSourceContextHolder.getDateSoureType();
    }
}
