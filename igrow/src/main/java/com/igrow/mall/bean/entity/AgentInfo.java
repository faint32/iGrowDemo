/**
* @FileName AgentInfo.java
* @Package com.borbor.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午11:08:38
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;


import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.Status;

/**
 * @ClassName AgentInfo
 * @Description TODO【代理商表】
 * @Author Brights
 * @Date 2013-10-18 上午11:08:38
 */
@Alias("TagentInfo")
public class AgentInfo extends BaseEntity {
	private static final long serialVersionUID = -4156127420474731188L;
	
	private String agentSn;//编码
	private String name;//名称
	private String contactName;//联系人
	private String phone;//联系电话
	private String mobile;//手机号码
	private String email;//电子邮箱
	private String address;//地址
	private Status status;//状态
	private Bool isDelete;//是否删除
	private Bool isSmsRemind;//是否短信提醒
	private Bool isEmailRemind;//是否邮件提醒
	private String areaDesc;//区域
	private String cityId;
	private String areaId;
	private String provinceId;
	private String parentId;
	
	private Cities city;//市
	private Areas area;//区
	private Provinces province;//省
	private AgentInfo parent;
	
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the isSmsRemind
	 */
	public Bool getIsSmsRemind() {
		return isSmsRemind;
	}
	/**
	 * @param isSmsRemind the isSmsRemind to set
	 */
	public void setIsSmsRemind(Bool isSmsRemind) {
		this.isSmsRemind = isSmsRemind;
	}
	/**
	 * @return the isEmailRemind
	 */
	public Bool getIsEmailRemind() {
		return isEmailRemind;
	}
	@Override
	public void onInsert() {
		if(isSmsRemind == null){
			isSmsRemind = Bool.FALSE;
		}
		if(isEmailRemind == null){
			isEmailRemind = Bool.FALSE;
		}
		if(isDelete == null){
			isDelete = Bool.FALSE;
		}
		if(status == null){
			status = Status.Enabled;
		}
		super.onInsert();
	}
	@Override
	public void onUpdate() {
		if(isSmsRemind == null){
			isSmsRemind = Bool.FALSE;
		}
		if(isEmailRemind == null){
			isEmailRemind = Bool.FALSE;
		}
		if(isDelete == null){
			isDelete = Bool.FALSE;
		}
		if(status == null){
			status = Status.Enabled;
		}
		super.onUpdate();
	}
	@Override
	public void onDelete() {
		super.onDelete();
	}
	/**
	 * @param isEmailRemind the isEmailRemind to set
	 */
	public void setIsEmailRemind(Bool isEmailRemind) {
		this.isEmailRemind = isEmailRemind;
	}
	/**
	 * @return the isDelete
	 */
	public Bool getIsDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Bool isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Cities getCity() {
		return city;
	}
	public String getCityId() {
		return cityId;
	}
	public String getAreaId() {
		return areaId;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Areas getArea() {
		return area;
	}
	public Provinces getProvince() {
		return province;
	}
	public String getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public AgentInfo getParent() {
		return parent;
	}
	public void setCity(Cities city) {
		this.city = city;
	}
	public String getAgentSn() {
		return agentSn;
	}
	public void setAgentSn(String agentSn) {
		this.agentSn = agentSn;
	}
	public void setArea(Areas area) {
		this.area = area;
	}
	public void setProvince(Provinces province) {
		this.province = province;
	}
	public void setParent(AgentInfo parent) {
		this.parent = parent;
	}
}
