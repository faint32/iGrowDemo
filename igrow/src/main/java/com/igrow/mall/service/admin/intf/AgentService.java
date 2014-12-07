/**   
* @Title: AgentService.java 
* @Package com.igrow.mall.service.admin.intf 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangxu@erayt.com  
* @date 2014-12-6 下午8:39:00 
* @version V1.0
* @copyright (c) 2009-2014 www.erayt.com. All rights reserved
*
*/
package com.igrow.mall.service.admin.intf;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.AgentDto;
import com.igrow.mall.bean.entity.AgentInfo;

/** 
 * @ClassName: AgentService 
 * @Description: TODO(AgentService) 
 * @author wangxu@erayt.com 
 * @date 2014-12-6 下午8:39:00 
 * @copyright (c) 2009-2014 www.erayt.com. All rights reserved
 * @version V1.0
 */
public interface AgentService extends BaseService<AgentInfo, String> {
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
	
	/** 
	* @Title: findPagerBy 
	* @Description: TODO(分页查询) 
	* @author wangxu@erayt.com 
	* @param @param dto
	* @param @param pager
	* @param @return    设定文件 
	* @return Pager    返回类型 
	* @throws 
	* @see 
	*/
	public Pager findPagerBy(AgentDto dto, Pager pager);
}
