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
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/sample/file/fileModify.js"></script>
    <script type="text/javascript">
        // Context Path 경로 설정
        const contextPath = '${pageContext.request.contextPath}';
    </script>
</head>
<body class="col-md-12"><div class="fileWrap col-md-12" style="
    padding-top: 70px;
    padding-bottom: 70px;
">
    <legend>파일 수정</legend>
    <label>파일제목 수정</label>

    <div class="row" style="padding-bottom: 10px; padding-top: 10px;" >
        <input type="hidden" value="${fileNo}" id="fileNo">
        <input type="hidden" value="" id="fileExt">
        <input type="text" id="originName" class="form-control" placeholder="">
    </div>

    <div class="col-lg-1">
        <input type="button" class="btn btn-primary modifyBtn" value="수정">
    </div>
</div>
</body>
</html>