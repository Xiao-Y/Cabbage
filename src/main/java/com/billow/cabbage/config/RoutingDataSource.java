package com.billow.cabbage.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 设置数据源
 *
 * @author liuyongtao
 * @create 2020-08-20 19:08
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.get();
    }
}
