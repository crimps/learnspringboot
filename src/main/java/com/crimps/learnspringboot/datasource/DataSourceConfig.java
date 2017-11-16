package com.crimps.learnspringboot.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author crimps
 * @create 2017-11-16 11:10
 **/
@Configuration
@MapperScan(basePackages = "com.crimps.learnspringboot.mapper.data", sqlSessionTemplateRef = "springbootSqlSessionTemplate")
public class DataSourceConfig {
    private final String mybatisPath = "classpath:mybatis/mapper/data/*.xml";

    @Bean(name = "springbootDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.springboot")
    @Primary
    public DataSource springbootDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "springbootSqlSessionFactory")
    @Primary
    public SqlSessionFactory springbootSqlSessionFactory(@Qualifier("springbootDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisPath));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "springbootTransactionManager")
    @Primary
    public DataSourceTransactionManager springbootTransactionManager(@Qualifier("springbootDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "springbootSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate springbootSessionTemplate(@Qualifier("springbootSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
