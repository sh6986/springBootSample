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
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/sample/member/login.js"></script>
</head>
<body class="col-md-12"><div class="fileWrap col-md-12" style="
    padding-top: 70px;
    padding-bottom: 70px;
">
    <legend>로그인</legend>
    <div class="form-group">
        <label>ID</label>
        <input type="email" id="id" class="form-control" aria-describedby="emailHelp" placeholder="Enter Id">
        <small class="form-text emptyId" style="color: red; display: none">아이디를 다시 입력하세요.</small>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password">
        <small class="form-text emptyPwd" style="color: red; display: none">비밀번호를 다시 입력하세요.</small>
    </div>
    <small class="form-text notLogin" style="color: red; display: none">가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.</small>
    <input type="button" value="로그인" id="btnLogin">
</div>
</body>

</html>
