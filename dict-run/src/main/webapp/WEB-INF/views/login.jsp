<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="overview & stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>${sysName }</title>
<link rel="icon" href="${ctx}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon" />
<link href="${ctx}/assets/css/base/login.css" rel="stylesheet">
<script>
	if (window != top) {
		top.location.href = location.href;
	}
</script>
</head>
<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>字典后台</h1>

				<form class="form">
					<input type="text" id="u" name="u" value="${username}" placeholder="请输入用户名" tabindex="1" autocomplete="off"/>
					<input type="password" id="p" name="p" value="" placeholder="请输入密码" tabindex="2" autocomplete="off"/>
					<button type="submit" id="loginBtn">登录</button>
				</form>
			</div>

			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>






</body>
<script src="${ctx}/assets/js/require.js" js-main="biz/base/login" charset="utf-8"></script>
</html>