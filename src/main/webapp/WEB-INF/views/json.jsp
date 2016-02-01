<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hcj.spring.web.bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--为了测试 shiro 权限验证--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    //List<Admin> adminList = (List<Admin> )(Map)request.getParameter("adminList").get;
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <meta charset="UTF-8">
        <title>测试接受后台的数据</title>
        <%--要先加载js--%>
        <script src="assets/plugins/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
    </head>
    <script type="text/javascript">

        $(document).ready(function(){
                    $("#submit_button").click(function(){
                       addTestAjax1();
                        addTestAjax2();
                        addTestAjax22();
//                        addTestAjax3();
//                        addTestAjax4();
                    });
                });
        /*ajax请求的POST方法测试*/
        function ajaxPost(url,dataParam,callback){
            var retData=null;
            $.ajax({
                type: "post",
                url: url,
                contentType: "application/x-www-form-urlencoded",
                data: dataParam,
                dataType: "json",
                success: function (data,status) {
                    // alert(data);
                    retData=data;
                    if(callback!=null&&callback!=""&&callback!=undefined)
                        callback(data,status);
                },
                error: function (err,err1,err2) {
                    alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));
                }
            });
            return retData;
        }

        function addTestAjax1(){
            var userName1 = $("#userName").val().toString();
            var password1 = $("#password").val().toString();
            console.log(userName1);
            console.log(password1);
            var loginDate = {userName:userName1,password:password1};
            $.ajax({
                url: " admin/testLogin1",
                type: "POST",
//                contentType: "application/x-www-form-urlencoded",
                contentType : 'application/json;charset=utf-8', //设置请求头信息[适合于对象请求]
               dataType:"JSON",//可以是json或jsonp格式
                data: JSON.stringify(loginDate),//原生态方法
//                data: $.toJSON(loginDate),//这个方法需要加jquery.json.min.js
                success: function(data){
                    console.log("成功"+data);
                    /*调用的是一个controller*/
                    window.location.href="admin/getIndexPage";
                    alert("成功"+data+"textSatus="+textStatus);
                },
                error: function(res){
                    alert("错误"+res.responseText);
                }
            });
        }
        /*ajax请求的GET方法测试*/
        function addTestAjax2(){
            var userName1 = $("#userName").val().toString();
            var password1 = $("#password").val().toString();
            console.log(userName1);
            console.log(password1);
            var loginDate = {userName:userName1,password:password1};
            $.ajax({
                url: "admin/testLogin",
                type: "POST",
               contentType: "application/x-www-form-urlencoded",
//                contentType : 'application/json;charset=utf-8', //(默认: "application/x-www-form-urlencoded") 发送信息至服务器时内容编码类型。默认值适合大多数应用场合。
                data:loginDate,//发送到服务器的数据
                dataType:"JSON",

                error: function(data){
                    alert("错误"+data.responseText);
                },
                success: function(data){
                    alert("成功"+data.userName);
                }

            });
        }

        /*ajax请求的GET方法测试*/
        function addTestAjax22(){
            var userName1 = $("#userName").val().toString();
            var password1 = $("#password").val().toString();
            console.log(userName1);
            console.log(password1);
            var loginDate = {userName:userName1,password:password1};
            $.ajax({
                url: "admin/testLogin",
                type: "POST",
//                contentType: "application/x-www-form-urlencoded",
//                contentType : 'application/json;charset=utf-8', //设置请求头信息
                dataType:"json",
                data:loginDate,
                error: function(data){
                    alert("错误"+data.responseText);
                },
                success: function(data){
                    alert("成功"+data.userName);
                }

            });
        }

        /*ajax请求,并显示结果*/
        function addTestAjax3(){
            var userName1 = $("#userName").val().toString();
            var password1 = $("#password").val().toString();
            console.log(userName1);
            console.log(password1);
            var loginDate = {userName:userName1,password:password1};
            $.ajax({
                url: "admin/testMapAjax",
                type: "GET",
                contentType: "application/x-www-form-urlencoded",
                //contentType : 'application/json;charset=utf-8', //设置请求头信息
                dataType:"json",
//                data:loginDate,
                success: function(data ,textStatus){
//                    alert("成功"+data+"textSatus="+textStatus);
//                    var result = date.jo
                     var retData = data;
                    if(callback!=null&&callback!=""&&callback!=undefined)
                        callback(data,status);
                },
                error: function(res){
                    alert("错误"+res.responseText);
                }
            });
        }

        /*ajaxPost请求,并显示结果*/
        function addTestAjax4(){
            var userName1 = $("#userName").val().toString();
            var password1 = $("#password").val().toString();
            console.log(userName1);
            console.log(password1);
            var loginDate = {userName:userName1,password:password1};
            var url ='admin/testMapAjax';
            var dataParam = $.parseJSON(loginDate);
           ajaxPost(url,dataParam,callback);
        }

        function add(){
            var form = document.getElementById('addForm');
            //设置请求方式为post,如果是get的话就要对发送过去的参数先进行编码然后再解码，此处不作演示，否则会乱码
            from.method="POST";
//            from.action="add";
            from.submit();
        }
    </script>
    <body>
    <div id="testReciveDateFromController">
        <%--测试Model--%>
        <c:forEach items="${adminList}" var="item">

            <ul>
                <span class="username"> ${item.userName } </span>
                <li style="width:10.66666666666667%; color:#BD45C0">${item.name} </li>
        </c:forEach>
        </ul>
        </br>
            <%--测试Map--%>
        <c:forEach items="${adminList}" var="item">

        <ul>
            <span class="username"> ${item.userName } </span>
             <li style="width:10.66666666666667%; color:#BD45C0">${item.name} </li>
        </ul>
        </c:forEach>
    </div>
    <div id="testPostDateToController">
        <form id="addForm" action="admin/testLogin2" method="get">
            帐号：<input type="text" name="userName"/>
            密码：<input type="text" name="password"/>
            <input type="submit" value="【测试直接接受页面的参数】登录" />
        </form>
    </div>
    <div id="testPostDateToController1">
        <form id="addForm1">
            帐号：<input id="userName" type="text" name="userName"/>
            密码：<input id="password" type="text" name="password"/>
            <input type="button" value="【测试用Ajax发送请求】登录" id="submit_button"/>
        </form>
    </div>

    <div>
        <!-- 测试权限控制 动态显示菜单用的-->
        <shiro:hasAnyRoles name="super_admin">
            <li>
                <a href="javascript:;">super_admin 拥有此角色</a>
            </li>
        </shiro:hasAnyRoles>

        <shiro:hasPermission name="user:create">
            <li>
                <a href="javascript:;">user:create 拥有此权限</a>
            </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="user:update">
            <li>
                <a href="javascript:;">user:update 拥有此权限</a>
            </li>
        </shiro:hasPermission>
    </div>

    </body>

</html>