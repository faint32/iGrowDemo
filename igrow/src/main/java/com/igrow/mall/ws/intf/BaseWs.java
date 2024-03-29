/**
* @FileName BaseWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午4:47:53
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


/**
 * @ClassName BaseWs
 * @Description TODO【Ws层接口】
 * @Author Brights
 * @Date 2013-10-18 下午4:47:53
 */
public interface BaseWs<T,PK extends Serializable> {
	/**
	* @Title find
	* @Description TODO【查询实体对象】
	* @param id
	* @return 
	* @Return T 返回类型
	* @Throws 
	*/ 
	public T find(PK id);
	
	/**
	* @Title save
	* @Description TODO【保存实体】
	* @param entity
	* @return 
	* @Return T 返回类型
	* @Throws 
	*/ 
	public T save(T entity);
	
	/**
	* @Title insert
	* @Description TODO【插入实体对象】
	* @param entity
	* @return 
	* @Return Integer 返回类型
	* @Throws 
	*/ 
	public void insert(T entity);
	
	/**
	* @Title update
	* @Description TODO【更新实体对象】
	* @param entity 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void update(T entity);
	
	/**
	* @Title delete
	* @Description TODO【删除实体对象】
	* @param id 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void delete(T entity);
	
	/**
	* @Title delete
	* @Description TODO【删除实体对象】
	* @param id 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void delete(PK id);
	
	/**
	* @Title getTotalCount
	* @Description TODO【查询实体对象数量总数】
	* @return 
	* @Return Long 返回类型
	* @Throws 
	*/ 
	public Long getTotalCount();
	
	/**
	* @Title findAllList
	* @Description TODO【查询实体对象集合】
	* @return 
	* @Return List<T> 返回类型
	* @Throws 
	*/ 
	public List<T> findAllList();
	
	/**
	* @Title findListBy
	* @Description TODO【依据参数查询实体对象集合】
	* @param values
	* @return 
	* @Return List<T> 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public List<T> findListBy(HashMap values);
	
	/**
	* @Title getCountBy
	* @Description TODO【依据参数查询实体对象总数】
	* @param values
	* @return 
	* @Return Long 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public Long getCountBy(HashMap values);

}
