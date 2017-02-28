<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>波波小说网 - 首页</title>
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
            <h1>波波小说-首页</h1>
        </div>
        <!-- 中间内容 -->
        <div data-role="main" class="ui-content">
            <!-- 搜索框 -->
            <form action="${pageContext.request.contextPath}/novel/search" method="post" class="animated bounceInDown">
                <input type="text" name="q" value="${q}" required/>
                <input type="submit" value="搜 索" />
            </form>
            <!-- 推荐内容-->
            <ul data-role="listview" data-inset="true">
                <li>玄幻小说</li>
                <c:forEach items="${novels}" var="novel">
                    <c:choose>
                        <c:when test="${novel.kind == '玄幻小说'}">

                                <li>
                                    <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                                        <p>${novel.title}</p>
                                    </a>
                                </li>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>
            <ul data-role="listview" data-inset="true">
                <li>修真小说</li>
                <c:forEach items="${novels}" var="novel">
                    <c:choose>
                        <c:when test="${novel.kind == '修真小说'}">

                            <li>
                                <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                                    <p>${novel.title}</p>
                                </a>
                            </li>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>
            <ul data-role="listview" data-inset="true">
                <li>都市小说</li>
                <c:forEach items="${novels}" var="novel">
                    <c:choose>
                        <c:when test="${novel.kind == '都市小说'}">

                            <li>
                                <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                                    <p>${novel.title}</p>
                                </a>
                            </li>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>
            <ul data-role="listview" data-inset="true">
                <li>历史小说</li>
                <c:forEach items="${novels}" var="novel">
                    <c:choose>
                        <c:when test="${novel.kind == '历史小说'}">

                            <li>
                                <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                                    <p>${novel.title}</p>
                                </a>
                            </li>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>
            <ul data-role="listview" data-inset="true">
                <li>科幻小说</li>
                <c:forEach items="${novels}" var="novel">
                    <c:choose>
                        <c:when test="${novel.kind == '科幻小说'}">

                            <li>
                                <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                                    <p>${novel.title}</p>
                                </a>
                            </li>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>
            <ul data-role="listview" data-inset="true">
                <li>网游小说</li>
                <c:forEach items="${novels}" var="novel">
                    <c:choose>
                        <c:when test="${novel.kind == '网游小说'}">

                            <li>
                                <a href="${pageContext.request.contextPath}/novel/list?url=${novel.url}">
                                    <p>${novel.title}</p>
                                </a>
                            </li>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </ul>

            <div data-role="footer">
                <h1> - by Mr.X</h1>
            </div>
        </div>
    </div>
</body>

</html>
