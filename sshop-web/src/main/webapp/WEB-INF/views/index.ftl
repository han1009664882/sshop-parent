<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>上购汇玩-真够会玩！</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/index.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/top.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/indexset.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/indexset1280.css"
		media="screen and (min-width:1280px)">
	<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/bottom.css">
	<script type="text/javascript" src="${ctx}/res/js/scripts/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${ctx}/res/js/scripts/jquery.lazyload.min.js"></script>
	<script type="text/javascript" charset="utf-8">
      $(function() {
          $("img").lazyload({ 
	          placeholder : "${ctx}/res/img/loading.gif",
	              effect: "fadeIn"
	          });  
	      });
	</script>
</head>
<body>
	<#--顶部-->
	<div class="top1" id="top">
		<div class="logo topspan" onclick=""></div>
		<div class="top_right">
			<ul class="top_ul">
				<@p.top_common />
			</ul>
		</div>
	</div>
	<#--图片背景-->
	<div class="header">
		<img src="${ctx}/res/img/index/comment/1.jpg" alt="" class="img">
		<div class="center rel"></div>
	</div>
	
	<#--热门商品的标题-->
	<div class="center1" style="padding-top: 20px;">
		<br>
		<p style="font-size: 33px; height: 50px; line-height: 50px; margin-bottom: 10px;">热门产品</p>
		<p style="font-size: 18px;">您想要的热门产品都在BAT</p>
	</div>
	<#--热门商品列表-->
	<div class="kindnew h650">
		<!--上 四个产品-->
		<#list hotGoods as hotGood >
		<div class="bigbox">
			<div class="smallbox">
				<a href="${ctx}/goods/detail/${hotGood.id?c}" style="display: block;">
					<img class="lazy sbimg" data-original="${hotGood.images?if_exists}@300h_300w_0e" >
				</a>
			</div>
			<div class="boxdetail">
				<p class="bp">${hotGood.name?if_exists}</p>
				<p style="color: #ef2f23; font-weight: 900; font-size: 18px; margin-top: 8px;">￥${hotGood.price}</p>
			</div>
		</div>
		</#list>

	</div>
	<#--更多-->
	<div class="btnmore h120">
		<a href="${ctx}/goods/list?type=hot">
			<button class="btnlittle">更多热门产品</button>
		</a>
	</div>
	
	<#--商品分类-->
	<div class="kindnew h350">
		<div class="bigbox">
			<div class="smallbox classify" style="border: 1px solid #ebebeb; ">
				<ul style="margin-top: 16px;">
					<#list goodsCategories as category >
						<li>
							<a href="${ctx}/goods/list?type=category&categoryId=${category.id?c}">${category.name?if_exists}</a>
						</li> 
					</#list>
				</ul>
			</div>
			<div class="boxdetail"></div>
		</div>
		
		<#list categoryGoods as categoryGood >
			<div class="bigbox">
				<div class="smallbox">
					<a href="${ctx}/goods/detail/${categoryGood.id?c}" style="display: block;">
						<img class="lazy sbimg" data-original="${categoryGood.images?if_exists}" style="display: inline;">
					</a>
				</div>
				<div class="boxdetail">
					<p class="bp">${categoryGood.name?if_exists}</p>
					<p style="color: #ef2f23; font-weight: 900; font-size: 18px; margin-top: 8px;">￥${categoryGood.price}</p>
				</div>
			</div>
		</#list>
	</div>
	
	<#--最新商品的标题-->
	<div class="center1" style="padding-top: 20px;">
		<br>
		<p style="font-size: 33px; height: 50px; line-height: 50px; margin-bottom: 10px;">最新产品</p>
		<p style="font-size: 18px;">最新上架商品抢先看</p>
	</div>
	<#--最新商品列表-->
	<div class="kindnew h650">
		<!--上 四个产品-->
		<#list newGoods as newGood >
		<div class="bigbox">
			<div class="smallbox">
				<a href="${ctx}/goods/detail/${newGood.id?c}" style="display: block;">
					<img class="lazy sbimg" data-original="${newGood.images?if_exists}@300h_300w_0e" >
				</a>
			</div>
			<div class="boxdetail">
				<p class="bp">${newGood.name?if_exists}</p>
				<p style="color: #ef2f23; font-weight: 900; font-size: 18px; margin-top: 8px;">￥${newGood.price}</p>
			</div>
		</div>
		</#list>
	</div>
	<#--更多-->
	<div class="btnmore h120">
		<a href="${ctx}/goods/list?type=new">
			<button class="btnlittle">更多最新产品</button>
		</a>
	</div>
	
	
	<#--底部-->
	<@p.public_bottom />
</body>
</html>