package com.billow.test.service;

import com.billow.test.dto.GoodsBrandPo;

import java.util.List;

public interface GoodsBrandService {

    List<GoodsBrandPo> findList();

    void updateById(GoodsBrandPo po);

    void findTest();

    void saveTest();
}
