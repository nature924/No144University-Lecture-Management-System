package com.entity.vo;

import com.entity.XuanjianghuiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宣讲会报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuanjianghui_yuyue")
public class XuanjianghuiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "xuanjianghui_yuyue_uuid_number")
    private String xuanjianghuiYuyueUuidNumber;


    /**
     * 宣讲会
     */

    @TableField(value = "xuanjianghui_id")
    private Integer xuanjianghuiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报名编号
	 */
    public String getXuanjianghuiYuyueUuidNumber() {
        return xuanjianghuiYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setXuanjianghuiYuyueUuidNumber(String xuanjianghuiYuyueUuidNumber) {
        this.xuanjianghuiYuyueUuidNumber = xuanjianghuiYuyueUuidNumber;
    }
    /**
	 * 设置：宣讲会
	 */
    public Integer getXuanjianghuiId() {
        return xuanjianghuiId;
    }


    /**
	 * 获取：宣讲会
	 */

    public void setXuanjianghuiId(Integer xuanjianghuiId) {
        this.xuanjianghuiId = xuanjianghuiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
