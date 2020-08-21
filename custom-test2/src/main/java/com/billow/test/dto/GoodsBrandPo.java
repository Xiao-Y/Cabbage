package com.billow.test.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("p_goods_brand")
public class GoodsBrandPo {

    private static final long serialVersionUID = 1L;


    // 主键id
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    //品牌名称
    private String brandName;

    //分类排序
    private Long brandSort;

    // 创建人
    @TableField(value = "creator_code")
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
