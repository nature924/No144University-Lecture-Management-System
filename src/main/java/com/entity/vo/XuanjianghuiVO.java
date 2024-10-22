package com.entity.vo;

import com.entity.XuanjianghuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宣讲会
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuanjianghui")
public class XuanjianghuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 企业
     */

    @TableField(value = "gongsi_id")
    private Integer gongsiId;


    /**
     * 宣讲会标题
     */

    @TableField(value = "xuanjianghui_name")
    private String xuanjianghuiName;


    /**
     * 宣讲会封面
     */

    @TableField(value = "xuanjianghui_photo")
    private String xuanjianghuiPhoto;


    /**
     * 企业资质
     */

    @TableField(value = "xuanjianghui_daiyu")
    private String xuanjianghuiDaiyu;


    /**
     * 宣讲会类型
     */

    @TableField(value = "xuanjianghui_types")
    private Integer xuanjianghuiTypes;


    /**
     * 专业
     */

    @TableField(value = "zhuanye_types")
    private Integer zhuanyeTypes;


    /**
     * 招聘岗位
     */

    @TableField(value = "xuanjianghui_gangwei")
    private String xuanjianghuiGangwei;


    /**
     * 招聘人数
     */

    @TableField(value = "xuanjianghui_renshu_number")
    private Integer xuanjianghuiRenshuNumber;


    /**
     * 宣讲时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xuanjianghui_time")
    private Date xuanjianghuiTime;


    /**
     * 线下面试
     */

    @TableField(value = "xianxia_types")
    private Integer xianxiaTypes;


    /**
     * 宣讲会详情
     */

    @TableField(value = "xuanjianghui_content")
    private String xuanjianghuiContent;


    /**
     * 审核状态
     */

    @TableField(value = "xuanjianghui_yesno_types")
    private Integer xuanjianghuiYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "xuanjianghui_yesno_text")
    private String xuanjianghuiYesnoText;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：企业
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }


    /**
	 * 获取：企业
	 */

    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
    }
    /**
	 * 设置：宣讲会标题
	 */
    public String getXuanjianghuiName() {
        return xuanjianghuiName;
    }


    /**
	 * 获取：宣讲会标题
	 */

    public void setXuanjianghuiName(String xuanjianghuiName) {
        this.xuanjianghuiName = xuanjianghuiName;
    }
    /**
	 * 设置：宣讲会封面
	 */
    public String getXuanjianghuiPhoto() {
        return xuanjianghuiPhoto;
    }


    /**
	 * 获取：宣讲会封面
	 */

    public void setXuanjianghuiPhoto(String xuanjianghuiPhoto) {
        this.xuanjianghuiPhoto = xuanjianghuiPhoto;
    }
    /**
	 * 设置：企业资质
	 */
    public String getXuanjianghuiDaiyu() {
        return xuanjianghuiDaiyu;
    }


    /**
	 * 获取：企业资质
	 */

    public void setXuanjianghuiDaiyu(String xuanjianghuiDaiyu) {
        this.xuanjianghuiDaiyu = xuanjianghuiDaiyu;
    }
    /**
	 * 设置：宣讲会类型
	 */
    public Integer getXuanjianghuiTypes() {
        return xuanjianghuiTypes;
    }


    /**
	 * 获取：宣讲会类型
	 */

    public void setXuanjianghuiTypes(Integer xuanjianghuiTypes) {
        this.xuanjianghuiTypes = xuanjianghuiTypes;
    }
    /**
	 * 设置：专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }


    /**
	 * 获取：专业
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 设置：招聘岗位
	 */
    public String getXuanjianghuiGangwei() {
        return xuanjianghuiGangwei;
    }


    /**
	 * 获取：招聘岗位
	 */

    public void setXuanjianghuiGangwei(String xuanjianghuiGangwei) {
        this.xuanjianghuiGangwei = xuanjianghuiGangwei;
    }
    /**
	 * 设置：招聘人数
	 */
    public Integer getXuanjianghuiRenshuNumber() {
        return xuanjianghuiRenshuNumber;
    }


    /**
	 * 获取：招聘人数
	 */

    public void setXuanjianghuiRenshuNumber(Integer xuanjianghuiRenshuNumber) {
        this.xuanjianghuiRenshuNumber = xuanjianghuiRenshuNumber;
    }
    /**
	 * 设置：宣讲时间
	 */
    public Date getXuanjianghuiTime() {
        return xuanjianghuiTime;
    }


    /**
	 * 获取：宣讲时间
	 */

    public void setXuanjianghuiTime(Date xuanjianghuiTime) {
        this.xuanjianghuiTime = xuanjianghuiTime;
    }
    /**
	 * 设置：线下面试
	 */
    public Integer getXianxiaTypes() {
        return xianxiaTypes;
    }


    /**
	 * 获取：线下面试
	 */

    public void setXianxiaTypes(Integer xianxiaTypes) {
        this.xianxiaTypes = xianxiaTypes;
    }
    /**
	 * 设置：宣讲会详情
	 */
    public String getXuanjianghuiContent() {
        return xuanjianghuiContent;
    }


    /**
	 * 获取：宣讲会详情
	 */

    public void setXuanjianghuiContent(String xuanjianghuiContent) {
        this.xuanjianghuiContent = xuanjianghuiContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXuanjianghuiYesnoTypes() {
        return xuanjianghuiYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setXuanjianghuiYesnoTypes(Integer xuanjianghuiYesnoTypes) {
        this.xuanjianghuiYesnoTypes = xuanjianghuiYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getXuanjianghuiYesnoText() {
        return xuanjianghuiYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setXuanjianghuiYesnoText(String xuanjianghuiYesnoText) {
        this.xuanjianghuiYesnoText = xuanjianghuiYesnoText;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
