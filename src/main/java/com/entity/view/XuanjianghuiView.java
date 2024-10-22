package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuanjianghuiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 宣讲会
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanjianghui")
public class XuanjianghuiView extends XuanjianghuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 宣讲会类型的值
	*/
	@ColumnInfo(comment="宣讲会类型的字典表值",type="varchar(200)")
	private String xuanjianghuiValue;
	/**
	* 专业的值
	*/
	@ColumnInfo(comment="专业的字典表值",type="varchar(200)")
	private String zhuanyeValue;
	/**
	* 线下面试的值
	*/
	@ColumnInfo(comment="线下面试的字典表值",type="varchar(200)")
	private String xianxiaValue;
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String xuanjianghuiYesnoValue;

	//级联表 企业
		/**
		* 企业名称
		*/

		@ColumnInfo(comment="企业名称",type="varchar(200)")
		private String gongsiName;
		/**
		* 企业类型
		*/
		@ColumnInfo(comment="企业类型",type="int(11)")
		private Integer gongsiTypes;
			/**
			* 企业类型的值
			*/
			@ColumnInfo(comment="企业类型的字典表值",type="varchar(200)")
			private String gongsiValue;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String gongsiPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String gongsiEmail;
		/**
		* 企业封面
		*/

		@ColumnInfo(comment="企业封面",type="varchar(200)")
		private String gongsiPhoto;
		/**
		* 企业简介
		*/

		@ColumnInfo(comment="企业简介",type="longtext")
		private String gongsiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer gongsiDelete;



	public XuanjianghuiView() {

	}

	public XuanjianghuiView(XuanjianghuiEntity xuanjianghuiEntity) {
		try {
			BeanUtils.copyProperties(this, xuanjianghuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 宣讲会类型的值
	*/
	public String getXuanjianghuiValue() {
		return xuanjianghuiValue;
	}
	/**
	* 设置： 宣讲会类型的值
	*/
	public void setXuanjianghuiValue(String xuanjianghuiValue) {
		this.xuanjianghuiValue = xuanjianghuiValue;
	}
	//当前表的
	/**
	* 获取： 专业的值
	*/
	public String getZhuanyeValue() {
		return zhuanyeValue;
	}
	/**
	* 设置： 专业的值
	*/
	public void setZhuanyeValue(String zhuanyeValue) {
		this.zhuanyeValue = zhuanyeValue;
	}
	//当前表的
	/**
	* 获取： 线下面试的值
	*/
	public String getXianxiaValue() {
		return xianxiaValue;
	}
	/**
	* 设置： 线下面试的值
	*/
	public void setXianxiaValue(String xianxiaValue) {
		this.xianxiaValue = xianxiaValue;
	}
	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getXuanjianghuiYesnoValue() {
		return xuanjianghuiYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setXuanjianghuiYesnoValue(String xuanjianghuiYesnoValue) {
		this.xuanjianghuiYesnoValue = xuanjianghuiYesnoValue;
	}


	//级联表的get和set 企业

		/**
		* 获取： 企业名称
		*/
		public String getGongsiName() {
			return gongsiName;
		}
		/**
		* 设置： 企业名称
		*/
		public void setGongsiName(String gongsiName) {
			this.gongsiName = gongsiName;
		}
		/**
		* 获取： 企业类型
		*/
		public Integer getGongsiTypes() {
			return gongsiTypes;
		}
		/**
		* 设置： 企业类型
		*/
		public void setGongsiTypes(Integer gongsiTypes) {
			this.gongsiTypes = gongsiTypes;
		}


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

		/**
		* 获取： 联系方式
		*/
		public String getGongsiPhone() {
			return gongsiPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setGongsiPhone(String gongsiPhone) {
			this.gongsiPhone = gongsiPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getGongsiEmail() {
			return gongsiEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setGongsiEmail(String gongsiEmail) {
			this.gongsiEmail = gongsiEmail;
		}

		/**
		* 获取： 企业封面
		*/
		public String getGongsiPhoto() {
			return gongsiPhoto;
		}
		/**
		* 设置： 企业封面
		*/
		public void setGongsiPhoto(String gongsiPhoto) {
			this.gongsiPhoto = gongsiPhoto;
		}

		/**
		* 获取： 企业简介
		*/
		public String getGongsiContent() {
			return gongsiContent;
		}
		/**
		* 设置： 企业简介
		*/
		public void setGongsiContent(String gongsiContent) {
			this.gongsiContent = gongsiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getGongsiDelete() {
			return gongsiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setGongsiDelete(Integer gongsiDelete) {
			this.gongsiDelete = gongsiDelete;
		}


	@Override
	public String toString() {
		return "XuanjianghuiView{" +
			", xuanjianghuiValue=" + xuanjianghuiValue +
			", zhuanyeValue=" + zhuanyeValue +
			", xianxiaValue=" + xianxiaValue +
			", xuanjianghuiYesnoValue=" + xuanjianghuiYesnoValue +
			", gongsiName=" + gongsiName +
			", gongsiPhone=" + gongsiPhone +
			", gongsiEmail=" + gongsiEmail +
			", gongsiPhoto=" + gongsiPhoto +
			", gongsiContent=" + gongsiContent +
			", gongsiDelete=" + gongsiDelete +
			"} " + super.toString();
	}
}
