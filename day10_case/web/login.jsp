<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>

	<script>
	  /**
	   *      点击超链接或者图片，需要换一张
	   *      1、给超链接和图片绑定单击事件
	   *      2、重新设置图片的src属性值
	   */
	  window.onload = function () {
		  //获取图片对象
		  var img = document.getElementById("checkCode");
		  img.onclick = function () {
			  //加时间戳
			  var date = new Date().getTime();
			  img.src = "${pageContext.request.contextPath}/checkCodeServlet?" + date;
		  }
	  }

	</script>

</head>
  <body>
  	<div class="container" style="width: 400px;">
  		<h3 style="text-align: center;">管理员登录</h3>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
	      <div class="form-group">
	        <label for="username">用户名：</label>
	        <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码：</label>
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
	      </div>
	      
	      <div class="form-inline">
	        <label for="verifycode">验证码：</label>
	        <input type="text" name="checkCode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
	        <a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="checkCode"/></a>
	      </div>
	      <hr/>
	      <div class="form-group" style="text-align: center;">
	        <input class="btn btn btn-primary" type="submit" value="登录">
	       </div>
	  	</form>
		<!-- 出错显示的信息框 -->
		<c:if test="${not empty pageContext.request.getAttribute('cc_error')}">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" >
					<span>&times;</span></button>
				<strong>
					<font><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></font>
					登录失败!
				</strong>
			</div>
		</c:if>
		<c:if test="${not empty pageContext.request.getAttribute('lastTime')}">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" >
					<span>&times;</span></button>
				<strong>
					登陆成功，
					<font><%=request.getAttribute("lastTime") == null ? "欢迎您首次使用！" : "您上次登录的时间是："+request.getAttribute("lastTime")%></font>
				</strong>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/userListServlet" role="button">进入管理界面</a>
			</div>
		</c:if>
  	</div>
  </body>
</html>