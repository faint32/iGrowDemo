<div class="pageContent">
		<div class="pageFormContent" layoutH="57">
			<div class="panel" defH="120">
				<h1>会员详情</h1>
				<div class="pageFormContent" >
					<fieldset>
						<dl>
							<dt>手机号码:</dt>
							<dd>${(result.mobile)!}</dd>
						</dl>
						<dl>
							<dt>设备号:</dt>
							<dd>${(result.deviceSn)!}</dd>
						</dl>
						<dl>
							<dt>微信openid:</dt>
							<dd>${(result.openid)!}</dd>
						</dl>
						<dl>
							<dt>注册时间:</dt>
							<dd><#if result??&&result?exists&&(result.createDate)??&&(result.createDate)?exists>${(result.createDate)?string("yyyy.MM.dd HH:mm:ss")}</#if></dd>
						</dl>
						<dl>
							<dt>累计消费:</dt>
							<dd>${(result.memberAccount.totalSpendAmount)!0}元</dd>
						</dl>
					</fieldset>
				</div>
			</div>
			<div class="panel" defH="265">
					<h1>订单列表</h1>
					<div>
						<table class="table" width="100%">
							<thead>
								<tr>
									<th type="del" width="60">操作</th>
									<th type="del" width="60">操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
			</div>
		</div>
		<div class="formBar">
			<ul>
			</ul>
		</div>
	</form>
	
</div>



