package com.billow.cabbage.dao;


import com.billow.cabbage.dto.GoodsBrandPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author billow
 * @since 2020-08-08
 */
@Mapper
public interface GoodsBrandDao {

    List<GoodsBrandPo> findList();

    void updateById(GoodsBrandPo po);
}
