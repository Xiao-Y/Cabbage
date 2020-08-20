package com.billow.cabbage.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author billow
 * @since 2020-08-08
 */
@Data
@Accessors(chain = true)
public class GoodsBrandPo {

    private static final long serialVersionUID = 1L;


    // 主键id
    private String id;

    //品牌名称
    private String brandName;

    //分类排序
    private Long brandSort;

    // 创建人
    private String creatorCode;

    // 创建人
    private String updaterCode;

    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date createTime;

    // 更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date updateTime;

    // 有效标志
    private Boolean validInd;
}
