<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上购汇玩-在线设计</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit" />
	<meta http-equiv="Pragma" content="no-cache" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/index.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/top.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/design/designtop.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/design/designtop1280.css" media="screen and (min-width:1280px)">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/design/design.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/bottom.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/design/design1280.css" media="screen and (min-width:1280px)">
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/alertshare.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/public_bottom.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/alert.css">
   	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/indexset.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/indexset1280.css" media="screen and (min-width:1280px)">
	
    <link href="${ctx}/res/css/jquery.jqzoom.css" rel="stylesheet" type="text/css" />
	<style>
		.lbox:nth-child(4) .partintro,.lbox:nth-child(9) .partintro{left:-33px;	
		}
		.lbox:nth-child(5) .partintro,.lbox:nth-child(10) .partintro{
			left: -117px;
		}
		.lbox:nth-child(6) .partintro,.lbox:nth-child(7) .partintro,.lbox:nth-child(8) .partintro,.lbox:nth-child(9) .partintro,.lbox:nth-child(10) .partintro{
			top: -81px;
		}
		
	</style>
	<script type="text/javascript" src="${ctx}/res/js/scripts/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${ctx}/res/js/scripts/jquery.lazyload.js?v=1.9.1"></script>
	<script src="${ctx}/res/js/friend/chatCheck.js"></script>
	<link rel="stylesheet"  href="${ctx}/res/css/design/lightGallery.css"/>
	<script src="${ctx}/res/js/scripts/lightGallery.js"></script>
	<script src="${ctx}/res/js/jquery.jqzoom-core.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/res/js/goods.detail.js" ></script>
	<script>
		var ctx = "${ctx}/";
	</script>
</head>
<body>
	<@p.goodsTop />
	<!--顶格-->
	<div style="width:100%;height:80px;"></div>
	<!--在线设计-->
	<!-- 把container的高度有原来的2340调整到2500px因后面的插件高度样式影响无法自适应高度 -->
	<div class="container" style="height:2500px;">
		<div class="s-container">
			<div class="box" >
				<p class="p1">购汇玩 · 在线设计</p>
			</div>		
		</div>
		<div class="l-container">
			<div class="left_show"></div>
			 <div class="left">
			 	<a href="${goods.images!}" class="jqzoom" id="jqzoom" title="${goods.name!}" >
		            <img src="${goods.images!}" title="${goods.name!}" style="border: 4px solid #666;width:300px;height:300px;">
		        </a>
			</div>
			
			<div class="right2">
				<div class="right_tp" style="position:relative;padding-top:10px;">
					<p id="goodsName">${goods.name!}</p>
					<p class="p2" style="position:absolute;bottom:8px;font-size:16px; ">价格:<span >￥<span id="goodsPrice">${goods.price!}</span></span></p>
				</div>
				<@g.partList goods.goodsParts />
				
			 	<div class="sizecontent" style="margin-bottom:10px;">
					<div class="fast">
						<p class="p3" id="pa"onclick="fastpick()">快捷尺码</p> 
					</div>
					<div class="dna">
						<p class="p4" id="pb" onclick="DNA()">DNA尺码</p>
					</div>
				</div>
				<div class="fast1" style="overflow:hidden;">
					<#list goods.attributes as list>
					   <input id="fastpick" value="${list.typeUnit!}" hidden="true">
				       <div class="bigf"  onclick="defaultSize(this)"  key="${list.code}"  value="${list.typeName}"><p>${list.typeName!}</p></div>
					</#list>
				</div>
				
				<!--dna 尺码-->
				<form action="${ctx}/order/buyGoods.html" method="post" id="post">
		 			<input name="detailId"  id="detailGoods"  value="${goods.id?c}"  hidden="true" style="display:none;">
		 			<input name="ids"  id="ids" hidden="true" >
		 			<input name="size"  id="size" hidden="true">		
					<div class="dna1">
						<table border="0">
							<#list goods.defaultAttributes as list>
								<input id="DNA" value="${list.typeUnit!}" hidden="true">
								<#if list_index  % 2==0 >
								  <tr height="30px;">
								</#if>
								<td class="dnalsp">${list.typeName!}:</td>
								<td><input type="text" class="dna1tbox1"  name="${list.typeName!}"  placeholder="单位:CM"></td>
							</#list>
						</table>
					</div>
				</form>
			 
				<div class="contact" onclick="checkAndAddFriend(${goods.producer.id!})" style="position:absolute;bottom:68px;">
					<img data-original="${goods.producer.header}"  class="lazy img1"/></a>
					<p class="cp" >联系生产者
				</div>
				<div class="buycontent" style="position:absolute;left:1px;bottom:10px;">
				    <input id="buy" value="${goods.goodsCode!}" hidden="true" >
					<#--<button class="savebtn" onclick="TiShiDiv()" >添加心动</button>-->
					<button class="buybtn"  onclick="buy(${goods.producer.id!})">立即购买</button>
				</div>
			</div>
		</div>
		
		<!-- 添加心动提示窗 -->
		<#--<@collection.TipsDiv />  -->
		    
		<!--个人描述-->
		<div class="sdescribe">
			<div class="selfcontent">
				<div class="s-selfcontent">
				<a href="${ctx}/user/Tahome.html?goodUserId=${goods.producer.id!}">
					<img data-original="${goods.producer.header}" class="lazy img2"/></a>
					<p>生产者 ·${goods.producer.lastname!}</p>
				</div>
			</div>
			<div class="selfcontent2">
				<div class="selfcona">
					<p>个人描述</p>
				</div>
				<div class="selfconb">
					<p>${goods.description!}</p>
				</div>
			</div>	
		</div>
		
		<!--商品细节-->
		<div class="gooddetail">
			<div class="goodtitle">
				<div class="goodcontent1">
					<p class="gooddetailp" onclick="switch1()">商品详情</p>
					<div class="goodline"><img src="${ctx}/res/img/line.gif"></div>
					<p class="custp" onclick="switch2()">用户评价</p>
				</div>
			</div>
			
			<div class="goodcontent2">
				<div class="contentdetail1">
					<div class="detailgood">
						<p>产品详情</p>
					</div>
					<div class="detailword">
						<p>${goods.origin!}</p>
					</div>
				</div>
				<!-- 把生产心得高度调整为100% -->
				<div class="contentdetail2">
					<div class="producegood">
						<p>生产心得</p>
					</div>
					<div class="produceword">
						<p>${goods.reviews!}</p>
					</div>
				</div>
				<div class="gdetail" style="height:70px;">
				<div class="gdetaila"><p>商品细节</p></div>
			</div>
		</div>
			<!-- 商品 -->
			<div class="contentpreview">
				<div class="contentpreviewa">
				<ul id="auto-loop" class="gallery" style="overflow:hidden;">
					<#list goods.goodsImages as list>
						<#if list_index==0 || list_index==1 >
						<li class="contentpreview1" data-src="${imagePrefix + list.path!}" data-title="${list.description!}"> 
		        			<a href="#">
		            			<div align="center" class="designtop"><img class="imga"  src="${imagePrefix + list.path!}" /></div>
		            		</a>
	            		</li> 
	            		<#else>
	            		<li class="contentpreview2" data-src="${imagePrefix + list.path!}" data-title="${list.description!}"> 
		        			<a href="#">
		            			<div align="center"  class="designdown"><img class="imga"  src="${imagePrefix + list.path!}" /></div>
		            		</a> 
	            		</li>
						</#if>
        			</#list>
    			</ul>
			</div>
			</div>
		</div>
	</div>
	
	
	<@p.othrer_bottom/>

	<#--<script type="text/javascript">	
				//选择快捷尺码
				
				$(function(){
					start();
					if($("#img${appDetailGoods.getDetailImages()[0].id}").length>0){
						$("#img${appDetailGoods.getDetailImages()[0].id}").addClass("changebg");
					}else{
						$(".first").addClass("changebg");
					}
				});
				function start(){
						var val=$("#fastpick").val();
						//alert("val=="+val);
						var dna=$("#DNA").val();
						//alert("dna=="+dna);
						if(val == ""){//快捷尺码有数据
							$(".dna").attr("hidden",true);
						}else{
							$(".fast").attr("hidden",true);
						}
						
						if(dna!="cm"){
							$(".dna").attr("hidden",true);
						}else{
							DNA();
						}
						
				}
				
				var flag=false;
				
				function defaultSize(id){
					flag=true;
					$(".fast1").find(".bigf").css("border-color","#ccc");
					var key=$(id).attr("key");
					var value=$(id).attr("value");
					$("#size").val(value);
					$(id).css("border-color","#ff5400");
				}
				
				
	</script>-->
	
</body>
</html>