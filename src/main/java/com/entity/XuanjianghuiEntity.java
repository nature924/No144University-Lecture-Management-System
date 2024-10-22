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
 * 宣讲会
 *
 * @author 
 * @email
 */
@TableName("xuanjianghui")
public class XuanjianghuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuanjianghuiEntity() {

	}

	public XuanjianghuiEntity(T t) {
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
     * 企业
     */
    @ColumnInfo(comment="企业",type="int(11)")
    @TableField(value = "gongsi_id")

    private Integer gongsiId;


    /**
     * 宣讲会标题
     */
    @ColumnInfo(comment="宣讲会标题",type="varchar(200)")
    @TableField(value = "xuanjianghui_name")

    private String xuanjianghuiName;


    /**
     * 宣讲会封面
     */
    @ColumnInfo(comment="宣讲会封面",type="varchar(200)")
    @TableField(value = "xuanjianghui_photo")

    private String xuanjianghuiPhoto;


    /**
     * 企业资质
     */
    @ColumnInfo(comment="企业资质",type="varchar(200)")
    @TableField(value = "xuanjianghui_daiyu")

    private String xuanjianghuiDaiyu;


    /**
     * 宣讲会类型
     */
    @ColumnInfo(comment="宣讲会类型",type="int(11)")
    @TableField(value = "xuanjianghui_types")

    private Integer xuanjianghuiTypes;


    /**
     * 专业
     */
    @ColumnInfo(comment="专业",type="int(11)")
    @TableField(value = "zhuanye_types")

    private Integer zhuanyeTypes;


    /**
     * 招聘岗位
     */
    @ColumnInfo(comment="招聘岗位",type="varchar(200)")
    @TableField(value = "xuanjianghui_gangwei")

    private String xuanjianghuiGangwei;


    /**
     * 招聘人数
     */
    @ColumnInfo(comment="招聘人数",type="int(11)")
    @TableField(value = "xuanjianghui_renshu_number")

    private Integer xuanjianghuiRenshuNumber;


    /**
     * 宣讲时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="宣讲时间",type="timestamp")
    @TableField(value = "xuanjianghui_time")

    private Date xuanjianghuiTime;


    /**
     * 线下面试
     */
    @ColumnInfo(comment="线下面试",type="int(11)")
    @TableField(value = "xianxia_types")

    private Integer xianxiaTypes;


    /**
     * 宣讲会详情
     */
    @ColumnInfo(comment="宣讲会详情",type="longtext")
    @TableField(value = "xuanjianghui_content")

    private String xuanjianghuiContent;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "xuanjianghui_yesno_types")

    private Integer xuanjianghuiYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "xuanjianghui_yesno_text")

    private String xuanjianghuiYesnoText;


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
	 * 获取：企业
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }
    /**
	 * 设置：企业
	 */

    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
    }
    /**
	 * 获取：宣讲会标题
	 */
    public String getXuanjianghuiName() {
        return xuanjianghuiName;
    }
    /**
	 * 设置：宣讲会标题
	 */

    public void setXuanjianghuiName(String xuanjianghuiName) {
        this.xuanjianghuiName = xuanjianghuiName;
    }
    /**
	 * 获取：宣讲会封面
	 */
    public String getXuanjianghuiPhoto() {
        return xuanjianghuiPhoto;
    }
    /**
	 * 设置：宣讲会封面
	 */

    public void setXuanjianghuiPhoto(String xuanjianghuiPhoto) {
        this.xuanjianghuiPhoto = xuanjianghuiPhoto;
    }
    /**
	 * 获取：企业资质
	 */
    public String getXuanjianghuiDaiyu() {
        return xuanjianghuiDaiyu;
    }
    /**
	 * 设置：企业资质
	 */

    public void setXuanjianghuiDaiyu(String xuanjianghuiDaiyu) {
        this.xuanjianghuiDaiyu = xuanjianghuiDaiyu;
    }
    /**
	 * 获取：宣讲会类型
	 */
    public Integer getXuanjianghuiTypes() {
        return xuanjianghuiTypes;
    }
    /**
	 * 设置：宣讲会类型
	 */

    public void setXuanjianghuiTypes(Integer xuanjianghuiTypes) {
        this.xuanjianghuiTypes = xuanjianghuiTypes;
    }
    /**
	 * 获取：专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }
    /**
	 * 设置：专业
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 获取：招聘岗位
	 */
    public String getXuanjianghuiGangwei() {
        return xuanjianghuiGangwei;
    }
    /**
	 * 设置：招聘岗位
	 */

    public void setXuanjianghuiGangwei(String xuanjianghuiGangwei) {
        this.xuanjianghuiGangwei = xuanjianghuiGangwei;
    }
    /**
	 * 获取：招聘人数
	 */
    public Integer getXuanjianghuiRenshuNumber() {
        return xuanjianghuiRenshuNumber;
    }
    /**
	 * 设置：招聘人数
	 */

    public void setXuanjianghuiRenshuNumber(Integer xuanjianghuiRenshuNumber) {
        this.xuanjianghuiRenshuNumber = xuanjianghuiRenshuNumber;
    }
    /**
	 * 获取：宣讲时间
	 */
    public Date getXuanjianghuiTime() {
        return xuanjianghuiTime;
    }
    /**
	 * 设置：宣讲时间
	 */

    public void setXuanjianghuiTime(Date xuanjianghuiTime) {
        this.xuanjianghuiTime = xuanjianghuiTime;
    }
    /**
	 * 获取：线下面试
	 */
    public Integer getXianxiaTypes() {
        return xianxiaTypes;
    }
    /**
	 * 设置：线下面试
	 */

    public void setXianxiaTypes(Integer xianxiaTypes) {
        this.xianxiaTypes = xianxiaTypes;
    }
    /**
	 * 获取：宣讲会详情
	 */
    public String getXuanjianghuiContent() {
        return xuanjianghuiContent;
    }
    /**
	 * 设置：宣讲会详情
	 */

    public void setXuanjianghuiContent(String xuanjianghuiContent) {
        this.xuanjianghuiContent = xuanjianghuiContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getXuanjianghuiYesnoTypes() {
        return xuanjianghuiYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setXuanjianghuiYesnoTypes(Integer xuanjianghuiYesnoTypes) {
        this.xuanjianghuiYesnoTypes = xuanjianghuiYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getXuanjianghuiYesnoText() {
        return xuanjianghuiYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setXuanjianghuiYesnoText(String xuanjianghuiYesnoText) {
        this.xuanjianghuiYesnoText = xuanjianghuiYesnoText;
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
        return "Xuanjianghui{" +
            ", id=" + id +
            ", gongsiId=" + gongsiId +
            ", xuanjianghuiName=" + xuanjianghuiName +
            ", xuanjianghuiPhoto=" + xuanjianghuiPhoto +
            ", xuanjianghuiDaiyu=" + xuanjianghuiDaiyu +
            ", xuanjianghuiTypes=" + xuanjianghuiTypes +
            ", zhuanyeTypes=" + zhuanyeTypes +
            ", xuanjianghuiGangwei=" + xuanjianghuiGangwei +
            ", xuanjianghuiRenshuNumber=" + xuanjianghuiRenshuNumber +
            ", xuanjianghuiTime=" + DateUtil.convertString(xuanjianghuiTime,"yyyy-MM-dd") +
            ", xianxiaTypes=" + xianxiaTypes +
            ", xuanjianghuiContent=" + xuanjianghuiContent +
            ", xuanjianghuiYesnoTypes=" + xuanjianghuiYesnoTypes +
            ", xuanjianghuiYesnoText=" + xuanjianghuiYesnoText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
