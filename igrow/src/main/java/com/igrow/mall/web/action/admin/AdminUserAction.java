/**
* @FileName AdminUserAction.java
* @Package com.igrow.mall.web.action.admin
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午6:08:37
* @Version V1.0.1
*/
package com.igrow.mall.web.action.admin;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.igrow.mall.bean.dto.AdminUserInfoDto;
import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.service.admin.intf.AdminUserService;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName AdminUserAction
 * @Description TODO【管理员用户Action】
 * @Author Brights
 * @Date 2013-10-18 下午6:08:37
 */
@Namespace("/admin/user")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do?idx=0505")
})
public class AdminUserAction extends BaseAction {
	private static final long serialVersionUID = -1887714219428189911L;
	@Resource(name = "adminUserServiceImpl")
	private AdminUserService adminUserService;
	
	private AdminUserInfoDto search;
	private AdminUserInfo result;
	private AdminUserInfo form;
	private String password;
	private String newPassword;
	
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
		if(search == null) search = new AdminUserInfoDto();
		pager = adminUserService.findPagerBy(search, pager);
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
	* @Title save
	* @Description TODO【保存】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(SAVE)
	public String save(){
		if(form == null) return ajaxForwardError("添加管理员失败");
		if(StringUtils.isNotBlank(form.getPassword())){
			form.setPassword(DigestUtils.md5Hex(form.getPassword()));
		}else{
			form.setPassword(DigestUtils.md5Hex("123456"));
		}
		adminUserService.insert(form);
		return ajaxForwardSuccess("添加管理员成功!");
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
		result = adminUserService.find(id);
		return INPUT;
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
		if(form == null) return ajaxForwardError("修改管理员失败");
		AdminUserInfo adminUser = adminUserService.find(form.getId());
		if(adminUser == null)return ajaxForwardError("修改管理员失败");
		adminUser.setEmail(form.getEmail());
		adminUser.setUserName(form.getUserName());
		adminUser.setMobile(form.getMobile());
		adminUser.setName(form.getName());
		if(form.getAccountEnabled() != null){
			Bool boolEnabled = Bool.valueOf(Integer.parseInt(form.getAccountEnabled()));
			adminUser.setIsAccountEnabled(boolEnabled);
		}
		adminUserService.update(adminUser);
		return ajaxForwardSuccess("修改管理员成功!");
	}
	
	
	/**
	* @Title findByUserName
	* @Description TODO【查找账号是否存在】
	* @return 
	* @Return String 返回类型 
	* @Throws 
	*/ 
	@Action("findByUn")
	public String findByUserName(){
		AdminUserInfo au = adminUserService.find(id);
		if(au == null){
			AdminUserInfo adminUser = adminUserService.findByUserName(form.getUserName().trim());
			if(adminUser != null){
				return ajax("false");
			}else{
				return ajax("true");
			}
		}else{
			if(au.getUserName().trim().equals(form.getUserName().trim())){
				return ajax("true");
			}else{
				AdminUserInfo adminUser = adminUserService.findByUserName(form.getUserName().trim());
				if(adminUser != null){
					return ajax("false");
				}else{
					return ajax("true");
				}
			}
		}
	}
	
	/**
	* @Title delete
	* @Description TODO【删除】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DELETE)
	public String delete(){
		return SUCCESS;
	}
	
	/**
	* @Title detail
	* @Description TODO【详情】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("changepwd")
	public String changepwd(){
		return SUCCESS;
	}
	

	@Action("password")
	public String password(){
		AdminUserInfo adminUser = adminUserService.find(id);
		if(adminUser == null){
			return ajaxForwardError("密码修改失败!");
		}
		if(!adminUser.getPassword().equals(DigestUtils.md5Hex(password))){
			return ajaxForwardError("当前密码错误!","");
		}
		if(StringUtils.isBlank(newPassword)){
			return ajaxForwardError("新密码为空!");
		}
		adminUser.setPassword(DigestUtils.md5Hex(newPassword));
		adminUserService.update(adminUser);
		return ajaxForwardSuccess("密码修改成功!");
	}
	
	@Action("resetpwd")
	public String reSetPassword(){
		AdminUserInfo adminUser = adminUserService.find(id);
		if(adminUser == null){
			return ajaxForwardError("账户不存在!");
		}
		adminUser.setPassword(DigestUtils.md5Hex("123456"));
		adminUserService.update(adminUser);
		return ajaxForwardSuccess("重置密码成功!","");
	}

	public AdminUserInfoDto getSearch() {
		return search;
	}

	public void setSearch(AdminUserInfoDto search) {
		this.search = search;
	}

	public AdminUserInfo getResult() {
		return result;
	}

	public void setResult(AdminUserInfo result) {
		this.result = result;
	}

	public AdminUserInfo getForm() {
		return form;
	}

	public void setForm(AdminUserInfo form) {
		this.form = form;
	}

	public String getPassword() {
		return password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
