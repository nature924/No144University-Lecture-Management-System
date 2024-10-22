package com.entity.vo;

import com.entity.DangqianqingkuangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 就业情况
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dangqianqingkuang")
public class DangqianqingkuangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 就业状态
     */

    @TableField(value = "dangqianqingkuang_types")
    private Integer dangqianqingkuangTypes;


    /**
     * 备注
     */

    @TableField(value = "dangqianqingkuang_text")
    private String dangqianqingkuangText;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：就业状态
	 */
    public Integer getDangqianqingkuangTypes() {
        return dangqianqingkuangTypes;
    }


    /**
	 * 获取：就业状态
	 */

    public void setDangqianqingkuangTypes(Integer dangqianqingkuangTypes) {
        this.dangqianqingkuangTypes = dangqianqingkuangTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getDangqianqingkuangText() {
        return dangqianqingkuangText;
    }


    /**
	 * 获取：备注
	 */

    public void setDangqianqingkuangText(String dangqianqingkuangText) {
        this.dangqianqingkuangText = dangqianqingkuangText;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
