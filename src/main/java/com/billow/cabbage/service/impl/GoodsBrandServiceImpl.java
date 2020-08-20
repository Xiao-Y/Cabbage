package com.billow.cabbage.service.impl;

import com.billow.cabbage.dao.GoodsBrandDao;
import com.billow.cabbage.dto.GoodsBrandPo;
import com.billow.cabbage.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateById(GoodsBrandPo po) {
        goodsBrandDao.updateById(po);
    }
}
