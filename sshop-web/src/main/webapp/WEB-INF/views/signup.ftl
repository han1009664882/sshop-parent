<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>购汇玩—-注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="${ctx}/res/register/favicon.ico" />
<link rel="bookmark" href="${ctx}/res/register/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/res/css/old/reset.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/home.css">
<link rel="stylesheet" href="/res/css/public_bottom.css" />
<link rel="stylesheet" type="text/css" href="/res/css/old/reset.css"/>
<script type="text/javascript" src="${ctx}/res/js/old/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/res/js/common.js"></script>
<script>
	var ctx = "${ctx}/";
</script>
</head>
<body>
	<!-- 注册-->
	<div style="position: relative;">
		<div style="width: 100%; height: 75px;">
			<a onclick="location.href ='${ctx}/index.html'">
				<img src="${ctx}/res/img/index/logo.png" class="backgroundimg">
			</a>
		</div>
		<div style="width: 100%; margin: 0px;">
			<img src="${ctx}/res/img/login.png" class="logicon" />
			<form method="post" id="form">
				<input id="backurl" type="hidden" value="${backurl!}" />
				<div class="regcontent">
					<div class="box1">
						<div style="margin-bottom: 20px;">
							<span class="register">注册新用户</span>
							<span class="reg">
								<a href="${ctx}/user/login.html" style="font-size: 18px;">登录</a> 
							</span>
						</div>
						<div class="container1">
							<div class="icona">
								<img src="${ctx}/res/img/index/phone.png" width="26px"
									height="26px" />
							</div>
							<div class="inputbox">
								<input type="text" id="input_mobile" name="mobile"
									class="input1" placeholder="手机号" onblur="yzmobile()">
							</div>
							<div id="hidden_mobile" hidden class="valid">
								<span>手机号不能为空</span>
							</div>
							
						</div>
						<div class="container1">
							<div class="icona">
								<img src="${ctx}/res/img/index/pass.png" width="26px"
									height="26px" />
							</div>
							<div class="inputbox">
								<input type="text" class="input2" id="code" name="code" placeholder="验证码"> 
								<input id="vf_codes_btn" class="button1 vf_codes_btn" type="button" value="获取验证码" >
							</div>
							<div hidden id="hidden_code" class="valid">
								<span>验证码不能为空</span>
							</div>
						</div>
						<div class="container1">
							<div class="icona">
								<img src="${ctx}/res/img/index/account.png" width="26px"
									height="26px" />
							</div>
							<div class="inputbox">
								<input type="text" id="firstName" name="firstname" class="input3"
									placeholder="姓不能超过两个字"> <input type="text"
									id="lastName" name="lastname" class="input4"
									placeholder="名不能超过两个字">
							</div>
							<div hidden id="hidden_username" class="valid">
								<span>姓和名都不能为空!</span>
							</div>
						</div>
						<div class="container1">
							<div class="icona">
								<img src="${ctx}/res/img/index/pass.png" width="26px"
									height="26px" />
							</div>
							<div class="inputbox">
								<input type="password" id="password" name="password"
									class="input1" placeholder="密码" onblur="yzpass()">
							</div>
							<div hidden id="hidden_password" class="valid">
								<span>密码不能为空</span>
							</div>
						</div>
						<div class="container1">
							<div class="icona">
								<img src="${ctx}/res/img/index/pass.png" width="26px"
									height="26px" />
							</div>
							<div class="inputbox">
								<input type="password" id="confirmPwd" name="confirmPwd"
									class="input1" placeholder="确认密码" onblur="yzconfirmPwd()">
							</div>
							<div hidden id="hidden_confirmPwd" class="valid" >
								<span>确认密码与密码不符合</span>
							</div>


						</div>
						<div class="container1">
							<div class="icona">
								<img src="${ctx}/res/img/index/yanzhenma.png" width="26px"
									height="26px" />
							</div>
							<div class="inputbox">
								<input name="kaptcha" type="text" id="kaptcha" maxlength="4" placeholder="验证码" class="input5" /> 
									<img src="${ctx}/kaptcha/getKaptchaImage" id="kaptchaImage" 
										style="margin-bottom: -3px; width: 80px; height: 40px;" /> 
									<a href="javascript:void(0)" onclick="changeCode()">换一张</a>
								<div hidden id="hide_setimgcode" class="valid">
									<span>图片验证码不能为空</span>
								</div>
							</div>
						</div>
						<div class="container2">
							<button class="button" id="reg">注册</button>
						</div>
						<div class="check">
							<input type="checkbox" id="agree" checked='checked'> <span><a
								style="color: #A9A9A9">同意</a><a
								href="${ctx}/user/registerdetail.html" target="_blank">《BAT注册条款》</a></span>
						</div>
						<div hidden id="hidden_condition" class="valid">
							<span>请先同意BAT用户协议</span>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--验证码的保存-->
	<input type="hidden" id="identifying_code">
	<@p.othrer_bottom/>
	<script src="${ctx}/res/js/signup.js" ></script>
</body>
</html>