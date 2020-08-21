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

1.2 sqlSessionFactory 注入mapper 文件的位置 
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

1.3 启动类中添加扫描
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