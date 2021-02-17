<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko" xml:lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta name="description" content="스프링부트 샘플.">
    <meta name="viewport" content="width=1200">
    <meta name="format-detection" content="telephone=no">

    <title><sitemesh:write property='title'/> | SAMPLE_SPRING</title>


    <%@ include file="/WEB-INF/decorater/include/styles.jsp" %>
    <%@ include file="/WEB-INF/decorater/include/script.jsp" %>

    <sitemesh:write property='head'/>



</head>
<body>

    <%@ include file="/WEB-INF/decorater/include/header.jsp" %>

    <div id="wrap" class="<sitemesh:write property='meta.bodyClass'/>"  style="min-height: 700px;" >
        <!--Content-->
        <div id="container" class="container" style="min-height: 700px;">
            <sitemesh:write property='body'/>
        </div>
        <!--//Content-->
    </div>

    <%@ include file="/WEB-INF/decorater/include/modal.jsp" %>

    <div class="container" >
        <%@ include file="/WEB-INF/decorater/include/footer.jsp" %>
    </div>


</body>

