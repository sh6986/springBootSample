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
    <script type="text/javascript" src="${pageContext.request.contextPath}/asserts/sample/file/fileList.js"></script>
    <script type="text/javascript">
        // Context Path 경로 설정
        const contextPath = '${pageContext.request.contextPath}';
    </script>
</head>
<body><div class="fileWrap" style="
    padding-top: 70px;
    padding-bottom: 70px;
">
    <h1 class="hi">파일 리스트</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">파일번호</th>
            <th scope="col">파일명</th>
            <th scope="col">생성일자</th>
            <th scope="col">생성자</th>
        </tr>
        </thead>
        <tbody class="fileList">

        </tbody>
    </table>

    <div style="
    text-align: center;

">
        <ul class="pagination pagination-sm">
            <li class="page-item disabled">
                <a class="page-link" href="#">«</a>
            </li>
            <li class="page-item active">
                <a class="page-link" href="#">1</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">3</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">4</a>
            </li>
            <li class="page-item" style="
    text-align: center;
">
                <a class="page-link" href="#">5</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">»</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
