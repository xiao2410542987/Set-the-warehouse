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
@ApiModel(value="Workers对象", description="")
@NoArgsConstructor
@AllArgsConstructor
public class Workers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sex;

    private String phone;

    private String password;

    private Integer companyid;
    @TableField(exist = false)
    private Companys companys;//关联Companys表

    private Integer worktypeid;
    @TableField(exist = false)
    private Worktypes worktypes;//关联Worktypes表

    private Integer state;

    private Integer working;

    @TableField(fill = FieldFill.INSERT,exist = false)
    private Date createtime;


}
