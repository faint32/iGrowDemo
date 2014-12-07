<div class="pageContent">
	<form method="post" action="${contextPath}/admin/agent/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="form.id" value="${(result.id)!}" />
		<input type="hidden" name="navTabId" value="${(navTabId)!}" />
		<div class="pageFormContent" layoutH="57">
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>名称：</dt>
				<dd><input type="text" name="form.name" value="${(result.name)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>联系人：</dt>
				<dd><input type="text" name="form.contactName" value="${(result.contactName)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>联系电话：</dt>
				<dd><input type="text" name="form.phone" value="${(result.phone)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>${action.getText("user.email")}：</dt>
				<dd><input type="text" name="form.email" value="${(result.email)!}"  size="30" class="required email"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>${action.getText("user.mobile")}：</dt>
				<dd><input type="text" name="form.mobile" value="${(result.mobile)!}"  size="30" class="required phone"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>区域：</dt>
				<dd>
				<select class="combox" name="form.province.id" ref="w_combox_city" refUrl="${contextPath}/admin/area/findCitys.do?id={value}" class="required">
				<option value="">请选择省</option>
				<#list provinces as obj>
				 <option value="${obj.provinceSn}">${obj.name}</option>
				</#list>
				</select>
				<select class="combox" name="form.city.id" id="w_combox_city" ref="w_combox_area" refUrl="${contextPath}/admin/area/findAreas.do?id={value}" class="required">
				<option value="">所有城市</option>
				</select>
				<select class="combox" name="form.area.id" id="w_combox_area" class="required">
				<option value="">所有区县</option>
				</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>地址：</dt>
				<dd><input type="text" name="form.mobile" value="${(result.mobile)!}"  size="30" class="required phone"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>状态：</dt>
				<dd>
				<label><input type="radio" value="1" name="form.status" id="status" <#if result?exists&&(result.status)?exists&&(result.status)??&&result.status.value==1>checked="checked"</#if>/>启用</label>
				<label><input type="radio" value="0" name="form.status" id="status" <#if result?exists&&(result.status)?exists&&(result.status)??&&result.status.value==0>checked="checked"</#if>/>停用</label>
				</dd>
			</dl>
			<div class="divider"></div>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>最新修改时间：</dt>
				<dd>
				<input type="text" name="date12" class="date" value="${(result.modifyDate?string("yyyy-MM-dd HH:mm:ss"))!}" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="true"/>
				<a class="inputDateButton" href="javascript:;">选择</a></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>最新修改人员：</dt>
				<dd><input readonly="readonly" type="text" size="30" value="${(admin.userName)!}" /></dd>
			</dl>
			<div class="divider"></div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
