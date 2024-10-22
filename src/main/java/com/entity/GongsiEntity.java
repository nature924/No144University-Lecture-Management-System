package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 企业
 *
 * @author 
 * @email
 */
@TableName("gongsi")
public class GongsiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongsiEntity() {

	}

	public GongsiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 企业名称
     */
    @ColumnInfo(comment="企业名称",type="varchar(200)")
    @TableField(value = "gongsi_name")

    private String gongsiName;


    /**
     * 企业类型
     */
    @ColumnInfo(comment="企业类型",type="int(11)")
    @TableField(value = "gongsi_types")

    private Integer gongsiTypes;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "gongsi_phone")

    private String gongsiPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "gongsi_email")

    private String gongsiEmail;


    /**
     * 企业封面
     */
    @ColumnInfo(comment="企业封面",type="varchar(200)")
    @TableField(value = "gongsi_photo")

    private String gongsiPhoto;


    /**
     * 企业简介
     */
    @ColumnInfo(comment="企业简介",type="longtext")
    @TableField(value = "gongsi_content")

    private String gongsiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "gongsi_delete")

    private Integer gongsiDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：企业名称
	 */
    public String getGongsiName() {
        return gongsiName;
    }
    /**
	 * 设置：企业名称
	 */

    public void setGongsiName(String gongsiName) {
        this.gongsiName = gongsiName;
    }
    /**
	 * 获取：企业类型
	 */
    public Integer getGongsiTypes() {
        return gongsiTypes;
    }
    /**
	 * 设置：企业类型
	 */

    public void setGongsiTypes(Integer gongsiTypes) {
        this.gongsiTypes = gongsiTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getGongsiPhone() {
        return gongsiPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setGongsiPhone(String gongsiPhone) {
        this.gongsiPhone = gongsiPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getGongsiEmail() {
        return gongsiEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setGongsiEmail(String gongsiEmail) {
        this.gongsiEmail = gongsiEmail;
    }
    /**
	 * 获取：企业封面
	 */
    public String getGongsiPhoto() {
        return gongsiPhoto;
    }
    /**
	 * 设置：企业封面
	 */

    public void setGongsiPhoto(String gongsiPhoto) {
        this.gongsiPhoto = gongsiPhoto;
    }
    /**
	 * 获取：企业简介
	 */
    public String getGongsiContent() {
        return gongsiContent;
    }
    /**
	 * 设置：企业简介
	 */

    public void setGongsiContent(String gongsiContent) {
        this.gongsiContent = gongsiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGongsiDelete() {
        return gongsiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGongsiDelete(Integer gongsiDelete) {
        this.gongsiDelete = gongsiDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gongsi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongsiName=" + gongsiName +
            ", gongsiTypes=" + gongsiTypes +
            ", gongsiPhone=" + gongsiPhone +
            ", gongsiEmail=" + gongsiEmail +
            ", gongsiPhoto=" + gongsiPhoto +
            ", gongsiContent=" + gongsiContent +
            ", gongsiDelete=" + gongsiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
