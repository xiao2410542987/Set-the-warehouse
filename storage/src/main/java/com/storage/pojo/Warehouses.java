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
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Warehouses对象", description="")
@NoArgsConstructor
@AllArgsConstructor
public class Warehouses implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer waresize;

    private Integer meteringid;
    @TableField(exist = false)
    private Metering metering;//外键metering表

    private Integer unusesize;

    private Integer warehousetypeid;
    @TableField(exist = false)
    private Warehousetypes warehousetypes;//外键warehousetypes表

    private Integer companyid;
    @TableField(exist = false)
    private Companys companys;//外键companys表

    private Integer workerid;
    @TableField(exist = false)
    private Workers workers;//外键workers表

    private Integer state;

    @TableField(fill = FieldFill.INSERT,exist = false)
    private Date createtime;


}
