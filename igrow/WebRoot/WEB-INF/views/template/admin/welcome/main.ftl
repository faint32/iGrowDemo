<@a.header "${action.getText('ui.manage')}"></@a.header >
<body scroll="no">
	<div id="layout">
		<div id="header">
			<!-- 头部 -->	
			<@a.toper />
			<!-- 头部菜单 -->	
		</div>
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<!--菜单-->
				<@a.menu/>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p><span><a href="#" target="_blank">>>后台使用手册下载</a></span></p>
								<p><span><a href="#" target="_blank">>>微商城使用手册下载</a></span></p>
							</div>
							<div class="right">
								<p>待办工作32项，消息212条</p>
								<p>07月12日，星期二</p>
							</div>
							<p><span>最新消息 </span></p>
							<p><a href="#" target="dialog">>>微商城上线！！</a></p>
							</div>
							<div class="pageCentent">
								<div class="pageFormContent" layoutH="60">
									<fieldset>
										<legend>软件信息</legend>
										<dl>
											<dt>系统名称:</dt>
											<dd>${systemName}</dd>
										</dl>
										<dl>
											<dt>系统版本:</dt>
											<dd>V1.0</dd>
										</dl>
									</fieldset>
									<fieldset>
										<legend>待处理事项</legend>
										<dl >
											<dt>未付款订单:</dt>
											<dd>${unprocessedOrderCount} <a href="order!list.action">[订单列表]</a></dd>
										</dl>
										<dl >
											<dt>待发货订单:</dt>
											<dd>${unprocessedOrderCount} <a href="order!list.action">[订单列表]</a></dd>
										</dl>
										<dl >
											<dt>待签收订单数:</dt>
											<dd>${paidUnshippedOrderCount} <a href="order!list.action">[订单列表]</a></dd>
										</dl>
										<dl >
											<dt>待结算订单数:</dt>
											<dd>${paidUnshippedOrderCount} <a href="order!list.action">[订单列表]</a></dd>
										</dl>
										<dl >
											<dt>未处理缺货登记数:</dt>
											<dd>${unprocessedGoodsNotifyCount} <a href="goods_notify!list.action">[到货通知]</a></dd>
										</dl>
									</fieldset>
									<fieldset>
										<legend>信息统计</legend>
										<dl >
											<dt>已上架商品:</dt>
											<dd>${marketableGoodsCount}</dd>
										</dl>
										<dl >
											<dt>已下架商品:</dt>
											<dd>${unMarketableGoodsCount}</dd>
										</dl>
										<dl >
											<dt>会员总数:</dt>
											<dd>${memberTotalCount}</dd>
										</dl>
									</fieldset>
									<fieldset>
										<legend>系统信息</legend>
										<dl >
											<dt>Java版本:</dt>
											<dd>${javaVersion}</dd>
										</dl>
										<dl >
											<dt>操作系统名称:</dt>
											<dd>${osName}</dd>
										</dl>
										<dl >
											<dt>操作系统构架:</dt>
											<dd>${osArch}</dd>
										</dl>
										<dl >
											<dt>操作系统版本:</dt>
											<dd>${osVersion}</dd>
										</dl>
										<dl >
											<dt>Servlet版本:</dt>
											<dd>${servletVersion}</dd>
										</dl>
										<dl >
											<dt>Server信息:</dt>
											<dd>${serverInfo}</dd>
										</dl>
									</fieldset>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 <!--底部-->
 <@a.footer />  
</body>
</html>