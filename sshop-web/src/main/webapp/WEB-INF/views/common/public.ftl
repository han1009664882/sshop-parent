<#macro top >
	<div class="top1" id="top">
	    <div class="logo" onclick="location.href ='${ctx}/index'"></div>
	    <div class="top_right">
			<ul>
				<@top_common />
			</ul>
	    </div>
	</div>
</#macro>
<#macro head title description>
<div class="head">
    <div style="width:30%;">
        <p class="title">
            <span>${title!}</span>
        </p>
        <p>
            <span style="font-size:14px;">${description!}</span>
        </p>
    </div>
</div>
</#macro>




<#macro  goodsTop>
	<div class="top">
		<div class="basic logo" onclick="location.href ='/index.html'"></div>
		<div class="top_right">
			<div class="right1">
				<ul>
					<@top_common />
				</ul>
			</div>
		</div>
	</div>
</#macro>





<#macro top_common>
	<#if loginUser?exists && loginUser.userIdString?exists >
		<li class="top_ul_li"><a href="/order/pstatus.html"><span class='producter_li'>生产者</span></a>
	        <div class="entry" style="padding-bottom: 5px;">
	            <div class="entry-trangle"></div>
	            <p><a href="${ctx}/order/pstatus.html?status=1">已付新订单</a></p>
	            <p><a name="product_count" onclick="no()">可评价</a></p>
	            <p class="entrey_p" style="border:0">
	           		<a href="${ctx}/producer/upload/index.html" title="Styling forms">发布新品</a>
	            </p>
	        </div>
	    </li>
	    <li class="top_ul_li"><a href="/order/status.html">消费者</a>
	        <div class="entry" style="padding-bottom: 5px;">
	            <div class="entry-trangle"></div>
	            <p><a href="/order/customer/conllect.html">曾经心动</a></p>
	            <p><a href="${ctx}/order/status.html?status=0" name="no_pay">未付款</a></p>
	            <p class="entry_p" style="border:0"><a  name="no_eva" onclick="no()">未评价</a></p>
	        </div>
	    </li>
	    <script>
	    function no(){
	     alert("该功能暂未开放");
	    }
	    </script>
	    <li class="top_ul_li" id="message"><a id="a_msg_show" onclick="showalert()">消息</a></li>
	    <li class="top_ul_li last_child">
	        <div style="text-align:center;" class="name_img">
	            <a href="${ctx}/user/myhome.html">
	            <img src="${loginUser.headImage!}" id="user"
	                style="float:left;margin-left:5px;height:50px;line-height:50px;border-radius:50%;"/>
					${loginUser.lastname!}
	            </a>
	            <div id="username" style="font-size: 18px;height:50px;line-height:50px;color:#337ab7;">
	                <a href="*" style="display:inline;"></a>
	            </div>
	            <div style="clear:both"></div>
	        </div>
	        <div class="entry last" style="width:125px;">
	            <div class="entry-trangle"></div>
	            <p><a href="${ctx}/user/AccountCenter.html">账号中心</a></p>
	            <p><a href="${ctx}/user/mydna.html">我的DNA</a></p>
	            <p class="entry_p" style="border:0"><a href="${ctx}/user/logout.html"
	                                                   style="cursor:pointer;">退出</a></p>
	        </div>
	    </li>
	<#else>
		<li><a href="${ctx}/user/signup.html">注册</a></li>
		<li><a href="${ctx}/user/login.html">登录</a></li>
	</#if>
</#macro>

<#macro comon_unlogin>
	<ul class="top_ul">
		<li>
			<a href="${ctx}/user/signup.html">注册</a>
		</li>
		<li>
			<a href="${ctx}/user/login.html">登录</a>
		</li>
	</ul>
</#macro>

<#macro othrer_bottom>
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
						<li><a href="${ctx}/index.html" class="first_bat">首页</a></li>
						<li><a href="${ctx}/helphtml/newintro/basic-contro.html">新手指南</a></li>
						<li><a href="${ctx}/helphtml/aboutus.html">关于我们</a></li>
						<li><a href="${ctx}/helphtml/contactus.html">联系我们</a></li>
						<li><a href="${ctx}/helphtml/joinus.html">加入我们</a></li>
					</ul>
					<!--右边区域-->
					<div class="footer_bottom_right">
						@BAT128.com&nbsp;2016版权所有&nbsp;&nbsp;浙ICP备15023010号-1
					</div>
				</div>
			</div>
	</footer>
	<!--footer底部排版-->

</#macro>

<#macro public_bottom>
<!--新手指南-->
	<div class="newplayer" onclick="location.href ='${ctx}/helphtml/newintro/basic-contro.html'">
		<p class="a1">新手指南</p>
		<p class="a2">手把手教你玩转BAT</p>
	</div>
	<!--低端的关于我们的模块 所用css:bottom.css 路径在/res/css/old里面-->
	<div class="public_bottom">
		<div class="left">
			<img src="/res/img/top/bottom_bat1.png" alt="" />
			<p>
				<a href="/helphtml/aboutus.html">关于我们</a>
			</p>
			<p>
				<a href="/helphtml/contactus.html">联系我们</a>
			</p>
			<p>
				<a href="/helphtml/joinus.html">加入我们</a>
			</p>
		</div>
		<div class="center">
			<img src="/res/img/top/bottom_cooperation1.png" alt="" />
			<p>
				<a href="/helphtml/businessdeve.html">业务发展</a>
			</p>
			<p>
				<a href="http://m.kuaidi100.com" target="_blank">快递查询</a>
			</p>
			<p>
				<a href="/helphtml/sc.html">战略合作</a>
			</p>
		</div>
		<div class="right">
			<img src="/res/img/top/bottom_alipay1.png" alt="" />
			<p>
				<a href="/helphtml/safepay.html">交易安全</a>
			</p>
			<p></p>
			<p>
				<a href="/helphtml/plats.html">平台保障</a>
			</p>
		</div>
		<div class="public_bottom">
			@BAT128.com 2016版权所有<br> 浙ICP备15023010号-1
		</div>
	</div>
</#macro>