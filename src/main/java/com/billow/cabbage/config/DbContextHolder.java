package com.billow.cabbage.config;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用于动态切换数据源
 *
 * @author liuyongtao
 * @create 2020-08-20 14:52
 */
@Slf4j
public class DbContextHolder {

    /**
     * 确保创建的变量只被一个线程进行读写操作
     */
    private final static ThreadLocal<DbTypeEunm> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 原子操作类，确保线程安全
     */
    private final static AtomicInteger COUNTER = new AtomicInteger(0);

    /**
     * 设置当前的枚举值
     *
     * @param dbTypeEunm
     * @return void
     * @author LiuYongTao
     * @date 2020/8/20 18:59
     */
    public static void set(DbTypeEunm dbTypeEunm) {
        CONTEXT_HOLDER.set(dbTypeEunm);
    }

    /**
     * 获取当前线程的枚举值
     *
     * @return com.billow.cabbage.config.DbTypeEunm
     * @author LiuYongTao
     * @date 2020/8/20 18:59
     */
    public static DbTypeEunm get() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 移除当前线程的枚举值
     *
     * @return void
     * @author LiuYongTao
     * @date 2020/8/20 19:00
     */
    public static void remove() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 切换主库
     *
     * @return void
     * @author LiuYongTao
     * @date 2020/8/20 19:01
     */
    public static void master() {
        set(DbTypeEunm.MASTER);
        log.info("========>>>>>>>> 切换到主库：{}", DbTypeEunm.MASTER);
    }

    /**
     * 切换到从库
     *
     * @return void
     * @author LiuYongTao
     * @date 2020/8/20 19:03
     */
    public static void slave() {
        int index = COUNTER.getAndIncrement() % (DbTypeEunm.values().length - 1);

        if (COUNTER.get() > 9999) {
            COUNTER.set(0);
        }
        // 设置从库
        DbTypeEunm dbTypeEunm = DbTypeEunm.values()[index + 1];
        set(dbTypeEunm);
        log.info("========>>>>>>>> 切换到从库：{}", dbTypeEunm);
    }
}
