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
</head>
<body class="col-md-12"><div class="fileWrap col-md-12" style="
    padding-top: 70px;
    padding-bottom: 70px;
">
    <h1 class="hi">파일 리스트</h1>

    <div class="row" style="padding-bottom: 10px; padding-top: 10px;" >
        <div class="col-lg-2">
        <select class="custom-select" id="fileSearch">
            <option selected="" value="all">검색</option>
            <option value="ORIGIN_NAME">파일이름</option>
            <option value="FILE_DESC">내용</option>
        </select>
        </div>
        <div class="col-lg-4">
         <input type="text" class="form-control searchWord" placeholder="검색어" id="inputDefault">
        </div>

        <div class="col-lg-1">
            <button type="button" class="btn btn-primary searchBtn">검색</button>
        </div>
    </div>


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
        <ul class="pagination pagination-sm filePaging">
        </ul>
    </div>

    <div class="col-lg-1">
        <button type="button" class="btn btn-primary uploadBtn">업로드</button>
    </div>
</div>
</body>
</html>
