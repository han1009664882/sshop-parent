<#macro imageList >
   
        <#list listImages as listImage>
           <div class="left" style="display:none">
			<div class="img_container" id="${listImage_index+1}">
			  <#list listImage as images>
			   <input class="${images.detailCode}" value="${images.detailCode}" style="display:none"/>
			   <img class="lazy good" src="${images.path}" style="display:none"/>
			  </#list>
			  <img class="lazy good" id="pic_show"  style="z-index: 100;"/>
			</div>
			<div class="change_pic change_pic_${listImage_index+1}"></div>
		  
		    <script>
    	    //轮播图函数
    	    var len=$("#${listImage_index+1} img").length-1;
		    var i=len;
		    $(".change_pic_${listImage_index+1}").click(function(){//获取类名的点击事件．
    		   if(i==len){i=0;}
    		   i++;
			   $("#${listImage_index+1} img").eq(i).fadeIn().siblings().hide();
  			});
          </script> 
		</div>
		
	</#list>
  
	
</#macro>


