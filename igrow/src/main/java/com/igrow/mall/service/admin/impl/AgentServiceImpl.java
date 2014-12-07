/**   
* @Title: AgentServiceImpl.java 
* @Package com.igrow.mall.service.admin.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangxu@erayt.com  
* @date 2014-12-6 下午8:39:46 
* @version V1.0
* @copyright (c) 2009-2014 www.erayt.com. All rights reserved
*
*/
package com.igrow.mall.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.AgentDto;
import com.igrow.mall.bean.entity.AgentInfo;
import com.igrow.mall.service.admin.intf.AgentService;
import com.igrow.mall.ws.intf.AgentWs;

/** 
 * @ClassName: AgentServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangxu@erayt.com 
 * @date 2014-12-6 下午8:39:46 
 * @copyright (c) 2009-2014 www.erayt.com. All rights reserved
 * @version V1.0
 */
@Service("agentServiceImpl")
public class AgentServiceImpl extends BaseServiceImpl<AgentInfo, String> implements AgentService {
	@Resource(name="agentWsImpl")
	private AgentWs agentWs;

	@Resource(name="agentWsImpl")
	public void setBaseWs(AgentWs agentWs) {
		super.setBaseWs(agentWs);
	}


	@Override
	public AgentInfo findByName(String name) {
		return agentWs.findByName(name);
	}


	@Override
	public Pager findPagerBy(AgentDto dto, Pager pager) {
		return agentWs.findPagerBy(dto, pager);
	}

}
