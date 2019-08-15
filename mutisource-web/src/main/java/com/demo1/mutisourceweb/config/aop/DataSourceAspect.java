package com.demo1.mutisourceweb.config.aop;

import com.demo1.mutisourceweb.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 针对带有数据源类型注解方法的切面
 */
@Aspect
@Component
@Order(-10) // 保证该AOP在@Transactional之前执行
public class DataSourceAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.demo1.mutisourceweb.config.aop.DataSourceTypeAnnotation)")
    public void pointCut() {
    }


    /**
     * 环绕通知
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object aspectPointBefor(ProceedingJoinPoint point) throws Throwable {
        // 获取该切点（带该注解）的方法
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        // 获取真正调用的方法（serviceImpl）/**此处容易遗漏出错*/
//        Method relmethod = point.getTarget().getClass()
//                .getMethod(point.getSignature().getName(), method.getParameterTypes());
        // 获取该方法(serviceImpl)上的注解
        DataSourceTypeAnnotation annotation = method.getAnnotation(DataSourceTypeAnnotation.class);
        if (annotation != null) {
            // 设置该方法的数据源类型
            logger.info("数据源{}注解值", annotation.value());
            // 获取serviceImpl方法上的自定义数据源注解名称值放入ThreadLocal中
            DynamicDataSourceContextHolder.setDateSoureType(annotation.value());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDateSoureType();
        }
    }
}
