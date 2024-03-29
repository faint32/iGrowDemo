package com.igrow.mall.service.protocol.intf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

/**
* @ClassName IntfsDataHandle
* @Description TODO【统一接口数据处理接口】
* @Author Brights
* @Date 2013-10-18 下午5:24:30
*/ 
public interface IntfsDataHandle {
	
	/**
	* @Title process
	* @Description TODO【数据处理方法】
	* @param requestParamsParser
	* @return 
	* @Return HashMap<String,Object> 返回类型
	* @Throws 
	*/ 
	public ModelMap process(HttpServletRequest request,ModelMap modelMap) ;
	
	/**
	* @Title process
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param request
	* @param response
	* @param modelMap
	* @return 
	* @Return ModelMap 返回类型
	* @Throws 
	*/ 
	public ModelMap process(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) ;
	
}
