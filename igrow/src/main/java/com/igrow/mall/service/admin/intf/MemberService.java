/**
* @FileName MemberService.java
* @Package com.borbor.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午10:11:20
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.MemberInfoDto;
import com.igrow.mall.bean.entity.MemberInfo;


/**
 * @ClassName MemberService
 * @Description TODO【会员服务层接口】
 * @Author Brights
 * @Date 2013-10-29 上午10:11:20
 */
public interface MemberService extends BaseService<MemberInfo, String> {
	/**
	* @Title isExistBySn
	* @Description TODO【是否存在会员编号】
	* @param sn
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean isExistBySn(String sn);
	
	/**
	* @Title isExistByMobile
	* @Description TODO【是否存在已注册的手机号码】
	* @param mobile
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean isExistByMobile(String mobile);
	
	/**
	* @Title memberRegister
	* @Description TODO【会员注册方法】
	* @param mobile
	* @param device
	* @param deviceSn
	* @param openId
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo register(String mobile,int device,String deviceNo,String openId);
	
	/**
	* @Title login
	* @Description TODO【会员登录】
	* @param mobile
	* @param device
	* @param deviceNo
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo login(String mobile,int device,String deviceNo);
	
	/**
	* @Title findBySn
	* @Description TODO【依据会员编号查询会员】
	* @param sn
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo findBySn(String sn);
	/**
	* @Title findPagerBy
	* @Description TODO【】
	* @return 
	* @Return Pager 返回类型
	* @Throws 
	*/ 
	public Pager findPagerBy(MemberInfoDto search, Pager pager);
	/**
	* @Title AddMemberFeedback
	* @Description TODO【添加会员意见反馈】
	* @param member
	* @param content 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void addMemberFeedback(MemberInfo member,String content);
	/**
	* @Title findByOpenId
	* @Description TODO【根据openid查找用户】
	* @param weixinopenid
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws
	 */
	public MemberInfo findByOpenId(String weixinopenid);
	/**
	* @Title findByMobile
	* @Description TODO【根据mobile查找用户】
	* @param weixinopenid
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws
	 */
	public MemberInfo findByMobile(String mobile);

}
