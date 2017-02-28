<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>历史上的今天 - by Mr.X</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/file_resource/phone/icon.jpg" />
    <!-- meta使用viewport以确保页面可自由缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 jQuery Mobile 样式 -->
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <!-- 引入 jQuery 库 -->
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <!-- 引入 jQuery Mobile 库 -->
    <script src="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/file_resource/phone/css/animate.min.css" />
    <!-- 自定义css -->
    <style type="text/css">
	    body,input{
			font-family: "微软雅黑";
	    }	  
    </style>
</head>

<body>
    <div data-role="page">
        <div data-role="header" class="">
            <h1>手机号码归属地查询</h1>
        </div>
        <div data-role="main" class="ui-content">

       		<form action="${pageContext.request.contextPath}/phone/get" method="post" class="animated bounceInDown">
                <input type="text" name="phone" value="${phone}" required/>
                <input type="submit" value="搜 索" />
            </form>
	        <ul data-role="listview" data-inset="true" class="animated rotateInDownLeft">
                <c:if test="${_phone.resultcode != null}">
                    <li>查询编号：${_phone.resultcode}</li>
                    <li>查询状态：${_phone.reason}</li>
                    <li>省份：${_phone.result.province}</li>
                    <li>城市：${_phone.result.city}</li>
                    <li>区号：${_phone.result.areacode}</li>
                    <li>邮政编码：${_phone.result.zip}</li>
                    <li>公司：${_phone.result.company}</li>
                    <li>卡类别：${_phone.result.card}</li>
                </c:if>
		    </ul>
		</div>	              
        <div data-role="footer">
            <h1> - by Mr.X</h1>
        </div>
        </div>
</body>

</html>
