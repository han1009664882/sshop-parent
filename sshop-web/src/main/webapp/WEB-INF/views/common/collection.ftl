<#macro TipsDiv>
   
    <div class="cover"></div>
	<div class="alert2" hidden="true">
		<div class="alert_head" style="background-color:#b3b3b3;">提示<span onclick="ria()" style="cursor:pointer;margin-left:405px;font-size:20px;">X</span></div>
		<div class="alert_content1">
			<div style="width:80%;margin-left:10%;margin-right:10%;height:100px;">
				<span style="text-align:center;line-height:100px;word-break:break-all" class="alert_cotent_span">您想要添加心动吗</span>
			</div>
			<button style="width:80px;height:40px;font-size:16px;color:#fe5600;border:1px solid #fe5600;background-color:white;margin-left:120px;" onclick="ria()">取消</button>
			<button style="width:80px;height:40px;font-size:16px;color:white;border:1px solid white;background-color:#fe5600;margin-left:50px;" onclick="pay(${detailId!})" >确定</button>
		</div>
	</div>


<script>
	<!--提示框-->
    function ria(){
	$(".alert").hide();
	$(".cover").hide();
	$(".alert1").hide();
	$(".alert2").hide();
}
function TiShiDiv(){
	$(".cover").show();
	$(".alert1").show();
	$(".alert2").show();
}

$(".cover").click(function(){
	$(".alert").hide();
	$(".cover").hide();
	$(".alert1").hide();
    $(".alert2").hide();
	});

$(".rinima").click(function(){
	$(".cover").show();
	$(".alert1").show();
	$(".alert2").show();
})

 </script> 

	
</#macro>

