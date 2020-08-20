package com.billow.cabbage.aop;

import com.billow.cabbage.config.DbContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 通过aop切换数据源
 *
 * @author liuyongtao
 * @create 2020-08-20 19:47
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("execution(* com.billow.cabbage.service..*.find*(..)) " +
            "|| execution(* com.billow.cabbage.service..*.select*(..))" +
            " || execution(* com.billow.cabbage.service..*.get*(..))")
    public void readPointcut() {
    }

    @Pointcut("execution(* com.billow.cabbage.service..*.delete*(..)) " +
            "|| execution(* com.billow.cabbage.service..*.remove*(..))" +
            " || execution(* com.billow.cabbage.service..*.update*(..))" +
            "|| execution(* com.billow.cabbage.service..*.add*(..))" +
            "|| execution(* com.billow.cabbage.service..*.inster*(..))")
    public void writePointcut() {
    }

    @Before("readPointcut()")
    public void read() {
        DbContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DbContextHolder.master();
    }
}
