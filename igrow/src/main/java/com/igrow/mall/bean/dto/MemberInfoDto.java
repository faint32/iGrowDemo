/**
* @FileName OrderDetailDto.java
* @Package com.borbor.mall.bean.dto
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-01 下午13:41:31
* @Version V1.0.1
*/
package com.igrow.mall.bean.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.bean.entity.MemberInfo;


/**
 * @ClassName MemberInfoDto
 * @Description TODO【会员详情Dto】
 * @Author Shiyz
 * @Date 2013-11-06 下午13:41:31
 */
public class MemberInfoDto extends MemberInfo implements Serializable{
	private static final long serialVersionUID = -3847705967680402627L;
	private String name;//商品名称
	private BigDecimal minAmount;//起始金额 （ 用于搜索）
	private BigDecimal maxAmount;//结束金额（用于搜索）
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(String minAmount) {
		if(StringUtils.isNotBlank(minAmount)){
			this.minAmount = new BigDecimal(minAmount);
		}
	}
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(String maxAmount) {
		if(StringUtils.isNotBlank(maxAmount)){
			this.maxAmount = new BigDecimal(maxAmount);
		}
	}
}
