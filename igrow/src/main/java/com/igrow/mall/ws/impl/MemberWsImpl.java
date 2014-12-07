/**
* @FileName MemberWsImpl.java
* @Package com.borbor.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午6:04:12
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.MemberInfoDto;
import com.igrow.mall.bean.entity.MemberInfo;
import com.igrow.mall.common.enums.Device;
import com.igrow.mall.dao.mybatis.intf.MemberDao;
import com.igrow.mall.ws.intf.MemberWs;

/**
 * @ClassName MemberWsImpl
 * @Description TODO【会员WS接口服务】
 * @Author Brights
 * @Date 2013-10-28 下午6:04:12
 */
@Service("memberWsImpl")
public class MemberWsImpl extends BaseWsImpl<MemberInfo, String> implements MemberWs {
	@Resource(name = "memberDao")
	private MemberDao memberDao;
	@Resource(name = "memberDao")
	public void setBaseDao(MemberDao memberDao) {
		super.setBaseDao(memberDao);
	}
	
	@Override
	public boolean isExistBySn(String sn) {
		MemberInfo member = memberDao.findBySn(sn);
		if(member != null){
			return true;
		}
		return false;
	}
	@Override
	public boolean isExistByMobile(String mobile) {
		MemberInfo member = memberDao.findByMobile(mobile);
		if(member != null){
			return true;
		}
		return false;
	}
	@Override
	@Transactional
	public MemberInfo register(String mobile, int device, String deviceSn,String openId) {
		MemberInfo member = memberDao.findByMobile(mobile);
		if (member == null) {
			member = new MemberInfo();
			member.setMobile(mobile);
			member.setOpenid(openId);
			super.insert(member);
		} else {
			member.setOpenid(openId);
			super.update(member);
		}
		return member;
	}
	@Override
	@Transactional
	public MemberInfo login(String mobile, int device, String deviceSn) {
		MemberInfo member = memberDao.findByMobile(mobile);
		if (member == null) {
			member = new MemberInfo();
			member.setMobile(mobile);
			super.insert(member);
		} else {
			super.update(member);
		}
		return member;
	}
	@Override
	public MemberInfo findBySn(String sn) {
		return memberDao.findBySn(sn);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(MemberInfoDto memberInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(memberInfoDto.getName() != null && StringUtils.isNotBlank(memberInfoDto.getName())){
			values.put("name", memberInfoDto.getName());
		}
		if(memberInfoDto.getMinAmount() != null){
			values.put("minAmount", memberInfoDto.getMinAmount());
		}
		if(memberInfoDto.getMaxAmount() != null){
			values.put("maxAmount", memberInfoDto.getMaxAmount());
		}
		
		if(memberDao != null){
			//查询数量
		}
		Long count = memberDao.getCountBy(values);
		pager.setTotalCount(count);
		if(pager.getPageNumber() >= pager.getPageCount()){
			pager.setPageNumber(pager.getPageCount());
		}
		if(count > 0){
			values.put("firstIndex",pager.getFirstIndex());
			values.put("pageSize",pager.getPageSize());
			values.put("orderBy", pager.getOrderBy());
			values.put("order", pager.getOrder());
			//查询记录
			List<MemberInfo> members = memberDao.findListBy(values);
			if(members != null && members.size() > 0){
				pager.setResults(members);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(members.get(0).getId());
				}
			}
		}
		return pager;
	}
	@Override
	public MemberInfo findByOpenId(String openId) {
		return memberDao.findByOpenId(openId);
	}
	/**
	* @Title findByMobile
	* @Description 
	* @param mobile
	* @return
	* @see com.borbor.mall.ws.intf.MemberWs#findByMobile(java.lang.String)
	*/ 
	@Override
	public MemberInfo findByMobile(String mobile) {
		return memberDao.findByMobile(mobile);
	}
	
}
