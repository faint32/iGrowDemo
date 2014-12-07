<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理中心 - Powered By ${action.getText("ui.title")}</title>
<link href="${contextPath}/favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link href="${contextPath}/themes/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${contextPath}/js/validform/Validform_v5.3.2.js"></script>
<script type="text/javascript">
	$(function(){
		// 刷新验证码
		 $("#captchaImage").click(function(){
			var timestamp = (new Date()).valueOf();
			var imageSrc = $("#captchaImage").attr("src");
			if(imageSrc.indexOf("?") >= 0) {
				imageSrc = imageSrc.substring(0, imageSrc.indexOf("?"));
			}
			imageSrc = imageSrc + "?timestamp=" + timestamp;
			$("#captchaImage").attr("src", imageSrc);
		});
		
		
		// 登陆按钮
		 $(".sub").click(function(){
			  if($("#userName").val()==''|| $("#userName").val()=='请输入用户名'){
			  		$(".notice_wrong").text("")
				  	$(".notice_wrong").text("请输入用户名！");
				  	//$("#userName").addClass("red_box").siblings("input").removeClass("red_box");
				  	//$("#userName").select();
				  	return;
			  }
			  if($("#pwd").val()==''|| $("#pwd").val()=='密码'){
				  	$(".notice_wrong").text("")
				  	$(".notice_wrong").text("请输入密码！");
				    //$("#tx").select();
				    //$("#tx").addClass("red_box").siblings("input").removeClass("red_box");
				  	return;
			  }
			 var vform= $("#loginForm").Validform({
				tiptype:4,
				ajaxPost:true,
				callback:function(data){
					if(data.status=="y"){
						//加载成功页面
						document.location.href="${contextPath}/admin/welcome/main.do?redirectUrl=${redirectUrl}";
					}else{
						alert(data.info);
						//$(".notice_wrong").text("")
				  		//$(".notice_wrong").text(data.info);
						$("#captcha").val(""); 
						$("#captchaImage").trigger("click");
						return false;
					}
				}
			 });
	 		 $("#loginForm").submit();
			 return false;
		});
				
		$("#tx").focus(function(){
			$(this).hide();
			$("#pwd").show().val("").select();
		});
		$("#pwd").blur(function(){
			if($(this).val() == "" || $(this).val() == "undefined"){
				$(this).hide();
				$("#tx").show();
			}
		})
	});
	//回车
    $(document).keypress(function(event) {  
 		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode; 
	     if(keyCode==13){//按回车键
	     	$(".sub").trigger("click");
         }
	}); 
</script>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="${contextPath}/themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="#">反馈</a></li>
						<li><a href="#" target="_blank">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="${contextPath}/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				 <form id="loginForm" class="loginForm" method="post" action="${contextPath}/admin/welcome/login.do" >
       				<input type="hidden" name="redirectUrl" value="${redirectUrl}" />
					<p>
						<label>用户名：</label>
						<input type="text" name="userName" id="userName"  message="请输入用户名" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password"  id="tx" message="密码" size="20" class="login_input" />
						<input type="password" class="input_box" id="pwd" name="password" value="" style="display:none" />
					</p>
					<p>
						<label>验证码：</label>
						<input class="code" type="text" size="5" id="captcha" name="captcha" message="请输入验证码"/>
						<span><img id="captchaImage" alt="换一张" src="${contextPath}/captcha.jpeg" width="60" height="24" /></span>
					</p>
					<div class="login_bar">
						<input class="sub" type="button" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="${contextPath}/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
					<li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li>
				</ul>
				<div class="login_inner">
					<p>iGrow微商城订单管理系统</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			${action.getText("ui.copyrights")}
		</div>
	</div>
</body>
</html>