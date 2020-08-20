package com.billow.cabbage;

import com.billow.cabbage.dto.GoodsBrandPo;
import com.billow.cabbage.service.GoodsBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public void findList() {
        List<GoodsBrandPo> list = goodsBrandService.findList();
        System.out.println(list);

        list = goodsBrandService.findList();
        System.out.println(list);

        GoodsBrandPo po = new GoodsBrandPo();
        po.setId("1293712908815839233");
        po.setBrandName("DDSS");
        goodsBrandService.updateById(po);

        throw new RuntimeException("异常。。。。");
    }


}
