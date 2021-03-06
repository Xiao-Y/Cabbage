package com.billow.test.dao;


import com.billow.test.dto.GoodsBrandPo;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author billow
 * @since 2020-08-08
 */
public interface GoodsBrandDao {

    List<GoodsBrandPo> findList();

    void updateById(GoodsBrandPo po);
}
