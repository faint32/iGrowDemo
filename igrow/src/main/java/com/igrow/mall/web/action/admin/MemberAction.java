package com.igrow.mall.web.action.admin;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.igrow.mall.bean.dto.MemberInfoDto;
import com.igrow.mall.bean.entity.MemberInfo;
import com.igrow.mall.service.admin.intf.MemberService;
import com.igrow.mall.web.action.core.BaseAction;


/**
* @ClassName MemberAction
* @Description TODO【会员Aciton】
* @Author Brights
* @Date 2013-10-18 下午6:09:27
*/
@Namespace("/admin/member")
public class MemberAction extends BaseAction {
	private static final long serialVersionUID = 6311331742103341249L;
	@Resource(name = "memberServiceImpl")
	private MemberService memberService;
	
	private MemberInfoDto search;
	private MemberInfo result;
	private MemberInfo form;
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		if(StringUtils.isBlank(idx))idx = "0201";
		if(search == null) search = new MemberInfoDto();
		pager = memberService.findPagerBy(search, pager);
		if(pager.getPageCount()<pager.getPageNumber()){
			pager.setPageNumber(1);
	    }
		return LIST;
	}
	/**
	* @Title detail
	* @Description TODO【详情】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DETAIL)
	public String detail(){
		result = memberService.find(id);
		return INPUT;
	}
	
	
	
	public MemberInfoDto getSearch() {
		return search;
	}
	public void setSearch(MemberInfoDto search) {
		this.search = search;
	}
	public MemberInfo getResult() {
		return result;
	}
	public void setResult(MemberInfo result) {
		this.result = result;
	}
	public MemberInfo getForm() {
		return form;
	}
	public void setForm(MemberInfo form) {
		this.form = form;
	}

}
