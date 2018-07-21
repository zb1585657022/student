<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page    isELIgnored="false"  %>
<html>
<head>
    <script type="text/javascript">
        function ss() {
            var name = document.getElementById("name").value;
            if(name.length>40)
            {
                var b = document.getElementById("1");
                b.innerText = "姓名格式不正确(姓名长度最大为40)";
                b.style.color = "red";
                return false;
            }
            if(null==name|""==name){
                var b = document.getElementById("1");
                b.innerText = "姓名不能为空";
                b.style.color = "red";
                return false;
            }
            var birthday = document.getElementById("birthday").value;
            if(null==birthday|""==birthday){
                var b = document.getElementById("3");
                b.innerText = "出生日期不能为空";
                b.style.color = "red";
                return false;
            }
            var beizhu = document.getElementById("beizhu").value;
            if(name.length>255)
            {
                var b = document.getElementById("2");
                b.innerText = "备注格式不正确(备注最大长度为255)";
                b.style.color = "red";
                return false;
            }
            if(null==beizhu|""==beizhu){
                var b = document.getElementById("2");
                b.innerText = "备注不能为空";
                b.style.color = "red";
                return false;
            }
            var avemark = document.getElementById("avemark").value;
            if(null==avemark|""==avemark){
                var b = document.getElementById("4");
                b.innerText = "平均分不能为空";
                b.style.color = "red";
                return false;
            }
        }
    </script>
</head>
<body>
    <h1 style="text-align: center;color: blue;">修改信息</h1>
    <form action="RegistServlet" method="get" onsubmit="return ss()">
        <table align="center">
            <c:forEach items="${requestScope.list}" var="student">
                <tr>
                    <td><div align=right>id:</div></td>
                    <td align="left"><input type="text" name="id"
                                            id="id" value="${student.id}" readonly>
                    </td>
                </tr>
                <tr>
                    <td><div align=right>姓名:</div></td>
                    <td align="left"><input type="text" name="name"
                                            id="name" value="${student.name}">
                    </td><td><span id="1"></span></td>
                </tr>
                <tr>
                    <td><div align=right>出生日期:</div>
                    </td>
                    <td align="left"><input type="date" name="birthday"
                                            id="birthday" value="${student.birthday}">
                    </td><td><span id="3"></span></td>
                </tr>
                <tr>
                    <td>
                        <div align=right>备注:</div></td>
                    <td align="left"><input type="text" name="beizhu"
                                            id="beizhu" value="${student.beizhu}">
                    </td><td><span id="2"></span></td>
                </tr>
                <tr>
                    <td>
                        <div align=right>平均分:</div></td>
                    <td align="left"><input type="text" name="avemark"
                                            id="avemark" value="${student.avemark}">
                    </td><td><span id="4"></span></td>
                </tr>
                <tr>
                    <td align="center" colSpan=2><input type="submit" value="提交">
                        <input type="reset" value="重置">
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
