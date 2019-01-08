package com.zc.common.config;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 由于目前不知道如何在yml中配置druid的Spring Stat监控
 * 所以暂时使用当前类暂代.
 */
@Configuration
public class SpringStatAOP {

    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
        return dsInterceptor;
    }

    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        /**
         * // 不知为何此处代码不生效
         * // 监控的类所在的包名，多个包名用 英文逗号 隔开.
         * // pointcut.setPattern("com.zc.controller.*");
         * // pointcut.setPatterns("com.zc.controller.*,com.zc.service.*,com.zc.service.*.*,com.zc.mapper.*.*");
         */
        /**
         * # 在yml配置以下属性与当前类进行搭配使用
         * spring:
         *   aop:
         *     auto: true
         *     proxy-target-class: true
         *   datasource:
         *     druid:
         *       # Spring监控AOP切入点，如x.y.z.service.*,配置多个英文逗号分隔
         *       aop-patterns: com.zc.controller.*,com.zc.service.*,com.zc.service.*.*,com.zc.mapper.*.*
         */
        return pointcut;
    }

    @Bean
    public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
        DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
        defaultPointAdvisor.setPointcut(druidStatPointcut);
        defaultPointAdvisor.setAdvice(druidStatInterceptor);
        return defaultPointAdvisor;
    }

}
