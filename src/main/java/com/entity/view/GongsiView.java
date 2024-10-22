package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.GongsiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 企业
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("gongsi")
public class GongsiView extends GongsiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 企业类型的值
	*/
	@ColumnInfo(comment="企业类型的字典表值",type="varchar(200)")
	private String gongsiValue;




	public GongsiView() {

	}

	public GongsiView(GongsiEntity gongsiEntity) {
		try {
			BeanUtils.copyProperties(this, gongsiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 企业类型的值
	*/
	public String getGongsiValue() {
		return gongsiValue;
	}
	/**
	* 设置： 企业类型的值
	*/
	public void setGongsiValue(String gongsiValue) {
		this.gongsiValue = gongsiValue;
	}




	@Override
	public String toString() {
		return "GongsiView{" +
			", gongsiValue=" + gongsiValue +
			"} " + super.toString();
	}
}
