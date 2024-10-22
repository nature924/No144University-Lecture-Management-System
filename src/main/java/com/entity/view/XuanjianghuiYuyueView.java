package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuanjianghuiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 宣讲会报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanjianghui_yuyue")
public class XuanjianghuiYuyueView extends XuanjianghuiYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 宣讲会
					 
		/**
		* 宣讲会 的 企业
		*/
		@ColumnInfo(comment="企业",type="int(11)")
		private Integer xuanjianghuiGongsiId;
		/**
		* 宣讲会标题
		*/

		@ColumnInfo(comment="宣讲会标题",type="varchar(200)")
		private String xuanjianghuiName;
		/**
		* 宣讲会封面
		*/

		@ColumnInfo(comment="宣讲会封面",type="varchar(200)")
		private String xuanjianghuiPhoto;
		/**
		* 企业资质
		*/

		@ColumnInfo(comment="企业资质",type="varchar(200)")
		private String xuanjianghuiDaiyu;
		/**
		* 宣讲会类型
		*/
		@ColumnInfo(comment="宣讲会类型",type="int(11)")
		private Integer xuanjianghuiTypes;
			/**
			* 宣讲会类型的值
			*/
			@ColumnInfo(comment="宣讲会类型的字典表值",type="varchar(200)")
			private String xuanjianghuiValue;
		/**
		* 招聘岗位
		*/

		@ColumnInfo(comment="招聘岗位",type="varchar(200)")
		private String xuanjianghuiGangwei;
		/**
		* 招聘人数
		*/

		@ColumnInfo(comment="招聘人数",type="int(11)")
		private Integer xuanjianghuiRenshuNumber;
		/**
		* 宣讲时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="宣讲时间",type="timestamp")
		private Date xuanjianghuiTime;
		/**
		* 线下面试
		*/
		@ColumnInfo(comment="线下面试",type="int(11)")
		private Integer xianxiaTypes;
			/**
			* 线下面试的值
			*/
			@ColumnInfo(comment="线下面试的字典表值",type="varchar(200)")
			private String xianxiaValue;
		/**
		* 宣讲会详情
		*/

		@ColumnInfo(comment="宣讲会详情",type="longtext")
		private String xuanjianghuiContent;
		/**
		* 审核状态
		*/
		@ColumnInfo(comment="审核状态",type="int(11)")
		private Integer xuanjianghuiYesnoTypes;
			/**
			* 审核状态的值
			*/
			@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
			private String xuanjianghuiYesnoValue;
		/**
		* 审核回复
		*/

		@ColumnInfo(comment="审核回复",type="longtext")
		private String xuanjianghuiYesnoText;
	//级联表 学生
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 学院
		*/
		@ColumnInfo(comment="学院",type="int(11)")
		private Integer xueyuanTypes;
			/**
			* 学院的值
			*/
			@ColumnInfo(comment="学院的字典表值",type="varchar(200)")
			private String xueyuanValue;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer zhuanyeTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String zhuanyeValue;


	public XuanjianghuiYuyueView() {

	}

	public XuanjianghuiYuyueView(XuanjianghuiYuyueEntity xuanjianghuiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, xuanjianghuiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 宣讲会
		/**
		* 获取：宣讲会 的 企业
		*/
		public Integer getXuanjianghuiGongsiId() {
			return xuanjianghuiGongsiId;
		}
		/**
		* 设置：宣讲会 的 企业
		*/
		public void setXuanjianghuiGongsiId(Integer xuanjianghuiGongsiId) {
			this.xuanjianghuiGongsiId = xuanjianghuiGongsiId;
		}

		/**
		* 获取： 宣讲会标题
		*/
		public String getXuanjianghuiName() {
			return xuanjianghuiName;
		}
		/**
		* 设置： 宣讲会标题
		*/
		public void setXuanjianghuiName(String xuanjianghuiName) {
			this.xuanjianghuiName = xuanjianghuiName;
		}

		/**
		* 获取： 宣讲会封面
		*/
		public String getXuanjianghuiPhoto() {
			return xuanjianghuiPhoto;
		}
		/**
		* 设置： 宣讲会封面
		*/
		public void setXuanjianghuiPhoto(String xuanjianghuiPhoto) {
			this.xuanjianghuiPhoto = xuanjianghuiPhoto;
		}

		/**
		* 获取： 企业资质
		*/
		public String getXuanjianghuiDaiyu() {
			return xuanjianghuiDaiyu;
		}
		/**
		* 设置： 企业资质
		*/
		public void setXuanjianghuiDaiyu(String xuanjianghuiDaiyu) {
			this.xuanjianghuiDaiyu = xuanjianghuiDaiyu;
		}
		/**
		* 获取： 宣讲会类型
		*/
		public Integer getXuanjianghuiTypes() {
			return xuanjianghuiTypes;
		}
		/**
		* 设置： 宣讲会类型
		*/
		public void setXuanjianghuiTypes(Integer xuanjianghuiTypes) {
			this.xuanjianghuiTypes = xuanjianghuiTypes;
		}


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

		/**
		* 获取： 招聘岗位
		*/
		public String getXuanjianghuiGangwei() {
			return xuanjianghuiGangwei;
		}
		/**
		* 设置： 招聘岗位
		*/
		public void setXuanjianghuiGangwei(String xuanjianghuiGangwei) {
			this.xuanjianghuiGangwei = xuanjianghuiGangwei;
		}

		/**
		* 获取： 招聘人数
		*/
		public Integer getXuanjianghuiRenshuNumber() {
			return xuanjianghuiRenshuNumber;
		}
		/**
		* 设置： 招聘人数
		*/
		public void setXuanjianghuiRenshuNumber(Integer xuanjianghuiRenshuNumber) {
			this.xuanjianghuiRenshuNumber = xuanjianghuiRenshuNumber;
		}

		/**
		* 获取： 宣讲时间
		*/
		public Date getXuanjianghuiTime() {
			return xuanjianghuiTime;
		}
		/**
		* 设置： 宣讲时间
		*/
		public void setXuanjianghuiTime(Date xuanjianghuiTime) {
			this.xuanjianghuiTime = xuanjianghuiTime;
		}
		/**
		* 获取： 线下面试
		*/
		public Integer getXianxiaTypes() {
			return xianxiaTypes;
		}
		/**
		* 设置： 线下面试
		*/
		public void setXianxiaTypes(Integer xianxiaTypes) {
			this.xianxiaTypes = xianxiaTypes;
		}


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

		/**
		* 获取： 宣讲会详情
		*/
		public String getXuanjianghuiContent() {
			return xuanjianghuiContent;
		}
		/**
		* 设置： 宣讲会详情
		*/
		public void setXuanjianghuiContent(String xuanjianghuiContent) {
			this.xuanjianghuiContent = xuanjianghuiContent;
		}
		/**
		* 获取： 审核状态
		*/
		public Integer getXuanjianghuiYesnoTypes() {
			return xuanjianghuiYesnoTypes;
		}
		/**
		* 设置： 审核状态
		*/
		public void setXuanjianghuiYesnoTypes(Integer xuanjianghuiYesnoTypes) {
			this.xuanjianghuiYesnoTypes = xuanjianghuiYesnoTypes;
		}


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

		/**
		* 获取： 审核回复
		*/
		public String getXuanjianghuiYesnoText() {
			return xuanjianghuiYesnoText;
		}
		/**
		* 设置： 审核回复
		*/
		public void setXuanjianghuiYesnoText(String xuanjianghuiYesnoText) {
			this.xuanjianghuiYesnoText = xuanjianghuiYesnoText;
		}
	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 学院
		*/
		public Integer getXueyuanTypes() {
			return xueyuanTypes;
		}
		/**
		* 设置： 学院
		*/
		public void setXueyuanTypes(Integer xueyuanTypes) {
			this.xueyuanTypes = xueyuanTypes;
		}


			/**
			* 获取： 学院的值
			*/
			public String getXueyuanValue() {
				return xueyuanValue;
			}
			/**
			* 设置： 学院的值
			*/
			public void setXueyuanValue(String xueyuanValue) {
				this.xueyuanValue = xueyuanValue;
			}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getZhuanyeTypes() {
			return zhuanyeTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setZhuanyeTypes(Integer zhuanyeTypes) {
			this.zhuanyeTypes = zhuanyeTypes;
			}
				public String getZhuanyeValue() {
				return zhuanyeValue;
				}
				public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
				}

	@Override
	public String toString() {
		return "XuanjianghuiYuyueView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", xuanjianghuiName=" + xuanjianghuiName +
			", xuanjianghuiPhoto=" + xuanjianghuiPhoto +
			", xuanjianghuiDaiyu=" + xuanjianghuiDaiyu +
			", xuanjianghuiGangwei=" + xuanjianghuiGangwei +
			", xuanjianghuiRenshuNumber=" + xuanjianghuiRenshuNumber +
			", xuanjianghuiTime=" + DateUtil.convertString(xuanjianghuiTime,"yyyy-MM-dd") +
			", xuanjianghuiContent=" + xuanjianghuiContent +
			", xuanjianghuiYesnoText=" + xuanjianghuiYesnoText +
			"} " + super.toString();
	}
}
