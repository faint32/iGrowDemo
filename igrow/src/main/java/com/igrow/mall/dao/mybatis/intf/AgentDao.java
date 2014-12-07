/**   
* @Title: AgentDao.java 
* @Package com.igrow.mall.dao.mybatis.intf 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangxu@erayt.com  
* @date 2014-12-6 下午8:08:28 
* @version V1.0
* @copyright (c) 2009-2014 www.erayt.com. All rights reserved
*
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.AgentInfo;

/** 
 * @ClassName: AgentDao 
 * @Description: TODO(代理商Dao) 
 * @author wangxu@erayt.com 
 * @date 2014-12-6 下午8:08:28 
 * @copyright (c) 2009-2014 www.erayt.com. All rights reserved
 * @version V1.0
 */
public interface AgentDao extends BaseDao<AgentInfo, String> {
	
	/** 
	* @Title: findByName 
	* @Description: TODO(按名称查询代理商) 
	* @author wangxu@erayt.com 
	* @param @param name
	* @param @return    设定文件 
	* @return AgentInfo    返回类型 
	* @throws 
	* @see 
	*/
	public AgentInfo findByName(String name);
}
