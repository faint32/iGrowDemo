<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${contextPath}/admin/member/list.do?navTabId=${(navTabId)!}" method="post">
	<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					手机号码：<input type="text" id="searchName" name="search.name" value="${(search.name)!}" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查 询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="${contextPath}/admin/member/detail.do?navTabId=${(navTabId)!}&id={sid_user}" target="navTab" rel="edituser" title="会员详情"><span>会员详情</span></a></li>
			<li><a class="icon" href="${contextPath}/admin/member/detail.do?navTabId=${(navTabId)!}&id={sid_user}" target="navTab" rel="edituser" title="订单查询"><span>订单查询</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">手机号码</th>
				<th width="120">绑定设备号</th>
				<th width="120">微信openid</th>
				<th width="120">合计消费</th>
				<th width="100">状态</th>
			</tr>
		</thead>
		<tbody>
		    <#if (pager.results)??>
	        <#list pager.results as obj>
				<tr target="sid_user" rel="${(obj.id)!}">
					<td>${(obj_index + 1)!}</td>
					<td>${(obj.mobile)!}</td>
					<td>${(obj.deviceSn)!}</td>
					<td>${(obj.openid)!}</td>
					<td>${(obj.totalSpendAmount)!"0"}</td>
					<td><#if (obj.isAccountEnabled)?exists && obj.isAccountEnabled.value==1>正常<#else>停用</#if></td>
				</tr>
			 </#list>
			<#else>
        	    <tr>
                 	<td colspan="4">${action.getText("msg.no.data")}</td>
                </tr>
	        </#if>
		</tbody>
	</table>
	 <@a.pagination />  
</div>
