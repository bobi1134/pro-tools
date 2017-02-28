<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>波波小说网 - 章节列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/file_resource/novel/icon.jpg" />
    <!-- meta使用viewport以确保页面可自由缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 jQuery Mobile 样式 -->
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <!-- 引入 jQuery 库 -->
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <!-- 引入 jQuery Mobile 库 -->
    <script src="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <!-- 自定义css -->
    <style type="text/css">
    * {
        padding: 0px;
        margin: 0px;
    }
    
    body {
        font-family: "微软雅黑";
    }
    
    .ui-listview>li.ui-first-child {
        font-size: 20px;
        padding: 6px;
    }

    .ui-listview>li p {
        font-family: "微软雅黑";
        font-size: 16px;
        margin: 0px;
    }
    </style>
</head>

<body>
    <div data-role="page">
        <div data-role="header" class="">
            <h1>波波小说-章节列表</h1>
        </div>
        <!-- 中间内容 -->
        <div data-role="main" class="ui-content">
            <!-- 章节列表-->
            <ul data-role="listview" data-inset="true">
                <li>${novel.name} - ${novel.author}</li>
                <c:forEach items="${novels}" var="novel">
                    <li>
                        <a href="${pageContext.request.contextPath}/novel/content?url=${novel.url}">
                            <p>${novel.title}</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <div data-role="footer">
                <h1> - by Mr.X</h1>
            </div>
        </div>
</body>

</html>
