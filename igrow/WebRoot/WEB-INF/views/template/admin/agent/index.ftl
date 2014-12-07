<script type="text/javascript">
	$(function(){
		$("#jbsxBox").loadUrl("${contextPath}/admin/agent/list.do?navTabId=${(navTabId)!}",null);
	});
</script>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>
<div class="pageContent">
	<div class="tabs" >
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>代理商管理</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
				<div layoutH="57" style="float:left; display:block; overflow:auto; width:240px; border:solid 1px #CCC; line-height:21px; background:#fff">
				    <ul class="tree treeFolder expand">
						<li><a href="${contextPath}/admin/agent/list.do?navTabId=${(navTabId)!}" target="ajax" rel="jbsxBox">国内</a>
							<ul>
								<#list provinces as obj>
									<li><a href="${contextPath}/admin/agent/list.do?navTabId=${(navTabId)!}&id=${obj.provinceSn}" target="ajax" rel="jbsxBox">${obj.name}</a>
									<ul>
									<#if (obj.cities)??&&(obj.cities)?exists>
										<#list obj.cities as subObj>
											<li><a href="${contextPath}/admin/agent/list.do?navTabId=${(navTabId)!}&id=${subObj.provinceSn}" target="ajax" rel="jbsxBox">${subObj.name}</a></li>
										</#list>
									</#if>
									</ul>
									</li>
								</#list>
							</ul>
						</li>
				     </ul>
				</div>
				
				<div id="jbsxBox" class="unitBox" style="margin-left:246px;">
					<!--#include virtual="list1.html" -->
				</div>
	
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>


	

