package com.billow.cabbage.service;

import com.billow.cabbage.dto.GoodsBrandPo;

import java.util.List;

public interface GoodsBrandService {

    List<GoodsBrandPo> findList();

    void updateById(GoodsBrandPo po);
}
