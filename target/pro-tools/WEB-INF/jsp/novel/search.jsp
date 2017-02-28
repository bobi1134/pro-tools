<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>波波小说网 - 搜索结果</title>
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
    
    .ui-listview>li img{
        height: 74%;
        margin: 21px 0px 0px 10px;
    }
    .ui-listview .ui-li-has-thumb>.ui-btn>img:first-child{
        max-height: 8em;
    }

    </style>
</head>

<body>
    <div data-role="page">
        <div data-role="header" class="">
            <h1>波波小说-搜索结果</h1>
        </div>
        <!-- 中间内容 -->
        <div data-role="main" class="ui-content">
            <!-- 搜索框 -->
            <form action="${pageContext.request.contextPath}/novel/search" method="post" class="animated bounceInDown">
                <input type="text" name="q" value="${q}" required/>
                <input type="submit" value="搜 索" />
            </form>
            <!-- 搜索结果-->
            <ul data-role="listview" data-inset="true">
                <c:forEach items="${novels}" var="novel">
                    <li>
                        <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                            <img src="${pageContext.request.contextPath}/file_resource/novel/imgs/nopic.gif">
                            <h2>${novel.title}</h2>
                            <p>${novel.desc}</p>
                            <p>${novel.author}</p>
                            <p>${novel.kind}</p>
                            <p>${novel.updatetime}</p>
                            <p>${novel.newest}</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <div data-role="footer">
                <h1> - by Mr.X</h1>
            </div>
        </div>
    </div>
</body>

</html>
