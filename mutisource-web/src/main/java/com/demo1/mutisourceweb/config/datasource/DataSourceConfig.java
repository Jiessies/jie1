package com.demo1.mutisourceweb.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.demo1.jietestspringbootstarter.api.ExampleService;
import com.demo1.mutisourceweb.config.DataSourceType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Autowired
    private ExampleService exampleService;

    /**
     * 只写数据源
     *
     * @return
     */
    @Bean // 声明bean
    @ConfigurationProperties("spring.datasource.druid.write") // 获取配置文件属性
    @Primary // 防止循环依赖
    public DataSource writeDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 只读数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.read")
    public DataSource readDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源
     *
     * @param writeDataSource
     * @param readDataSource
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource(@Qualifier("writeDataSource") DataSource writeDataSource, @Qualifier("readDataSource") DataSource readDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.WRITE.name(), writeDataSource);
        targetDataSources.put(DataSourceType.READ.name(), readDataSource);
        return new DynamicDataSource(writeDataSource, targetDataSources);
    }

    /**
     * 根据数据源创建SqlSessionFactory
     * typeAliasesPackage ,mapperLocations为配置文件里面的配置信息
     * @Value("${mybatis.typeAliasesPackage}") String typeAliasesPackage,
     * @Value("${mybatis.mapperLocations}") String mapperLocations
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource,
                                               @Value("${mybatis.type-aliases-package}") String typeAliasesPackage,
                                               @Value("${mybatis.mapper-locations}") String mapperLocations) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 指定数据源(这个必须有，否则报错)
        factoryBean.setDataSource(dynamicDataSource);
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);// 指定基包
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return factoryBean.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        System.out.println(exampleService.wrap("======$$$====="));
        return new DataSourceTransactionManager(dataSource);
    }

}
