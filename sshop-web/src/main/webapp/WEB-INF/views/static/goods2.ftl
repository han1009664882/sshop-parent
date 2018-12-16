
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>热门商品</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/res/css/old/index.css">
<link rel="stylesheet" type="text/css" href="/res/css/top.css">
<link rel="stylesheet" type="text/css" href="/res/css/classify/buytop.css">
<link rel="stylesheet" type="text/css" href="/res/css/classify/buytop1280.css"
	media="screen and (min-width:1280px)">
<link rel="stylesheet" type="text/css" href="/res/css/classify/buy.css">
<link rel="stylesheet" type="text/css" href="/res/css/classify/buy1280.css"
	media="screen and (min-width:1280px)">
<!--需要引入的css样式-->
<link rel="stylesheet" href="/res/css/public_bottom.css" />
<link rel="stylesheet" type="text/css" href="/res/css/old/reset.css"/>
<style>
	/* 添加热门商品的鼠标hover事件的样式 */
.goods-image-hover:hover{
	border:2px solid #e4393c;
	overflow:hidden;
}
/* 添加热门商品的鼠标hover事件的样式 */
</style>
	<script type="text/javascript" src="/res/js/scripts/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="/res/js/scripts/jquery.lazyload.js?v=1.9.1"></script>
	<script type="text/javascript">
	$(function() {
      $("img.lazy").lazyload({
      	placeholder:"/res/img/progess.jpg",
      	effect:"fadeIn"});
 	 });
	function backhome(){
		 window.location.href="index.html"; 
	}	
	function go(id,code){
		$("#detailId").val(id);
		$("#goodsCode").val(code);
		$("#go").submit();
	}
	
	</script>
</head>
<body>
	<div class="top">
		<div class="basic logo" onclick="location.href ='/index.html'"></div>
		<div class="top_right">
			<div class="right1">
				<ul>
		<li><a href="/user/signup.html">注册</a></li>
		<li><a href="/user/login.html">登录</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div style="width: 100%; height: 80px;"></div>
		<form action="/goods/design.html" id="go" method="post">
			<input name="goodsCode" hidden="true" style="display:hidden;" id="goodsCode"/>
			<input name="detailId" hidden="true" style="display:hidden;" id="detailId"/>
		</form>
	<div class="container">
		<div class="box">
			<p class="p1">热门商品</p>
		</div>
	</div>

	<div>
		<div class="c1">
			<div class="container1">
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=S0000114719342811931839&detailId=1872">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147194129519751658772.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147194129519751658772.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">12</p>
							</div>
							<div class="h50">
								<p class="money" >￥12</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147220275605312555038.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147220275605312555038.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=Y0000214721335625278539&detailId=2003">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147213368440431499118.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147213368440431499118.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">波点心率</p>
							</div>
							<div class="h50">
								<p class="money" >￥0.1</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=N0000414728052397871435&detailId=2067">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147280526820821376150.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147280526820821376150.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">耐克</p>
							</div>
							<div class="h50">
								<p class="money" >￥12</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147220275605312555038.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147220275605312555038.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=P0000114766697735004292&detailId=2604">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/14766705279812313278.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/14766705279812313278.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">Ray-Ban RB3447 圆形镀金拉丝镜架棕色偏光镜片太阳镜</p>
							</div>
							<div class="h50">
								<p class="money" >￥1450</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147193158442310609420.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147193158442310609420.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=N0000214766717314758279&detailId=2610">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147667244131516395582.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147667244131516395582.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">耐克鞋EV发泡松糕底白色系</p>
							</div>
							<div class="h50">
								<p class="money" >￥599</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=N0000314766806190382091&detailId=2628">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147668109673863315942.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147668109673863315942.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">耐克鞋air max鞋底（科技流层缓震） 金属银鞋面</p>
							</div>
							<div class="h50">
								<p class="money" >￥1199</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=N0000414721095732924441&detailId=1987">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147210967205287218140.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147210967205287218140.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">1</p>
							</div>
							<div class="h50">
								<p class="money" >￥2</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147072778310961553424.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147072778310961553424.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=P0000114766697735004292&detailId=2603">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147667050912555736246.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147667050912555736246.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">Ray-Ban RB3447 圆形镀金拉丝镜架枪灰色偏光镜片太阳镜</p>
							</div>
							<div class="h50">
								<p class="money" >￥1450</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147193158442310609420.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147193158442310609420.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=N0000214766717314758279&detailId=2609">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147667240209394955985.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147667240209394955985.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">耐克鞋EV发泡松糕底红色系</p>
							</div>
							<div class="h50">
								<p class="money" >￥599</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg">
							</div>
						</div>
					</div>
					<div class="good goods-image-hover">
						<div class="goods-image">
						<!--添加一个hover事件的class=“goods-image-hover”-->
							<a href="/goods/design.html?goodsCode=H0000114720301135724086&detailId=1967">
								<img class="lazy goods " data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147203017993113810951.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147203017993113810951.jpg">
							</a>
						</div>
						<div class="goods-intro">
							<div class="h50" style="height:40px;">
								<p class="h50p" style="height:40px;overflow:hidden;">23</p>
							</div>
							<div class="h50">
								<p class="money" >￥1</p>
								<img class="lazy icon" data-original="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg" src="http://bat128.img-cn-shanghai.aliyuncs.com/images/147202723442068063558.jpg">
							</div>
						</div>
					</div>
			</div>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js" ></script>
	<div class="container" style="width:570px" >
		<form id="pageForm" action="/goods/list" method="post" >
			<input type="hidden" name="type" id="paginationType" value="hot" />
			<input type="hidden" name="categoryId" value="" />
			<input type="hidden" name="page" id="paginationPage" />
		</form>
		<nav aria-label="Page navigation" style="padding-top:15px">
			<ul class="pagination" id="pagination">
				<li class="page-item first disabled">
					<a href="javascript:goto(1)" class="page-link">首页</a>
				</li>
				<li class="page-item prev disabled">
					<a href="javascript:goto(0)" class="page-link">上一页</a>
				</li>
					<li class="page-item active">
						<a href="javascript:goto(1)" class="page-link">1</a>
					</li>
					<li class="page-item ">
						<a href="javascript:goto(2)" class="page-link">2</a>
					</li>
					<li class="page-item ">
						<a href="javascript:goto(3)" class="page-link">3</a>
					</li>
					<li class="page-item ">
						<a href="javascript:goto(4)" class="page-link">4</a>
					</li>
					<li class="page-item ">
						<a href="javascript:goto(5)" class="page-link">5</a>
					</li>
					<li class="page-item ">
						<a href="javascript:goto(6)" class="page-link">6</a>
					</li>
					<li class="page-item ">
						<a href="javascript:goto(7)" class="page-link">7</a>
					</li>
				
				<li class="page-item next  ">
					<a href="javascript:goto(2)" class="page-link">下一页</a>
				</li>
				<li class="page-item last  ">
					<a href="javascript:goto(11)" class="page-link">末页</a>
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
	<footer id="footer">
			<div class="footer_container">
				<!--上方特优退标示-->
				<ul class="footer_top">
					<!--特-->
					<li>
						<img src="/res/img/te.png" />
						<div>
							<p class="footer_p1">在线设计</p>
							<p class="footer_p2">满足各种需求</p>
						</div>
					</li>
					<!--优-->
					<li>
						<img src="/res/img/you.png"/>
						<div>
							<p class="footer_p1">品质保障</p>
							<p class="footer_p2">全球精选 品质保障</p>
						</div>
					</li>
					<!--退-->
					<li>
						<img src="/res/img/tui.png"/>
						<div>
							<p class="footer_p1">极速退款</p>
							<p class="footer_p2">极速退款 售后服务</p>
						</div>
					</li>
				</ul>
				<!--下方关于我们-->
				<div class="footer_bottom">
					<!--左边区域-->
					<ul class="footer_bottom_left">
						<li><a href="/index.html" class="first_bat">首页</a></li>
						<li><a href="/helphtml/newintro/basic-contro.html">新手指南</a></li>
						<li><a href="/helphtml/aboutus.html">关于我们</a></li>
						<li><a href="/helphtml/contactus.html">联系我们</a></li>
						<li><a href="/helphtml/joinus.html">加入我们</a></li>
					</ul>
					<!--右边区域-->
					<div class="footer_bottom_right">
						@BAT128.com&nbsp;2016版权所有&nbsp;&nbsp;浙ICP备15023010号-1
					</div>
				</div>
			</div>
	</footer>
	<!--footer底部排版-->

</body>
</html>