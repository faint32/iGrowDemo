/**
* @FileName BaseEntity.java
* @Package com.rujia.dao.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-9-11 上午9:50:30
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.io.Serializable;
import java.util.Date;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ClassName BaseEntity
 * @Description TODO【实体类基类】
 * @Author Brights
 * @Date 2013-9-11 上午9:50:30
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -5973996316475460764L;
	public static final String ON_INSERT_METHOD_NAME = "onInsert";// "保存"方法名称
	public static final String ON_UPDATE_METHOD_NAME = "onUpdate";// "更新"方法名称
	public static final String ON_DELETE_METHOD_NAME = "onDelete";// "删除"方法名称
	
	private String id;
	private Date createDate;
	private Date modifyDate;
	private String createOperator;
	private String modifyOperator;
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/**
	* @Title onInsert
	* @Description TODO【保存操作】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void onInsert() {
		createDate = new Date();
		modifyDate = new Date();
	}
	
	/**
	* @Title onUpdate
	* @Description TODO【修改操作】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void onUpdate() {
		modifyDate = new Date();
	}
	
	/**
	* @Title onDelete
	* @Description TODO【删除操作】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void onDelete() {
		modifyDate = new Date();
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	public String getCreateOperator() {
		return createOperator;
	}


	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}


	public String getModifyOperator() {
		return modifyOperator;
	}


	public void setModifyOperator(String modifyOperator) {
		this.modifyOperator = modifyOperator;
	}


	

}
