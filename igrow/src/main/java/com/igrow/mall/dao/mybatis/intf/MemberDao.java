/**
* @FileName MemberDao.java
* @Package com.borbor.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午1:00:53
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.MemberInfo;

/**
 * @ClassName MemberDao
 * @Description TODO【会员Dao】
 * @Author Brights
 * @Date 2013-10-28 下午1:00:53
 */
public interface MemberDao extends BaseDao<MemberInfo, String> {
	
	/**
	* @Title findBySn
	* @Description TODO【依据编号查询对象】
	* @param memberSn
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo findBySn(String sn);
	
	/**
	* @Title findByMobile
	* @Description TODO【判断手机号码是否注册】
	* @param mobile
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public MemberInfo findByMobile(String mobile);
  /**
   * @Title findByOpenId
   * @Description TODO【根据openid查找用户编号】
   * @param openId
   * @return 
   * @Return MemberInfo 返回类型
   * @Throws
    */
	public MemberInfo findByOpenId(String openid);
}
