package com.entity.model;

import com.entity.GongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 企业
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongsiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 企业名称
     */
    private String gongsiName;


    /**
     * 企业类型
     */
    private Integer gongsiTypes;


    /**
     * 联系方式
     */
    private String gongsiPhone;


    /**
     * 邮箱
     */
    private String gongsiEmail;


    /**
     * 企业封面
     */
    private String gongsiPhoto;


    /**
     * 企业简介
     */
    private String gongsiContent;


    /**
     * 逻辑删除
     */
    private Integer gongsiDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
