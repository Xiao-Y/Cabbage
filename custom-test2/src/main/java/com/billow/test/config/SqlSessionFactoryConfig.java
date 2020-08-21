package com.billow.test.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author liuyongtao
 * @create 2020-08-20 19:21
 */
@Configuration
public class SqlSessionFactoryConfig {

    @Resource(name = "targerDataSource")
    private DataSource targerDataSource;

    /**
     * 初始化 SqlSessionFactory，指定 mapper 路径
     *
     * @return org.apache.ibatis.session.SqlSessionFactory
     * @author LiuYongTao
     * @date 2020/8/20 19:26
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(targerDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));

        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.addInterceptor(new PaginationInterceptor());
        bean.setConfiguration(mybatisConfiguration);
        return bean.getObject();
    }
}
