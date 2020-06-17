package com.storage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author renyu
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Works对象", description="")
@NoArgsConstructor
@AllArgsConstructor
public class Works implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String text;

    private Integer companyid;
    @TableField(exist = false)
    private Companys companys;//关联companys表

    private Integer workerid;
    @TableField(exist = false)
    private Workers workers;//关联workers表

    private Integer goodsid;
    @TableField(exist = false)
    private Goods goods;//关联goods表

    private Integer distributionid;
    @TableField(exist = false)
    private Distribution distribution;//关联distribution表

    private Integer warehouseid;
    @TableField(exist = false)
    private Warehouses warehouses;//关联warehouses表

    private Integer state;

    @TableField(fill = FieldFill.INSERT,exist = false)
    private Date createtime;

    @TableField(fill = FieldFill.UPDATE,exist = false)
    private Date updatetime;


}
