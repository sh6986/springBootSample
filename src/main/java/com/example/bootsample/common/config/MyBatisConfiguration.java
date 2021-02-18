package com.example.bootsample.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.bootsample")
public class MyBatisConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        // sqlSessionFactory 객체 생성
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // sqlSessionFactory 객체에 DataSource 객체 넣어준다.
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 리소스 경로 객체
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 패턴으로 표현되는 범위로부터 클래스들의 리소스 정보를 읽어들여서
        // sqlSessionFactoryBean 객체에 mapper 경로를 넣어준다.
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    // 핵심적인 역할은 하는 클래스로서 SQL 실행이나 트랜잭션 관리 실행한다.
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {

        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionTemplate;
    }

}
