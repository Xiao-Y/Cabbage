package com.billow.custom.aop;

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

    @Pointcut("execution(* com.billow.*.service..*.find*(..)) " +
            "|| execution(* com.billow.*.service..*.select*(..))" +
            "|| execution(* com.billow.*.service..*.list*(..))" +
            "|| execution(* com.billow.*.service..*.page*(..))" +
            "|| execution(* com.billow.*.service..*.count*(..))" +
            "|| execution(* com.billow.*.service..*.query*(..))" +
            " || execution(* com.billow.*.service..*.get*(..))")
    public void readPointcut() {
    }

    @Pointcut("execution(* com.billow.*.service..*.delete*(..)) " +
            "|| execution(* com.billow.*.service..*.remove*(..))" +
            " || execution(* com.billow.*.service..*.update*(..))" +
            "|| execution(* com.billow.*.service..*.add*(..))" +
            "|| execution(* com.billow.*.service..*.save*(..))" +
            "|| execution(* com.billow.*.service..*.inster*(..))")
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
