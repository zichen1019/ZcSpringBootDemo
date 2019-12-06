package com.zc.common.config.Druid;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 此处为注解MapperScan注释
 *
 * @MapperScan 若使用通用Mapper，则此处导包必须是：import tk.mybatis.spring.annotation.MapperScan;
 */
@Configuration
@MapperScan(basePackages = "com.zc.mapper.primary", sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class DuridDataSourceBuilderPrimary {

    /**
     * @return
     * @Bean 将当前方法返回值作为对象
     * @ConfigurationProperties 从application.yml中获取前缀为spring.datasource.druid.primary的数据配置到当前方法中
     */
    @Bean(name = "primaryDruidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.primary")
    @Primary
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     * @Qualifier 使用注解方式将DataSource的Bean对象primaryDruidDataSource注入到方法参数当中
     * @Primary 代表当前是默认的数据源
     */
    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDruidDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper-xml/primary/*.xml"));//指定mapper.xml路径
        return bean.getObject();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDruidDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
