<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<li><a href="user/${item.user.id}/article/${item.id}" title="${item.title}" class="title">
	<c:choose>
		<c:when test="${fn:length(item.title)>'19'}">
			${fn:substring(item.title,0 ,18 )}...
		</c:when>
		<c:otherwise>
			${item.title}
		</c:otherwise>
	</c:choose>
</a></li>