/**
* @FileName MemberWs.java
* @Package com.borbor.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午5:35:23
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.MemberInfoDto;
import com.igrow.mall.bean.entity.MemberInfo;


/**
 * @ClassName MemberWs
 * @Description TODO【会员WS层接口】
 * @Author Brights
 * @Date 2013-10-28 下午5:35:23
 */
public interface MemberWs extends BaseWs<MemberInfo, String> {
	
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
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo register(String mobile, int device, String deviceSn,String openId);
	
	/**
	* @Title memberRegister
	* @Description TODO【会员注册方法】
	* @param mobile
	* @param device
	* @param deviceSn
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo login(String mobile, int device, String deviceSn);
	
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
	* @Description TODO【分页查询】
	* @param memberInfoDto
	* @param pager
	* @return 
	* @Return Pager 返回类型
	* @Throws 
	*/ 
	public Pager findPagerBy(MemberInfoDto memberInfoDto, Pager pager);
   /**
   * @Title findByOpenId
   * @Description TODO【根据openid查找用户编号】
   * @param weixinopenid
   * @return 
   * @Return MemberInfo 返回类型
   * @Throws
    */
	public MemberInfo findByOpenId(String weixinopenid);
	
	/**
	* @Title findByMobile
	* @Description TODO【判断手机号码是否注册】
	* @param mobile
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo findByMobile(String mobile);
}
