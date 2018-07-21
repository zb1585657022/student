<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="AddServlet" method="get" style="text-align: left;" onsubmit="return ss()">
        姓名：<input type="text" id="name" name="name"><span id="1"></span><br>
        出生日期：<input type="date" id="birthday" name="birthday"><span id="3"></span><br>
        备注：<input type="text" id="beizhu" name="beizhu"><span id="2"></span><br>
        平均分：<input type="number" id="avemark" name="avemark"><span id="4"></span><br />
        <input type="submit" value="提交">
    </form>
</body>
</html>
