<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <title>历史上的今天 - by Mr.X</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/file_resource/history/icon.png" />
    <!-- meta使用viewport以确保页面可自由缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 jQuery Mobile 样式 -->
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <!-- 引入 jQuery 库 -->
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <!-- 引入 jQuery Mobile 库 -->
    <script src="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/file_resource/history/css/animate.min.css" />
    <!-- 自定义css -->
    <style type="text/css">
	    body,input{
			font-family: "微软雅黑";
	    }
	    .history .content {
	        font-size: 12px;
	        margin: 5px 0 5px 0;
	        padding: 5px 0 5px 0;
	        border: 1px solid #6c97d8;
	        border-radius: 5px;
	    }
        .history .content img{
            margin:0 0 0 6px;
        }
    </style>
</head>

<body>
    <div data-role="page">
        <div data-role="header" class="">
            <h1>历史上的今天</h1>
        </div>
        <div data-role="main" class="ui-content">
            <form action="${pageContext.request.contextPath}/history/get" method="post" class="animated bounceInDown">
                <input type="date" name="date" value="${date}"/>
                <input type="submit" value="搜 索" />
            </form>
            <div class="history animated rotateInDownLeft">
                <c:forEach items="${results}" var="result">
                    <div class="ui-grid-c content">
                        <div class="ui-block-a">
                            <c:choose>
                                <c:when test="${result.pic == ''}">
                                    <img src="${pageContext.request.contextPath}/file_resource/history/imgs/timg.png" style="width: 80px;border-radius: 40px;" />
                                </c:when>
                                <c:otherwise>
                                    <img src="${result.pic}" style="width: 80px;height: 80px;border-radius: 40px;" />
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="ui-grid-a text">
                            <span>标题：${result.title}</span>
                            <br/>
                            <span>日期：${result.year}-${result.month}-${result.day}</span>
                            <br/>
                            <span>描述：${result.des}</span>
                            <br/>
                            <span>农历：${result.lunar}</span>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div data-role="footer">
                <h1> - by Mr.X</h1>
            </div>
        </div>
</body>

</html>
