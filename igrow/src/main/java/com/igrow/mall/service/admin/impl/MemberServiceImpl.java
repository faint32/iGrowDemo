/**
* @FileName MemberServiceImpl.java
* @Package com.borbor.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午10:12:38
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.MemberInfoDto;
import com.igrow.mall.bean.entity.MemberInfo;
import com.igrow.mall.service.admin.intf.MemberService;
import com.igrow.mall.ws.intf.MemberWs;


/**
 * @ClassName MemberServiceImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-29 上午10:12:38
 */
/**
* @ClassName MemberServiceImpl
* @Description TODO【这里用一句话描述这个类的作用】
* @Author Brights
* @Date 2013-10-29 上午10:13:29
*/ 
@Service("memberServiceImpl")
public class MemberServiceImpl extends BaseServiceImpl<MemberInfo, String> implements
		MemberService {
	
	@Resource(name = "memberWsImpl")
	private MemberWs memberWs;
	@Resource(name = "memberWsImpl")
	public void setBaseWs(MemberWs memberWs) {
		super.setBaseWs(memberWs);
	}
	
	@Override
	public boolean isExistBySn(String sn) {
		return memberWs.isExistBySn(sn);
	}
	@Override
	public boolean isExistByMobile(String mobile) {
		return memberWs.isExistByMobile(mobile);
	}
	@Override
	public MemberInfo register(String mobile, int device,
			String deviceSn,String openId) {
		return memberWs.register(mobile, device, deviceSn,openId);
	}
	@Override
	public MemberInfo login(String mobile, int device, String deviceSn) {
			return memberWs.login(mobile,device,deviceSn);
	}
	@Override
	public MemberInfo findBySn(String sn) {
		return memberWs.findBySn(sn);
	}
	@Override
	public Pager findPagerBy(MemberInfoDto memberInfoDto, Pager pager) {
		return memberWs.findPagerBy(memberInfoDto, pager);
	}
	@Override
	public void addMemberFeedback(MemberInfo member, String content) {
	}
	@Override
	public MemberInfo findByOpenId(String weixinopenid) {
		return memberWs.findByOpenId(weixinopenid);
	}
	@Override
	public MemberInfo findByMobile(String mobile) {
		return memberWs.findByMobile(mobile);
	}


}
