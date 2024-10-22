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
 * 宣讲会报名
 *
 * @author 
 * @email
 */
@TableName("xuanjianghui_yuyue")
public class XuanjianghuiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuanjianghuiYuyueEntity() {

	}

	public XuanjianghuiYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "xuanjianghui_yuyue_uuid_number")

    private String xuanjianghuiYuyueUuidNumber;


    /**
     * 宣讲会
     */
    @ColumnInfo(comment="宣讲会",type="int(11)")
    @TableField(value = "xuanjianghui_id")

    private Integer xuanjianghuiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getXuanjianghuiYuyueUuidNumber() {
        return xuanjianghuiYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setXuanjianghuiYuyueUuidNumber(String xuanjianghuiYuyueUuidNumber) {
        this.xuanjianghuiYuyueUuidNumber = xuanjianghuiYuyueUuidNumber;
    }
    /**
	 * 获取：宣讲会
	 */
    public Integer getXuanjianghuiId() {
        return xuanjianghuiId;
    }
    /**
	 * 设置：宣讲会
	 */

    public void setXuanjianghuiId(Integer xuanjianghuiId) {
        this.xuanjianghuiId = xuanjianghuiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XuanjianghuiYuyue{" +
            ", id=" + id +
            ", xuanjianghuiYuyueUuidNumber=" + xuanjianghuiYuyueUuidNumber +
            ", xuanjianghuiId=" + xuanjianghuiId +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
