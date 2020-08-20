package com.billow.cabbage.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 *
 * @author liuyongtao
 * @create 2020-08-20 19:11
 */
@Configuration
public class DataSourceConfig {

    /**
     * 主数据源
     *
     * @return javax.sql.DataSource
     * @author LiuYongTao
     * @date 2020/8/20 19:13
     */
    @Bean("masterDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 从库数据源1
     *
     * @return javax.sql.DataSource
     * @author LiuYongTao
     * @date 2020/8/20 19:14
     */
    @Bean("slave1DataSource")
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 从库数据源2
     *
     * @return javax.sql.DataSource
     * @author LiuYongTao
     * @date 2020/8/20 19:14
     */
    @Bean("slave2DataSource")
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 添加数据源
     *
     * @param masterDataSource
     * @param slave1DataSource
     * @param slave2DataSource
     * @return javax.sql.DataSource
     * @author LiuYongTao
     * @date 2020/8/20 19:21
     */
    @Bean("targerDataSource")
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                          @Qualifier("slave2DataSource") DataSource slave2DataSource) {
        Map<Object, Object> targerDataSource = new HashMap<>();
        targerDataSource.put(DbTypeEunm.MASTER, masterDataSource);
        targerDataSource.put(DbTypeEunm.SLAVE1, slave1DataSource);
        targerDataSource.put(DbTypeEunm.SLAVE2, slave2DataSource);

        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        routingDataSource.setTargetDataSources(targerDataSource);
        return routingDataSource;
    }
}
