package com.billow.test.aop;

import com.billow.custom.config.DbContextHolder;
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

    @Pointcut("execution(* com.billow.test.service..*.find*(..)) " +
            "|| execution(* com.billow.test.service..*.select*(..))" +
            " || execution(* com.billow.test.service..*.get*(..))")
    public void readPointcut() {
    }

    @Pointcut("execution(* com.billow.test.service..*.delete*(..)) " +
            "|| execution(* com.billow.test.service..*.remove*(..))" +
            " || execution(* com.billow.test.service..*.update*(..))" +
            "|| execution(* com.billow.test.service..*.add*(..))" +
            "|| execution(* com.billow.test.service..*.inster*(..))")
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
