<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<base href="<%=basePath%>"></base>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>