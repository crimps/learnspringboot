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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author crimps
 * @create 2017-11-16 13:58
 **/
@Configuration
@MapperScan(basePackages = "com.crimps.learnspringboot.mapper.databack", sqlSessionTemplateRef = "springbootbackSqlSessionTemplate")
public class DataSourceBackConfig {
    private final String mybatisPath = "classpath:mybatis/mapper/databack/*.xml";

    @Bean(name = "springbootbackDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.springbootback")
    public DataSource springbootbackDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "springbootbackSqlSessionFactory")
    public SqlSessionFactory springbootbackSqlSessionFactory(@Qualifier("springbootbackDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisPath));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "springbootbackTransactionManager")
    public DataSourceTransactionManager springbootTransactionManager(@Qualifier("springbootbackDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "springbootbackSqlSessionTemplate")
    public SqlSessionTemplate springbootSessionTemplate(@Qualifier("springbootbackSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
