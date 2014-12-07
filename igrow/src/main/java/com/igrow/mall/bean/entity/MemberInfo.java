/**
* @FileName MemberInfo.java
* @Package com.borbor.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午10:42:53
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;


/**
 * @ClassName MemberInfo
 * @Description TODO【会员表】
 * @Author Brights
 * @Date 2013-10-18 上午10:42:53
 */
@Alias("TmemberInfo")
public class MemberInfo extends BaseEntity {
	private static final long serialVersionUID = -5070796931941722876L;
	private String name;//姓名
	private String memberSn;//会员编号
	private String openid;//微信openId
	private String password;//登陆密码
	private String mobile;//电话号码
	private Bool isAccountEnabled; //是否启用
	private Bool isAccountLocked; //是否锁定
	private Integer loginFailureCount; //登陆最大失败次数
	private Date lockedDate;//锁定时间
	private String lastLoginIp;//最后登录IP
	private Date lastLoginDate;//最后登录时间
	private String lastToken; //token
	private Bool isLogin; //是否登录
	
	private String deviceSn;
	private BigDecimal totalSpendAmount;//消费总金额
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberSn() {
		return memberSn;
	}
	public void setMemberSn(String memberSn) {
		this.memberSn = memberSn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastToken() {
		return lastToken;
	}
	public void setLastToken(String lastToken) {
		this.lastToken = lastToken;
	}
	public Bool getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(Bool isLogin) {
		this.isLogin = isLogin;
	}
	
	@Override
	public void onInsert() {
		if (StringUtils.isBlank(memberSn)) {
			//memberSn = SerialNumberUtil.buildMemberSn();
		}
		if(isAccountEnabled == null){
			isAccountEnabled = Bool.TRUE;
		}
		if(isAccountLocked == null){
			isAccountLocked = Bool.FALSE;
		}
		super.onInsert();
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	public BigDecimal getTotalSpendAmount() {
		return totalSpendAmount;
	}
	public String getDeviceSn() {
		return deviceSn;
	}
	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	public void setTotalSpendAmount(BigDecimal totalSpendAmount) {
		this.totalSpendAmount = totalSpendAmount;
	}
	
	

}
