<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2021-02-15
  Time: 오후 6:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/common/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/common/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/member/login.js"></script>
    <script type="text/javascript">
        // Context Path 경로 설정
        const contextPath = '${pageContext.request.contextPath}';
    </script>
</head>
<body>
<label>id</label><input type="text" id="id">
<label>password</label><input type="text" id="password">
<input type="button" value="로그인" id="btnLogin">
</body>
</html>