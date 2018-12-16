<#macro pagination action type >
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js" ></script>
	<div class="container" style="width:570px" >
		<form id="pageForm" action="${action?if_exists}" method="post" >
			<input type="hidden" name="type" id="paginationType" value="${query.type!}" />
			<input type="hidden" name="categoryId" value="<#if query.categoryId?exists >${query.categoryId?c}</#if>" />
			<input type="hidden" name="page" id="paginationPage" />
		</form>
		<nav aria-label="Page navigation" style="padding-top:15px">
			<ul class="pagination" id="pagination">
				<li class="page-item first <#if query.firstPage >disabled</#if>">
					<a href="javascript:goto(1)" class="page-link">首页</a>
				</li>
				<li class="page-item prev <#if !query.hasPrePage >disabled</#if>">
					<a href="javascript:goto(${query.page - 1})" class="page-link">上一页</a>
				</li>
				<#list query.slider as num >
					<li class="page-item <#if query.page == num >active</#if>">
						<a href="javascript:goto(${num})" class="page-link">${num}</a>
					</li>
				</#list>
				
				<li class="page-item next <#if !query.hasNextPage >disabled</#if> ">
					<a href="javascript:goto(${query.page + 1})" class="page-link">下一页</a>
				</li>
				<li class="page-item last <#if query.lastPage >disabled</#if> ">
					<a href="javascript:goto(${query.totalPages})" class="page-link">末页</a>
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
</#macro>