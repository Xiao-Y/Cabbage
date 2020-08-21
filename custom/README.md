# 读写分离实现
## 1. 自己实现（custom 模块,custom-test为测试模块）
使用：

1.1 引入 pom
```xml
    <dependency>
        <groupId>com.billow</groupId>
        <artifactId>custom</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
```

1.2 添加配置通过AOP 拦截：
```java
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
```

1.3 sqlSessionFactory 注入mapper 文件的位置 
```java
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

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(targerDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }
}
```

1.4 启动类中添加扫描
```java
/**
 * 启动
 *
 * @author liuyongtao
 * @create 2020-08-20 14:35
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.billow.custom", "com.billow.test"})
public class CabbageApp {

    public static void main(String[] args) {
        SpringApplication.run(CabbageApp.class, args);
    }
}
```