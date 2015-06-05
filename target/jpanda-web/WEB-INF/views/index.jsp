<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/common/comm.jsp" %>

<script type="text/javascript">

$(function(){
	//alert('Now,we can use Jquery!');
});


</script>

<title>Welcome</title>
</head>
<body id="login">
  <%--
 <h2>Hello,Jpanda!</h2>
  --%>
 <div class="container">
      <form class="form-signin" action="${ctx}/login" method="post">
        <h2 class="form-signin-heading">请登录</h2>
        <input type="text"  name="username" class="input-block-level" placeholder="用户名或邮箱">
        <input type="password" name="password"  class="input-block-level" placeholder="密码">
        <label class="checkbox">
          <input type="checkbox" value="remember-me">记住我
        </label>
        <button class="btn btn-large btn-primary" type="submit">登录</button>
      </form>
 </div> 
</body>
</html>