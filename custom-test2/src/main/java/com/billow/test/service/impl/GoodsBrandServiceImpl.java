package com.billow.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.billow.test.dao.GoodsBrandDao;
import com.billow.test.dto.GoodsBrandPo;
import com.billow.test.service.GoodsBrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liuyongtao
 * @create 2020-08-20 19:53
 */
@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandDao, GoodsBrandPo> implements GoodsBrandService {

    @Override
    public void findTest() {
        List<GoodsBrandPo> list = this.list();
        System.out.println(list);

        list = this.list();
        System.out.println(list);


    }

    @Override
    @Transactional
    public void saveTest() {
        GoodsBrandPo po = new GoodsBrandPo();
        po.setId("1293712908815839233");
        po.setBrandName("//333//");
        this.updateById(po);
        throw new RuntimeException("异常。。。。");
    }
}
