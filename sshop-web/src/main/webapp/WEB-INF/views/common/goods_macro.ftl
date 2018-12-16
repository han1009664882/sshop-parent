<#macro goodsPage page  >
	<#list page.results as list>	
		<div class="good goods-image-hover">
				<div class="goods-image">
				<!--添加一个hover事件的class=“goods-image-hover”-->
					<a href="${ctx}/goods/detail/${list.id?c}">
						<img class="lazy goods" data-original="${list.images!}" >
					</a>
				</div>
				<div class="goods-intro">
					<div class="h50" style="height:40px;">
						<p class="h50p" style="height:40px;overflow:hidden;">${list.name!}</p>
					</div>
					<div class="h50">
						<p class="money" >￥${list.price!}</p>
						<img class="lazy icon" data-original="${list.producer.header!}" >
					</div>
				</div>
			</div>
	</#list>
</#macro>
		
<#macro partList part>
<div class="right_choice">
	<div class="select">
		<p onclick="downshow()" id="partName">${part[0].name?if_exists}
			<button class="down" show="1"></button>
		</p>
		<ul class="drop"style="display:none;">
		<#list part as list>
			<li class="l1 <#if list_index==0>select1</#if>" onclick="selectPart('${list.id?c}','${list.name}')">${list.name}</li>
		</#list>
		</ul>
	</div>
</div>
<#--遍历弹出部件的图片 -->
<#list part as list>
	<#if list_index==0>
		<div class="block firstblock" id="partImageArr${list.id?c}">
			<#list list.images as image>
				<div class="lbox">
					<div class="sbox <#if image_index==0>first</#if>" align="center" id="img${image.id?c}" value="${image.id?c}" onclick="selectImage('${list.id?c}','${image.id?c}')">
						<img class="s-img" src="${imagePrefix + image.path!}@65h_65w_0e" />
						<#if image.description?exists && image.description != '' >
							<div class="partintro">
								<p>${image.description!}</p>
							</div>
					    </#if>
					</div>
				</div>
			</#list>
		</div>
	<#else>
		<div class="block" hidden="true" style="display:none;" id="partImageArr${list.id?c}" >
			<#list list.images as image>
				<div class="lbox a1">
					<div class="sbox <#if image_index==0>changebg</#if>" align="center" id="img${image.id?c}" value="${image.id?c}">
							<img class="s-img"  src="${imagePrefix + image.path!}<#if image_index==0>@60h_60w_0e<#else>@65h_65w_0e</#if>" onclick="selectImage('${list.id?c}','${image.id?c}')"/>
							<#if image.description?exists && image.description != '' >
							<div class="partintro">
								<p>${image.description!}</p>
							</div>
						  </#if>
					</div>
				</div>
			</#list>
		</div>
	</#if>
</#list>

<script>
	//下拉选择部件
	function selectPart(id, name) {
		$("#partName").html(name);
		// 展示属性图片
		$(".block").hide();
		$("#partImageArr" + id).show();
		// 关闭下拉
		downshow();
	}
	
	var code;
	//选择部件图片
	function selectImage(partId, id) {
		$("#partImageArr"+partId+" .changebg").removeClass("changebg");
		$("#img"+id).addClass("changebg");
		var ids=[];
		<#list part as list>
			ids.push($("#partImageArr"+${list.id}+" .changebg").attr("value"));
		</#list>
		var data = {ids:ids.join(","), goodsCode:'${goods.goodsCode!}'};
		$.post("${ctx}/goods/partGoods", data, function(res){
			$("#goodsName").html(res.name);
			$("#goodsPrice").html(res.price);
		    $("#detailGoods").val(res.id);
		    $("#jqzoom").attr('href', res.images);
		    $("#jqzoom img").attr('src', res.images);
		});
	}
	
	//立即购买 判断是不是自己的产品 以及尺码有没有选中
	function buy(id) {
	    var length = $('.fast1').children().length;
	    if((length>0 && flag==true)|| length==0){
	       var ids = [];
		     <#list part as list>
				ids.push($("#partImageArr"+${list.id}+" .changebg").attr("value"));
		     </#list>				
		     $("#ids").val(ids.join(","));
		     $("#post").submit();
	    } else {
	      alert("请选择尺码");
	    }
	}

	//	显示部件名称	
	$(document).ready(function() {
		$(".lbox").mouseover(function(){
			$(this).children().children(".partintro").show();
		});
		$(".lbox").mouseout(function(){
			$(this).children().children(".partintro").hide();
		});
	});
</script>

		
</#macro>

