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
    <script type="text/javascript">
        // Context Path 경로 설정
        const contextPath = '${pageContext.request.contextPath}';
    </script>
</head>
<body class="col-md-12">
<form method="post" id="uploadForm" enctype="multipart/form-data" style="padding-top: 80px;">
    <fieldset>
        <legend>파일 업로드</legend>
        <div class="form-group">
            <label for="exampleTextarea">파일 설명</label>
            <textarea name="fileDesc" class="form-control" id="exampleTextarea" rows="3" required></textarea>
        </div>

        <div class="form-group">
            <label for="exampleInputFile">파일 선택</label>
            <input type="file" name="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" required>
            <small id="fileHelp" class="form-text text-muted">10mb 이상의 파일은 선택 불가 입니다.</small>
        </div>

        <input type="button" class="btn btn-primary uploadBtn" value="입력">
    </fieldset>
</form>


</body>
</html>