<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/">SAMPLE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <c:if test="${empty memberInfo}">
                    <a class="nav-link loginBtn"  href="/view/member/login">
                        로그인
                        <span class="sr-only">(current)</span>
                    </a>
                </c:if>
                <c:if test="${not empty memberInfo}">
                    <a class="nav-link loginBtn"  href="javascript:logout();">
                        로그아웃
                        <span class="sr-only">(current)</span>
                    </a>
                </c:if>
            </li>

            <c:if test="${empty memberInfo}">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:$('#signUp').modal();">회원가입</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="/view/file/list">파일리스트</a>
            </li>

            <c:if test="${not empty memberInfo}">
                <li class="nav-item">
                    <a class="nav-link removeBtn" href="javascript:memberRemove('${memberInfo.memId}')">회원탈퇴</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>





