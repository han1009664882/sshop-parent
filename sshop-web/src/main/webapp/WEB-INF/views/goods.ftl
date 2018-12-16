
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>热门商品</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/index.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/top.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/classify/buytop.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/classify/buytop1280.css"
	media="screen and (min-width:1280px)">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/classify/buy.css">
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/classify/buy1280.css"
	media="screen and (min-width:1280px)">
<!--需要引入的css样式-->
<link rel="stylesheet" href="${ctx}/res/css/public_bottom.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/res/css/old/reset.css"/>
<style>
	/* 添加热门商品的鼠标hover事件的样式 */
.goods-image-hover:hover{
	border:2px solid #e4393c;
	overflow:hidden;
}
/* 添加热门商品的鼠标hover事件的样式 */
</style>
	<script type="text/javascript" src="${ctx}/res/js/scripts/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${ctx}/res/js/scripts/jquery.lazyload.js?v=1.9.1"></script>
	<script type="text/javascript">
	$(function() {
      $("img.lazy").lazyload({
      	placeholder:"${ctx}/res/img/progess.jpg",
      	effect:"fadeIn"});
 	 });
	function backhome(){
		 window.location.href="${ctx}/index"; 
	}	
	function go(id,code){
		$("#detailId").val(id);
		$("#goodsCode").val(code);
		$("#go").submit();
	}
	
	</script>
</head>
<body>
	<#--引用顶部-->
	<@p.goodsTop />
	<div style="width: 100%; height: 80px;"></div>
		<form action="${ctx}/goods/detail" id="go" method="post">
			<input name="goodsCode" hidden="true" style="display:hidden;" id="goodsCode"/>
			<input name="detailId" hidden="true" style="display:hidden;" id="detailId"/>
		</form>
	<div class="container">
		<div class="box">
			<p class="p1">${title?if_exists}</p>
		</div>
	</div>

	<div>
		<div class="c1">
			<div class="container1" style="height:1380px;" >
				<#list data as good >
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="${ctx}/goods/detail/${good.id?c}">
								<img class="lazy goods " data-original="${good.images?if_exists}" >
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:44px;">
								<p class="h50p" style="height:44px;overflow:hidden;">${good.name?if_exists}</p>
							</div>
							<div class="h50">
								<p class="money">￥${good.price}</p>
								<#if good.producer??&& good.producer.header??>
									<img class="lazy icon" data-original="${good.producer.header?if_exists}">
								</#if>
							</div>
						</div>
					</div>
				</#list>
			</div>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js" ></script>
	<div class="container" style="width:1110px;padding-left:306.5px;" >
		<form id="pageForm" action="${ctx}/goods/list" method="post" >
			<input type="hidden" name="type" id="paginationType" value="${query.type?if_exists}" />
			<input type="hidden" name="categoryId" value="<#if query.categoryId?? >${query.categoryId?c}</#if>" />
			<input type="hidden" name="page" id="paginationPage" />
		</form>
		<nav aria-label="Page navigation" style="padding-top:15px">
			<ul class="pagination" id="pagination">
				<li class="page-item first <#if paginator.firstPage >disabled</#if>">
					<a href="javascript:goto(1)" class="page-link">首页</a>
				</li>
				<li class="page-item prev <#if paginator.firstPage >disabled</#if>">
					<a href="javascript:goto(${paginator.prePage?c})" class="page-link">上一页</a>
				</li>
				<#list paginator.slider as s >
					<li class="page-item <#if s == paginator.page >active</#if> ">
						<a href="javascript:goto(${s?c})" class="page-link">${s?c}</a>
					</li>
				</#list>
				<li class="page-item next <#if paginator.lastPage >disabled</#if>">
					<a href="javascript:goto(${paginator.nextPage?c})" class="page-link">下一页</a>
				</li>
				<li class="page-item last <#if paginator.lastPage >disabled</#if> ">
					<a href="javascript:goto(${paginator.totalPages?c})" class="page-link">末页</a>
				</li>
			</ul>
		</nav>
	</div>
	<script>
		function goto(page) {
			$("#paginationPage").val(page);
			$("#pageForm").submit();
		}
	</script>
		</div>
	</div>
	
	<!--footer底部排版-->
	<@p.othrer_bottom />
	<!--footer底部排版-->

</body>
</html>