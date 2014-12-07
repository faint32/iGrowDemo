/**   
* @Title: AgentWsImpl.java 
* @Package com.igrow.mall.ws.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangxu@erayt.com  
* @date 2014-12-6 下午8:35:38 
* @version V1.0
* @copyright (c) 2009-2014 www.erayt.com. All rights reserved
*
*/
package com.igrow.mall.ws.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.AgentDto;
import com.igrow.mall.bean.entity.AgentInfo;
import com.igrow.mall.dao.mybatis.intf.AgentDao;
import com.igrow.mall.ws.intf.AgentWs;

/** 
 * @ClassName: AgentWsImpl 
 * @Description: TODO(AgentWsImpl) 
 * @author wangxu@erayt.com 
 * @date 2014-12-6 下午8:35:38 
 * @copyright (c) 2009-2014 www.erayt.com. All rights reserved
 * @version V1.0
 */
@Service("agentWsImpl")
public class AgentWsImpl extends BaseWsImpl<AgentInfo, String> implements AgentWs {
	@Resource(name = "agentDao")
	private AgentDao agentDao;

	@Resource(name = "agentDao")
	public void setBaseDao(AgentDao agentDao) {
		super.setBaseDao(agentDao);
	}

	@Override
	public AgentInfo findByName(String name) {
		return agentDao.findByName(name);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(AgentDto dto, Pager pager) {
		HashMap values = new HashMap();
		if(dto != null && dto.getName() != null && StringUtils.isNotBlank(dto.getName())){
			values.put("name", dto.getName());
		}
		
		Long count = agentDao.getCountBy(values);
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
			List<AgentInfo> infos = agentDao.findListBy(values);
			if(infos != null && infos.size() > 0){
				pager.setResults(infos);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(infos.get(0).getId());
				}
			}
		}else{
			pager.setFisrtId(null);
		}
		return pager;
	}
	
	
	
}
