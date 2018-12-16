<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购汇玩—-登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" href="favicon.ico"/>
    <link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/home.css">
    <link rel="stylesheet" href="/res/css/public_bottom.css" />
	<link rel="stylesheet" type="text/css" href="/res/css/old/reset.css"/>
    <script type="text/javascript" src="${ctx}/res/js/old/jquery.min.js"></script>
    <script>
    	var ctx = "${ctx}/";
    </script>
    <#import "common/public.ftl" as p >
</head>
<body>
<!-- 登录-->
<div style="position:relative;">
    <div style="width:100%;height:75px;">
        <a onclick="location.href ='/index.html'"><img src="${ctx}/res/img/index/logo.png" class="backgroundimg"></a>
    </div>
    <div style="width:100%; margin:0px;">
        <img src="${ctx}/res/img/login.png" class="logicon"/>
        <form class="form">
        	<input type="hidden" id="backurl" value="${backurl?if_exists}">
            <div class="logcontent">
                <div class="box">
                    <div style="margin-bottom:20px;">
                        <span class="sign">登录</span><span class="reg">
                        <a href="${ctx}/user/signup.html" style="font-size:18px;">注册</a>
						</span>
                    </div>
                    <div class="container1">
                        <div class="inputbox" style="position:relative;">
                        	<p class="icona" style="background:url(${ctx}/res/img/index/account.png) no-repeat;width:26px;height:26px;float:left;position:absolute;top:8px;left:10px">
                       		</p>
                            <input type="text" id="mobile" class="input1" placeholder="手机号">
                        </div>
                        <div class="valid">
                            <span id="mobileError" ></span>
                        </div>
                    </div>
                    <div class="container2 h30"> 
                        <div class="inputbox" style="position:relative;">
                        	<p class="icona" style="background:url(${ctx}/res/img/index/pass.png) no-repeat;width:26px;height:26px;float:left;position:absolute;top:8px;left:10px">
                        	</p>
                            <input type="password" id="password" class="input1" placeholder="密码">
                        </div>
                        <div class="valid">
                            <span id="passwordError" ></span>
                        </div>
                    </div>
                    <span>
                       <a href="/user/forgetpass.html" style="font-size:12px; display:block;margin-top:10px;">忘记密码？</a>
                    </span>
                    <div style="width:320px;margin-top:16px;margin-bottom:10px;height:38px;position:relative;">
                    	<p style="background:url(${ctx}/res/img/index/yanzhenma.png) no-repeat;width:26px;height:26px;float:left;position:absolute;top:8px;left:10px"></p>      
                        <input placeholder="验证码" style="float:left;height: 38px;line-height:38px;width: 130px; *width:90px; _width:90px;margin-right:12px;padding-left:40px" type="text" id="kaptcha"  maxlength="4" class=""/>
                        <img src="${ctx}/kaptcha/getKaptchaImage" id="kaptchaImage" style="float:left;height:38px;width:90px;margin-right:10px"/>
                        <a style="display:inline-block;text-decoration:underline;font-size:12px;margin-top:22px;float:left" href="#" onclick="changeCode()">换一张</a>
                        <div class="valid">
                            <span id="kaptchaError" ></span>
                        </div>
                    </div>
                    <div class="container3 h20">
                        <button class="button" id="login">登录</button>
                        	
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<@p.othrer_bottom/>
<script src="${ctx}/res/js/common.js" ></script>
<script src="${ctx}/res/js/login.js" ></script>
</body>
</html>