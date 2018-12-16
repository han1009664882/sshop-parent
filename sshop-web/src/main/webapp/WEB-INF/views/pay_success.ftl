<#import "common/public.ftl" as p >
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>购汇玩——订单支付成功</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/alert.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/trade.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/top.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/consumer/pay.css" >
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/consumer/paysuccess.css" >
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="bookmark" href="favicon.ico"/>
<link rel="stylesheet" href="${ctx}/res/css/public_bottom.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css"/>
<style type="text/css">
body{
	background-color:#fff;
}
</style>
</head>
<body>
	<@p.top/>
	<div style="width:100%;height:40px;"></div>
	<!--title-->
	<div class="title1">
	 	<p><#if resultCode == 1 >付款成功<#else>付款失败</#if></p>
	 </div>
	 <div class="contenta">
	 	<div class="column1">
			<div class="imgbox" style="margin-left:140px;"></div>
			<#if resultCode == 1 >
				<p>恭喜您，已经成功付款<span class="moneys">${money!}</span>元，请耐心等待卖家生产发货</p>
			<#else>
				<p>对不起，付款失败，请联系客服，电话： 021-89898989</p>
			</#if>	
		</div>
		<div class="btncolumn">
		<#if resultCode == 1 >
	    	<a href="${ctx}/customerorder/detail?orderNo=${orderNo?if_exists}" class="btna1">查看订单</a>
		</#if>
    	<a href="${ctx}/index" class="btna2">返回首页</a>
		</div>
	 </div>
	<@p.othrer_bottom/>
</body>
</html>