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
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/sample/file/fileUpload.js"></script>
</head>
<body class="col-md-12">
<form method="post" id="uploadForm" enctype="multipart/form-data" style="padding-top: 80px;">
    <fieldset>
        <legend>파일 업로드</legend>
        <div class="form-group">
            <label for="exampleTextarea">파일 설명</label>
            <textarea name="fileDesc" id="fileDesc" class="form-control" id="exampleTextarea" rows="3" required></textarea>
            <small class="form-text empFileDesc" style="color: red; display: none">파일 설명을 입력하세요</small>
        </div>

        <div class="form-group">
            <label for="exampleInputFile">파일 선택</label>
            <input type="file" name="file" id="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" accept="image/*, video/*, .xls, .xlsx" required>
            <small class="form-text empFile" style="color: red; display: none">파일을 선택하세요</small>
            <small class="form-text valFileName" style="color: red; display: none">20자 이하 파일명만 가능합니다.</small>
        </div>

        <input type="button" class="btn btn-primary uploadBtn" value="입력">
    </fieldset>
</form>


</body>
</html>
