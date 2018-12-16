<#import "common/public.ftl" as p >
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>购汇玩——收银台</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/alert.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/trade.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/top.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/consumer/pay.css" >
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/public_bottom.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css"/>
<script src="/res/js/jquery-1.12.4.js"></script>
<style type="text/css">
body{
	background-color:white;
}
.get_money{
	background:url(${ctx}/res/img/get_money.png) no-repeat left center;
	padding-left:50px ;
	
}
.payabtn_sure{
	width: 120px;
    height: 40px;
    color: white;
    background-color: #fe5600;
    font-size: 20px;
    border: 1px solid #fe5600;
    margin-top: 5px;
    margin-left:80px;
}
</style>
</head>
<body>
	<#-- 最顶层的包括LOGO还有用户-->
		<@p.top/>
		<!--确认订单-->
	<div class="content">
		<div class="column">
			<p class="get_money" style="color: #9e9e9e;">收银台</p>
		</div>
		<div class="column1" style="overflow:hidden;">
			<div class="imgbox"></div>
			<p class="column1_ok">提交已订单成功，跳转付款页面。。。</p>
			<p class="column1_mon" style="float:right;">应付金额: <span class="spanmoney" style="font-size:30px;font-weight:bold;">￥${baseOrder.price!}</span></p>	
		</div>
		<div class="columna" style="display:none">
			<button class="payabtn"  onclick="submit()"> 结算</button>
		</div>
	</div>

	<form action="${gateway_new}"  method="post" id="passPay">
		<#--  服务器异步通知页面路径 -->
		<input type="hidden" name='notify_url' value='${notify_url}'/>
		<#--  合作身份者PID，签约账号，由16位纯数字组成的字符串 -->
		<input type="hidden" name='partner' value='${partner!}'/>
		<#--  页面跳转同步通知页面路径 -->
		<input type="hidden" name='return_url' value='${return_url!}'/>
		<#--  签名值 -->
		<input type="hidden" name='sign' value='${sign!}'/>
		<#--  商户订单号 -->
		<input type="hidden" name='out_order_no' value='${baseOrder.orderNo!}'/>
		<#--  订单名称 -->
		<input type="hidden" name='subject' value='${baseOrder.goodsName!}'/>
		<#--  付款金额 -->
		<input type="hidden" name='total_fee' value='${baseOrder.price!}' />
		<#--  订单描述 -->
		<input type="hidden" name='body' value='${baseOrder.goodsDesc!}'/>
		<#--  商户号（6位数字） -->
		<input type="hidden" name='user_seller' value='${user_seller!}'/>
	</form>
	<@p.othrer_bottom/>
<script type="text/javascript" src="${ctx}/res/js/old/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
	/*function submit () {
		$("#passPay").submit();
	}*/
	
	$(document).ready(function(){
		$("#passPay").submit();
	});
</script>
</body>
</html>