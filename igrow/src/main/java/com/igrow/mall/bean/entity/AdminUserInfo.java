/**
* @FileName AdminUserInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午10:02:46
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;


/**
 * @ClassName AdminUserInfo
 * @Description TODO【管理员用户信息表】
 * @Author Brights
 * @Date 2013-10-18 上午10:02:46
 */
@Alias("TadminUser")
public class AdminUserInfo extends BaseEntity {

	private static final long serialVersionUID = 7138754959097469429L;
	public static final String ADMINUSER_USERSN_SESSION = "adminUser";// 保存登录会员ID的Session名称
	private String name;//姓名
	private String userSn;//管理员编号
	private String userName;//登陆用户名
	private String password;//登陆密码
	private String email;//电子邮箱
	private String mobile;//电话号码
	private Bool isAccountEnabled; //是否启用
	private Bool isAccountLocked; //是否锁定
	private Bool isOnline; //是否在线
	private Integer loginFailureCount; //登陆最大失败次数
	private Date lockedDate;//锁定时间
	private String lastLoginIp;//最后登录IP
	private Date lastLoginDate;//最后登录时间
	private List<RoleInfo> roleInfos;//用户所属角色
	private AdminRoleGroupConf adminRoleGroupConf; //管理员角色组配置
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Bool getIsAccountEnabled() {
		return isAccountEnabled;
	}
	public void setIsAccountEnabled(Bool isAccountEnabled) {
		this.isAccountEnabled = isAccountEnabled;
	}
	public Bool getIsAccountLocked() {
		return isAccountLocked;
	}
	public void setIsAccountLocked(Bool isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}
	public Date getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}
	public String getUserSn() {
		return userSn;
	}
	public void setUserSn(String userSn) {
		this.userSn = userSn;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Bool getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(Bool isOnline) {
		this.isOnline = isOnline;
	}
	public List<RoleInfo> getRoleInfos() {
		return roleInfos;
	}
	public void setRoleInfos(List<RoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
	}
	private String accountEnabled;
	/**
	 * @return the adminRoleGroupConf
	 */
	public AdminRoleGroupConf getAdminRoleGroupConf() {
		return adminRoleGroupConf;
	}
	/**
	 * @param adminRoleGroupConf the adminRoleGroupConf to set
	 */
	public void setAdminRoleGroupConf(AdminRoleGroupConf adminRoleGroupConf) {
		this.adminRoleGroupConf = adminRoleGroupConf;
	}
	public String getAccountEnabled() {
		return accountEnabled;
	}
	public void setAccountEnabled(String accountEnabled) {
		this.accountEnabled = accountEnabled;
	}
	
	@Override
	public void onInsert() {
		if(isAccountLocked == null){
			isAccountLocked = Bool.FALSE;
		}
		if(isAccountEnabled == null){
			isAccountEnabled = Bool.TRUE;
		}
		if(loginFailureCount == null){
			loginFailureCount = 0;
		}
		if(isOnline == null){
			isOnline = Bool.FALSE;
		}
		super.onInsert();
	}
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	@Override
	public void onDelete() {
		super.onDelete();
	}
}
