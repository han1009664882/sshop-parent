
<!--订单状态-->
<#macro orderStatus status>
		<#if status="0" >
		待付款
		<#elseif status="1">
		已支付
			<#elseif status="2">
		已退款
			<#elseif status="3" >
		拒绝接单
			<#elseif status="4" >
		已接单
			<#elseif status="5" >
		生产完成
			<#elseif status="6">
		已发货
			<#elseif status="7">
		已签收	
			<#elseif status="8">
		已收货
			<#elseif status="9">
		订单关闭（已完成）
			<#elseif status="10">
		申请退款中
			<#elseif status="11">
		商家同意退款
			<#elseif status="12">
		争议中
			<#elseif status="13">
		平台处理争议订单完毕
		    <#elseif status="14">
		已成功退款
		    <#elseif status="15">
		生产者不接单,已退款
		    <#elseif status="16">
		已评价
		<#elseif status="100">
		订单取消
	</#if>
</#macro>


<#macro producerOrder status order>
	<#if status="0">
			
	<#elseif status="1">
		<button type="button" class="checkorder" onclick="updateStatus('确定接单？',${order!},4)">确定接单</button>
		<button type="button" class="checkorder" onclick="updateStatus('拒绝接单？',${order!},3)">拒绝接单</button>
	<#elseif status="3">
		已拒绝
	<#elseif status="4">
	    <button type="button" class="checkorder" onclick="updateStatus('确定已生产完成？',${order!},5)">生产完成</button>	
    <#elseif status="5">
        <button type="button" class="checkorder" onclick="showLogistic(${order!})">发货</button>
        <!--<button type="button" class="checkorder" onclick="updateStatus('确定已经发货？',${order!},6)">已发货</button>-->
    <#elseif status="8">
    	消费者已确认收货
        <!--<button type="button" class="checkorder" onclick="updateStatus('确定已经发货？',${order!},6)">已发货</button>-->
    <#elseif status="10">
        <button type="button" class="checkorder" onclick="apply_ok(${order!},11)">同意退款</button>
	   <button type="button" class="checkorder" onclick="updateStatus('拒绝退款？',${order!},12)">拒绝退款</button>
	<!--	<button type="button" class="checkorder" onclick="updateStatus('同意退款？',${order!},1)">同意退款</button>
		<button type="button" class="checkorder" onclick="updateStatus('拒绝退款？',${order!},12)">拒绝退款</button> -->
	<#elseif status="11">
	   退款成功
	   <#elseif status="12">
	   <button type="button" class="checkorder" onclick="apply_ok(${order!},11)">同意退款</button>
	<!--  <button type="button" class="checkorder" onclick="updateStatus('同意退款？',${order!},11)">同意退款</button> -->
	<#elseif status="14">
	    <!--<button type="button" class="checkorder" onclick="updateStatus('确认关闭订单？',${order!},11)"" >订单关闭 </button>-->
	    订单关闭
	<#elseif status="15">
	  生产者不接单，已退款。
		</#if>
</#macro> 




<#macro customerOrder status order>
<#if status="0" >
    <button type="button" class="checkorder" onclick="batPay('${order!}')">去支付</button> <#-- Drop_order 此函数在 status.js中 -->
    <span style="margin: auto;cursor: pointer;" id="drop_order_span${order!}" onclick="Drop_order('${order!}',100,null)" drop_order_orderno="${order!}">取消订单</span>
<#elseif status="1" > 
      <button type="button" class="checkorder" onclick="updateStatus('确认退款？',${order!},2)">退款</button>
<#elseif status="4" >
      <button type="button" class="checkorder" onclick="apply_refund(${order!},10)">申请退款</button>
<#elseif status="3" >
      交易关闭
<#elseif status="6" >
	  <button type="button" class="checkorder" onclick="apply_ok(${order!},8)">确认收货</button>
	  <button type="button" class="checkorder" onclick="apply_refund(${order!},10)">申请退款</button>
<#elseif status="8" >
<!--添加评价的跳转页面  9.23-->
		<button type="button" class="checkorder" onclick="">去评价</button>
<#elseif status="7" >
<button type="button" class="checkorder" onclick="apply_ok(${order!},8)">确认收货</button>
<button type="button" class="checkorder" onclick="apply_refund(${order!},10)">申请退款</button>
<#elseif status="9" >
     <!-- <button type="button" class="checkorder" onclick="">去评论</button> -->
                交易关闭
<#elseif status="5" >
      <button type="button" class="checkorder" onclick="apply_refund(${order!},10)">申请退款</button>  	  
<#elseif status="10" >
      申请退款中
      <button type="button" class="checkorder" onclick="updateOrderStatus('${order!}',101,null)" >撤销退款</button>
<#elseif status="11" >
    <!--<button type="button" class="checkorder" >商家退款中</button> --> 
    退款成功 
<#elseif status="12" >
   争议中
<button type="button" class="checkorder" onclick="updateOrderStatus('${order!}',101,null)">撤销退款</button>
<#elseif status="13" >
      平台处理争议订单完毕
<#elseif status="16" >
		已评价
</#if >

	<script>

	
	</script>
</#macro> 

<#macro TipsDiv>
   
    <div class="cover"></div>
	<div class="alert2" hidden="true">
		<div class="alert_head" style="background-color:#b3b3b3;">提示<span onclick="ria()" style="cursor:pointer;margin-left:405px;font-size:20px;">X</span></div>
		<div class="alert_content1">
			<div style="width:80%;margin-left:10%;margin-right:10%;height:100px;">
				<span style="text-align:center;line-height:100px;word-break:break-all" class="alert_cotent_span"><span id="tips">您确定要去支付吗</span></span>
			</div>
			<button style="width:80px;height:40px;font-size:16px;color:#fe5600;border:1px solid #fe5600;background-color:white;margin-left:120px;" onclick="ria()">取消</button>
			<button style="width:80px;height:40px;font-size:16px;color:white;border:1px solid white;background-color:#fe5600;margin-left:50px;" id="sure" >确定</button>
		</div>
	</div>

<script>

$(function(){
	$("#sure").click(sureClick);
})

function sureClick(){
	var type=$("#sure").attr("bat_order_change_type");
	if(type=="batPay"){
		 var orderNo=	$("#sure").attr("bat_order_orderNo");
		 pay(orderNo);
	}else if(type=="updateStatus"){
		var orderNo=	$("#sure").attr("bat_order_orderNo");
		var status=	$("#sure").attr("bat_order_status");
		updateOrderStatus(orderNo,status);
	}else{
		alert("error_sureClick:"+status);
	}
}

	<!--提示框-->
  function ria(){
	$(".alert").hide();
	$(".cover").hide();
	$(".alert1").hide();
	$(".alert2").hide();
	$(".alerta").hide();
}

function show(){
	$(".cover").show();
	$(".alert1").show();
	$(".alert2").show();
}


	

	function pay(orderNo){
		 var form = $('<form></form>'); 
		  form.attr('action', "/order/pay.html"); 
		  form.attr("method","post");
		  var input = $('<input type="text" name="orderNo" />');
		  input.attr("value",orderNo);
		  form.append(input);
		  form.submit();
	}

function batPay(orderNo){
	show();
	$("#tips").html("确认支付？");
	$("#sure").attr("bat_order_change_type","batPay");
	$("#sure").attr("bat_order_orderNo",orderNo);
}

function updateOrderStatus(orderNo,status,message){
			var data={
				orderNo:orderNo,
				status:status,
				msg:message||null
				}
				$.post("/order/updateOrderStatus.do",data,function(result){
						if(result.status==1){
							alert(result.message);
						}else{
							location.reload();
						}
				});
}
		

	function updateStatus(text,orderNo,status){
			show();
			$("#tips").html(text);
			$("#sure").attr("bat_order_change_type","updateStatus");
			$("#sure").attr("bat_order_orderNo",orderNo);
			$("#sure").attr("bat_order_status",status);
		}	

$(".cover").click(function(){
	$(".alert").hide();
	$(".cover").hide();
	$(".alert1").hide();
		$(".alert2").hide();
		$(".alerta").hide();
		
	});

$(".rinima").click(function(){
	$(".cover").show();
	$(".alert1").show();
	$(".alert2").show();
})
 </script> 

	
</#macro>


<#macro logistics>
<div class="cover"></div>
	<div class="alerta" hidden="true">
		<div class="alert_head" style="background-color:#b3b3b3;">提示<span onclick="ria()" style="cursor:pointer;margin-left:405px;font-size:20px;">X</span></div>
		<div class="alert_contenta">
			<div style="width:80%;margin-left:10%;margin-right:10%;height:100px;">
				<span style="text-align:center;line-height:100px;word-break:break-all" class="alert_cotent_span"><span id="tips">填写物流信息</span></span>
			</div>
			<div style="width:80%;margin-left:10%;margin-right:10%;height:90px;">
				<input type="text" style="width:100%;height:35px; margin-bottom:5px; float:left;" placeholder="请输入您的快递单号" id="num">
				<select style="width:100%;height:35px; margin-bottom:5px; float:left;"  id="code">
				<option value="0">请选择您的快递 公司</option>	
				<@company>
					<#list list as list>
					<option value="${list.code!}">${list.company!}</option>
					</#list>
					</@company>
				</select> 
				<input id="orderNo" hidden="true"> 
			</div>
			<button style="width:80px;height:40px;font-size:16px;color:#fe5600;border:1px solid #fe5600;background-color:white;margin-left:120px;" onclick="ria()">取消</button>
			<button style="width:80px;height:40px;font-size:16px;color:white;border:1px solid white;background-color:#fe5600;margin-left:50px;" onclick="submitLogistic()">确定</button>
		</div>
	</div>
<script>

function showLogistic(orderNo){
	$(".cover").show();
	$(".alerta").show();
	$("#orderNo").val(orderNo);
}

function submitLogistic(){
			var data={
				code:$("#code").val(),
				num:$("#num").val(),
				orderNo:$("#orderNo").val()
				}
				if(data.num==""){
					alert("请填写物流订单号");
					return;
				}
				if(data.code=="0"){
					alert("请选择物流公司");
					return;
				}
			$.post("/logistics/public.do",data,function(result){
						if(result.status==1){
							alert(result.message);
						}else{
							location.reload();
						}
				});
}


</script>
</#macro>


<#macro ordertime status orderNo >
				<@orderTime status="${status}" orderNo="${orderNo!}">
				<#if time??>
				${time.time?string("yyyy-MM-dd HH:mm")}
				</#if>
				</@orderTime>
</#macro>

<#macro statusStep status  >
		<#if status="0" >
			<img src="/res/img/account/or1.gif">
		<#elseif status="1">
			<img src="/res/img/account/or2.gif">
		<#elseif status="2">
			<img src="/res/img/account/or2.gif">
		<#elseif status="3" >
			<img src="/res/img/account/or2.gif">
		<#elseif status="4" >
			<img src="/res/img/account/or3.gif">
		<#elseif status="5" >
			<img src="/res/img/account/or3.gif">
		<#elseif status="6">
			<img src="/res/img/account/or4.gif">
		<#elseif status="7">
			<img src="/res/img/account/or4.gif">
		<#elseif status="8">
			<img src="/res/img/account/or5.gif">
		<#elseif status="9">
			<img src="/res/img/account/or6.gif">
		<#elseif status="13">
			<img src="/res/img/account/or07.png">
		<#elseif status="15">
			<img src="/res/img/account/or08.png">
		<#else>                      
			<img src="/res/img/account/or6.gif">   
	</#if>
</#macro>

<#macro statusStepProduct status  >
		<#if status="0" >
		<img src="/res/img/account/op1.png">
		<#elseif status="1">
		<img src="/res/img/account/op1.png">
			<#elseif status="2">
		<img src="/res/img/account/op1.png">
			<#elseif status="3" >
		<img src="/res/img/account/op1.png">
		<#elseif status="100" >
		<img src="/res/img/account/op1.png">
			<#elseif status="4" >
		<img src="/res/img/account/op2.png">
			<#elseif status="5" >
		<img src="/res/img/account/op3.png">
			<#elseif status="6">
		<img src="/res/img/account/op4.png">
			<#elseif status="8">
		<img src="/res/img/account/op5.png">  
	</#if>
</#macro>

<#macro handlePayOrderTime status >
   <#if status="0" >
    您还有<span style="margin-right:0;color:#fdaa7e;">30分00秒</span>来完成付款，超时系统将自动取消订单
   </#if>
</#macro>

<!-- 剩下时间提示 -->
<#macro handleOrderTime status type >
   <#if type="1" >
       <#if status="0" >
		您还有<span style="margin-right:0;color:#fdaa7e;">30分00秒</span>来完成付款，超时系统将自动取消订单
		<#elseif status="6" >
		您还有<span style="margin-right:0;color:#fdaa7e;">15天</span>确认收货，超时系统将自动收货
		<#elseif status="7" >
		您还有<span style="margin-right:0;color:#fdaa7e;">7天</span>确认收货，超时系统将自动收货
     </#if>

  <#elseif type="2">
	   <#if status="1" >
		<span style="font-size:14px;float:right;margin-right:16px;color:#235fa7;display:inline-block;">请在2天内处理，否则系统将自动视为自动取消</span>
		<#elseif status="10" >
		<span style="font-size:14px;float:right;margin-right:16px;color:#235fa7;display:inline-block;">请在15天内处理，否则系统将自动视为同意退款</span> 
	</#if> 
  </#if> 

</#macro>

<!-- 订单详情页的按钮 -->
<#macro orderOperate status >
    <#if status="0" >
       <button class="last_two_btn_pay">去付款</button>
	   <button class="last_two_btn_qx">取消订单</button>
	<#elseif status="10" >
	  <button class="checkorder">撤销退款</button> 
	<#elseif status="12" >
	  <button class="checkorder">撤销退款</button> 
	</#if>  
</#macro>

<#macro orderOperateRefuseMoney status >
    <#if status="1" >
       <button class="orc5btn">退款</button>
	<#elseif status="4" >
	  <button class="orc5btn">退款</button>
	<#elseif status="5" >
	  <button class="orc5btn">退款</button>
	<#elseif status="6" >
	  <button class="orc5btn">退款</button>
	</#if>  
</#macro>

<#macro orderOperateAgreeDeliver status >
    <#if status="6" >
    <div style='background-color:#fafafa;margin:0 30px;padding-left:102px;padding-top:30px;border-top:1px solid #dfdfdf'>
		 
		   
			<div class='f12p'><img src='../../../res/img/account/clock.png' style='padding-right:10px'><@o.handleOrderTime status="6" type="1" /> </div>
			<div style='margin-top:30px;margin-bottom:36px'  class='f12p'>
				<button style='background-color:#f58b0f;color:white;border:0;border-radius:6px;width:78px;height:30px;font-size:13px;margin:auto;padding:5px 10px;margin-right:10px'>确认收货</button>
				请确认收到货，如果长期未收到货，请联系卖家或申请退款
			</div>				
	</div>
	</#if>  
</#macro>
