package com.billow.test;

import com.billow.test.service.GoodsBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuyongtao
 * @create 2020-08-20 19:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CabbageApp.class)
public class GoodsBrandServiceTest {

    @Autowired
    private GoodsBrandService goodsBrandService;

    @Test
    public void findList() {
        goodsBrandService.findTest();
    }

    @Test
    public void save() {
        goodsBrandService.saveTest();
    }
}
