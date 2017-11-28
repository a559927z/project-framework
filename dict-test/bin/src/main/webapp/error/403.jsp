<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>用户权限不足</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="overview & stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>${sysName }</title>
</head>
<style>
body img {
	width: 100%;
	margin: 0 auto;
}
</style>
<body>
	<p>
		<a href="${ctx }/">返回首页</a>
	</p>
	<img src="403.jpg" />
</body>
</html>
