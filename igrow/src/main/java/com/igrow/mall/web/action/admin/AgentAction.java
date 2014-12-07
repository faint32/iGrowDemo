/**   
* @Title: AgentAction.java 
* @Package com.igrow.mall.web.action.admin 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangxu@erayt.com  
* @date 2014-12-6 下午8:47:40 
* @version V1.0
* @copyright (c) 2009-2014 www.erayt.com. All rights reserved
*
*/
package com.igrow.mall.web.action.admin;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;

import com.igrow.mall.bean.dto.AgentDto;
import com.igrow.mall.bean.entity.AgentInfo;
import com.igrow.mall.service.admin.intf.AgentService;
import com.igrow.mall.web.action.core.BaseAction;

/** 
 * @ClassName: AgentAction 
 * @Description: TODO(代理商) 
 * @author wangxu@erayt.com 
 * @date 2014-12-6 下午8:47:40 
 * @copyright (c) 2009-2014 www.erayt.com. All rights reserved
 * @version V1.0
 */
@Namespace("/admin/agent")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do?idx=0505")
})
public class AgentAction extends BaseAction {
	private static final long serialVersionUID = 2490444424698284580L;
	@Resource(name = "agentServiceImpl")
	private AgentService  agentService;
	
	private AgentDto search;
	private AgentInfo result;
	private AgentInfo form;
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(INDEX)
	public String index(){
		if(StringUtils.isBlank(idx))idx = "0505";
		if(search == null) search = new AgentDto();
		pager = agentService.findPagerBy(search, pager);
		return SUCCESS;
	}
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		if(StringUtils.isBlank(idx))idx = "0505";
		if(search == null) search = new AgentDto();
		pager = agentService.findPagerBy(search, pager);
		return LIST;
	}
	
	/**
	* @Title add
	* @Description TODO【添加】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(ADD)
	public String add(){
		return INPUT;
	}
	
	/**
	* @Title edit
	* @Description TODO【编辑】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(EDIT)
	public String edit(){
		result = agentService.find(id);
		return INPUT;
	}
	
	/**
	* @Title save
	* @Description TODO【保存】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(SAVE)
	public String save(){
		if(form == null) return ajaxForwardError("添加代理商失败!");
		agentService.insert(form);
		return ajaxForwardSuccess("添加代理商成功!");
	}
	
	/**
	* @Title update
	* @Description TODO【修改】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(UPDATE)
	public String update(){
		if(form == null) return ajaxForwardError("修改代理商失败!");
		AgentInfo entity = agentService.find(form.getId());
		if(entity == null)return ajaxForwardError("修改代理商失败!");
		String[] ignorePropertie = {"id","createDate","createOperator"};
		//对象copy
		BeanUtils.copyProperties(form, entity, ignorePropertie);
		agentService.update(entity);
		return ajaxForwardSuccess("修改代理商成功!");
	}
	
	/** 
	* @Title: delete 
	* @Description: TODO(删除) 
	* @author wangxu@erayt.com 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @see 
	*/
	@Action(DELETE)
	public String delete(){
		AgentInfo entity = agentService.find(id);
		if(entity == null)return ajaxForwardError("删除代理商失败!");
		agentService.delete(entity);
		return ajaxForwardSuccess("删除代理商成功!","");
	}
	
	
	public AgentDto getSearch() {
		return search;
	}

	public AgentInfo getResult() {
		return result;
	}

	public AgentInfo getForm() {
		return form;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public void setSearch(AgentDto search) {
		this.search = search;
	}

	public void setResult(AgentInfo result) {
		this.result = result;
	}

	public void setForm(AgentInfo form) {
		this.form = form;
	}

}
