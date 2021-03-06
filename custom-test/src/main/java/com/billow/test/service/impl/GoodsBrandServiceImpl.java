package com.billow.test.service.impl;

import com.billow.test.dao.GoodsBrandDao;
import com.billow.test.dto.GoodsBrandPo;
import com.billow.test.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liuyongtao
 * @create 2020-08-20 19:53
 */
@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {

    @Autowired
    private GoodsBrandDao goodsBrandDao;

    @Override
    public List<GoodsBrandPo> findList() {
        return goodsBrandDao.findList();
    }

    @Override
    @Transactional
    public void updateById(GoodsBrandPo po) {
        goodsBrandDao.updateById(po);
    }

    @Override
    public void findTest() {
        List<GoodsBrandPo> list = this.findList();
        System.out.println(list);

        list = this.findList();
        System.out.println(list);
    }

    @Override
    @Transactional
    public void saveTest() {
        List<GoodsBrandPo> list = this.findList();
        System.out.println(list);

        GoodsBrandPo po = new GoodsBrandPo();
        po.setId("1293712908815839233");
        po.setBrandName("/ddd//");
        this.updateById(po);

        throw new RuntimeException("异常。。。。");
    }
}
