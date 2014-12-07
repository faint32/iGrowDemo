<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${contextPath}/admin/agent/list.do?navTabId=${(navTabId)!}" method="post">
	<input type="hidden" name="pager.pageNumber" value="${(pager.pageNumber)!1}" />
	<input type="hidden" name="pager.pageSize" value="${(pager.pageSize)!1}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" id="searchName" name="search.name" value="${(search.name)!}" />
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
			<li><a class="add" href="${contextPath}/admin/agent/add.do?navTabId=${(navTabId)!}" target="navTab" rel="adduser" title="添加代理商"><span>添加</span></a></li>
			<li><a class="delete" href="${contextPath}/admin/agent/delete.do?navTabId=${(navTabId)!}&id={sid_user}" target="ajaxTodo" title="确定要删除代理商吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${contextPath}/admin/agent/edit.do?navTabId=${(navTabId)!}&id={sid_user}" target="navTab" rel="edituser" title="修改代理商"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="170">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">名称</th>
				<th width="120">联系人</th>
				<th width="120">手机号码</th>
				<th width="120">区域</th>
				<th width="100">状态</th>
			</tr>
		</thead>
		<tbody>
		    <#if (pager.results)??>
	        <#list pager.results as obj>
				<tr target="sid_user" rel="${(obj.id)!}">
					<td>${(obj_index + 1)!}</td>
					<td>${(obj.name)!}</td>
					<td>${(obj.contactName)!}</td>
					<td>${(obj.mobile)!}</td>
					<td>${(obj.areaDesc)!}</td>
					<td>
		            <#if obj?exists&&(obj.status)?exists&&(obj.status)??&&obj.status.value==0>停用<#else>启用</#if>
		            </td>
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
