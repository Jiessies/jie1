package com.demo1.mutisourceweb.config.aop;


import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSourceTypeAnnotation {

    /**
     * 切换数据源名称
     */
    String value() default "";
}
