<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<div class="art_img_box clearfix"> 
 <div class="fl innerimg_box"> 
  <a href="user/${item.user.id}/article/${item.id}" title="${item.title}"><img src="upload/${item.imagename}" alt="${item.title}" width="200" height="154" original="./user/${item.user.id}/article/${item.id}"/></a>
 </div>
 <div class="fr box_content">
  <h2><a href="user/${item.user.id}/article/${item.id}" title="${item.title}">
      ${item.title}</a></h2>
  <div class="info">
   <span>发布时间：<small>${item.releasetime}</small></span>|
   <span>点击：<small> ${item.visits}次</small></span>|
   <span><a href="user/${item.user.id}/article/${item.id}" title="${item.title}">
   	${fn:length(item.comments)}条评论</a>
   	</span>|
  </div>

  <ul class="clearfix">
   <li>所属栏目：<span>
	  			<a href="article/category/${item.articleType.linkname}" title="查看${item.articleType.value}的全部文章" rel="category tag">
	  			${item.articletype.value}
	  			</a>
  		</span>
  </li>
  <li class="art_author">
  			<span>作者：</span>
   <span >
   <a href="user/${item.user.id}" title="${item.title}">
   	${item.user.username}</a>
   	</span>
  </li>
  <div class="clearfix"></div>
   <li class="art_tag">标签：
   		<c:forEach items="${item.tags}" var="tagItem">
	    <a href="article/tag/${tagItem.value}" title="查看包含 ${tagItem.value} 标签的全部文章">${tagItem.value}</a>
	   </c:forEach>
   </li>
  </ul>
  <p class="intro"><c:out value="${item.beagincontent}"/></p>
 </div>
</div>