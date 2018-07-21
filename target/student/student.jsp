<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page    isELIgnored="false"  %>
<html>
<head>
</head>
<body>
<form action="AddServlet" method="get">
    <a href="add.jsp">新增</a>
</form>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>出生日期</th>
        <th>备注</th>
        <th>平均分</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.birthday}</td>
            <td>${student.beizhu}</td>
            <td>${student.avemark}</td>
            <td><a href="DeleteServlet?id=${student.id}">删除</a>
                <a href="ReviseServlet?id=${student.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="11"><a href="DivPageServlet?currentPage=1">首页</a>
            <a href="DivPageServlet?currentPage=${requestScope.currentPage-1}">上一页</a>
            <a href="DivPageServlet?currentPage=${requestScope.currentPage+1}">下一页</a>
            <a href="DivPageServlet?currentPage=${requestScope.countPage}">尾页</a>
            <form action="DivPageServlet" method="post">
                <input size="4px" name="jumpPage" id="jumpPage">页
                <input type="submit" value="跳转">
            </form>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
