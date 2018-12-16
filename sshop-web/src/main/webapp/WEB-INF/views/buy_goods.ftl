<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>购汇玩——确认账单</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/res/css/old/reset.css">
<link rel="stylesheet" type="text/css" href="/res/css/old/alert.css">
<link rel="stylesheet" type="text/css" href="/res/css/old/trade.css">
<link rel="stylesheet" type="text/css" href="/res/css/top.css">
<link rel="stylesheet" type="text/css" href="/res/css/consumer/conorderd.css">
<link rel="stylesheet" type="text/css" href="/res/css/old/upload_forth.css">
<link rel="stylesheet" type="text/css" href="/res/css/consumer/oradd.css">
<link rel="stylesheet" href="/res/css/public_bottom.css" />
<link rel="stylesheet" type="text/css" href="/res/css/old/reset.css" />
<script type="text/javascript" src="/res/js/old/jsAddress.js"></script>
<script type="text/javascript" src="/res/js/old/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/res/js/old/timeutil.js"></script>
<script type="text/javascript" src="/res/js/producer/address.js"></script>
<script type="text/javascript" src="/res/js/old/ajaxform.js"></script>
<script src="/res/js/friend/chatCheck.js"></script>
<style type="text/css">
body {
	background-color: white;
}
</style>
<#import "common/public.ftl" as p >
<script>
	var ctx = "${ctx}/"
</script>
</head>
<body>
	<@p.top />
	<#--<form action="${ctx}/order/create" method="post" id="createOrder">-->
	<form id="createOrder">
		<input name="addressId" id="addsId" type="hidden" > 
		<input name="goodsDetailId" value="${dobuy.detailId?c}" type="hidden" > 
		<input name="count" id="count" value="1" type="hidden" > 
		<input name="message" id="messageABC" type="hidden" >
		<input name="token" value="${dobuy.token!}" type="hidden" > 
		<input name="attr" value="${dobuy.dna!}" type="hidden" >
		<input name="ids" value="${dobuy.ids!}" type="hidden" >
		<input value="${dobuy.goods.id?c}" type="hidden" id="detailId" >
		<input value="${dobuy.goods.price!}" type="hidden" id="price" >
	</form>

	<div class="coadd">
		<div class="a1" style="float: left;">
			<div class="co1">
				<p>BAT确认订单</p>
			</div>
			<div class="a1a">
				<p>选择收货地址</p>
			</div>
			<#--收货地址展示-->
			<div id="pay_address">
				<#if addresses?? >
					<#list addresses as m >
						<div class="midleft midaddress" name="1" onclick="f2(event,this,'${m.id}');">
							<div class="leftmid1">
								<span>收货人: <sapn id="collect_name">${m.contacterName!}</sapn></span><br>
								<span>联系电话: ${m.phoneNumber!}</span> <br> 
								<span>地址: <span id="collect_add"><#if m.province.provinceName != m.city.cityName >${m.province.provinceName!}</#if>${m.city.cityName!}${m.area.areaName!}${m.detailedAddress!}</span></span>
								<br>
							</div>
							<#if m.isDefault?? && m.isDefault==1>
								<div class="adr_select" style="display: block;"></div>
								<input id="default" value="${m.id}" type="hidden">
							<#else>
								<div class="adr_select"></div>
							</#if>
						</div>
					</#list> 
				</#if>
				
				<div class="midright">
					<span id="addimg">+</span>
				</div>
				<div></div>
			</div>
		</div>
		<div class="cover"></div>
		<#--添加联系方式-->
		<div class="alert">
			<form action="${ctx}/address/add" method="post" id="address">
				<div class="alert_head">添加联系方式</div>
				<div class="alert_content">
					<span class="alert_cotent_span">收货人姓名:&nbsp;&nbsp;</span>
					<input placeholder="请输入姓名" id="name" name="contacterName" onblur="nameBlur()">
					<span id="name_prompt" style="font-size: 12px; color: #0000FF"></span> <br> 
					<span class="alert_cotent_span">联&nbsp;系&nbsp;方&nbsp;式:&nbsp;&nbsp;</span>
					<input type="text" style="" placeholder="请输入联系方式" id="phone" name="phoneNumber" onblur="telBlur()">
					<span id="tel_prompt" style="font-size: 12px; color: #0000FF"></span><br>
					<span class="alert_cotent_span">邮&nbsp;政&nbsp;编&nbsp;码:&nbsp;&nbsp;</span>
					<input type="text" style="" placeholder="请输入邮编" id="postcode" name="postalCode" onblur="postBlur()">
					<span id="post_prompt" style="font-size: 12px; color: #0000FF"></span><br>
					<div class="alert_address" id="alert_address" onblur="codeBlur()">
						<span class="alert_cotent_span">收货人地址：</span> 
						<span class="alert_cotent_span" id="cmbProvince_prompt">省：</span> 
						<select id="cmbProvince" name="provinceId">
						</select> 
						<span class="alert_cotent_span" id="cmbCity_prompt">市：</span>
						<select id="cmbCity" name="cityId" >
						</select> 
						<span class="alert_cotent_span">区：</span>
						<select id="cmbArea" name="areaId">
						</select> 
						<span id="Bars" style="font-size: 12px; color: #0000FF"></span><br/><br/>
					</div>
					<div class=more_address>
						<div class="more_address_word alert_cotent_span">详&nbsp;细&nbsp;地&nbsp;址：</div>
						<textarea placeholder="请输入详细地址" id="moreaddress" name="detailedAddress" onblur="addressBlur()"></textarea>
						<span id="address_prompt" style="font-size: 12px; color: #0000FF"></span>
					</div>
					<div class="button_div" id="button_div">
						<span class="alert_button" id="alert_but">确定</span>
					</div>
				</div>
			</form>
		</div>
		<div class="men">
			<p></p>
		</div>
		<#--商品信息-->
		<div class="goodinfo1" style="float: left;">
			<div class="goodtitlea">
				<span class="goodtitle1" style="padding-right: 284px;">商品信息</span> 
				<span class="goodtitle2" style="padding-right: 112px;">单价</span> 
				<span class="goodtitle2" style="padding-right: 112px;">数量</span> 
				<span class="goodtitle2" style="padding-left: 90px; padding-right: 102px;">应付款</span>
			</div>
			<table cellspacing="0" cellpadding="0" class="orbox" style="height: 0px;">
				<#--生产者信息-->
				<tr class="orbox1">
					<td colspan="3">
						<span class="pl10">生产者: ${dobuy.goods.producer.lastname!}</span>
						<span><img src="/res/img/account/message2.gif" onclick="checkAndAddFriend(${dobuy.goods.producer.id!})"></span>
					</td>
				</tr>
				<#--购买商品信息-->
				<tr class="orcontent">
					<td class="orc1">
						<table class="orsbox">
							<tr>
								<td class="ortd1"><img src="${dobuy.goods.images!}"></td>
								<td class="ortd2">
									<p>
										<span>${dobuy.goods.name!}</span>
									</p>
								</td>
								<td class="ortd3" align="center">￥${dobuy.goods.price!}</td>
								<td class="ortd3" align="center">
									<button class="addbtn" id="jian" onclick="jianyi()">-</button>
									<input type="text" class="addnum" id="buyCount" readOnly="true" value="1" />
								<button class="addbtn" id="jia" onclick="jiayi()">+</button></td>
							</tr>
						</table>
					</td>
					<td class="orc2" align="center">￥<span id="TotailPriceShow">${dobuy.goods.price!}</span></td>
				</tr>
				<#--用料用户数据-->
				<tr class="w100h50">
					<td colspan="3">
						<table cellspacing="0" cellpadding="0" class="w100h100">
							<tr>
								<td>用料细节</td>
								<td>用户数据</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr class="orsbox">
					<td colspan="3">
						<table cellspacing="0" cellpadding="0" class="w1">
							<tr>
								<td class="td1">
									<table cellspacing="0" cellpadding="0" class="orsbox">
										<tr>
											<#list dobuy.partsImages as image >
											<td class="tdimg" style="height: 155px;">
												<img src="${image.path!}@70h_70w_0e" />
												<p>${image.description!}</p>
											</td> 
											</#list>
										</tr>
									</table>
								</td>
								<td align="center" class="tdsize">${dobuy.dna!}</td>
							</tr>
						</table>
					</td>
				</tr>
				<#--卖家留言-->
				<tr class="ordtime">
					<td colspan="3">
						<span class="ddsj">给卖家留言<input id="msg" class="ddsjinput"></span>
					</td>
				</tr>
				<#--订单超时提示-->
				<tr class="ordtime">
					<td colspan="3">
						<p class="ddcs">
							<span class="ddcsspan">温馨提示:</span>请在30分钟之内完成付款,超时订单将自动取消
						</p>
					</td>
				</tr>
				<#--实际金额与运费-->
				<tr class="ordtime">
					<td colspan="3"><span class="ormoney1" id="TotailPriceShow2">${dobuy.goods.price!}</span>
						<span class="ormoney2">实际金额：￥</span> <span class="ormoney1">0.00</span>
						<span class="ormoney2">运费:</span></td>
				</tr>
			</table>
		</div>
		<!--提交按钮-->
		<div class="subclass" style="float: left;">
			<button class="acceptbtn" id="createOrderBtn" onclick="transactionPost()">确认订单</button>
		</div>
	</div>

	<#--提示框确认订单-->
	<div class="alert1">
		<div class="alert_head" style="background-color: #fe5600;">
			提示框<span onclick="hideaddress()"
				style="cursor: pointer; margin-left: 405px; font-size: 20px;">X</span>
		</div>
		<div class="alert_content1">
			<div
				style="width: 80%; margin-left: 10%; margin-right: 10%; height: 100px;">
				<span style="text-align: center; line-height: 100px; word-break: break-all"
					class="alert_cotent_span">请选择地址</span>
			</div>
		</div>
	</div>
	<@p.othrer_bottom/>
	
	<script src="${ctx}/res/js/buy.good.js"></script>
</body>
</html>