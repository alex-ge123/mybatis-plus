package com.alex.autogender1.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author alexge
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Person对象", description="")
public class Person extends Model<Person> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    private String pname;

    private Integer age;

    private String address;

    private Date createtime;

    private Date updatetime;


    @Override
    protected Serializable pkVal() {
        return this.pid;
    }

}
