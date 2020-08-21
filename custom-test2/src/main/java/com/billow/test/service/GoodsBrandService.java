package com.billow.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.billow.test.dto.GoodsBrandPo;

public interface GoodsBrandService extends IService<GoodsBrandPo> {

    void findTest();

    void saveTest();
}
