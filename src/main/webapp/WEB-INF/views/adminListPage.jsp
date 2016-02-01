<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>客户经理列表</title>
    <link rel="stylesheet" type="text/css" href="assets/plugins/bootstrap/css/bootstrap.css"/>
    <%--加载JS--%>
    <script src="assets/plugins/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <%-- 加载分页控件--%>

    <script src="assets/plugins/bootstrap-paginator/bootstrap-paginator.js" type="text/javascript"></script>
    <%--########################--%>
    <script type="text/javascript" charset="utf-8">
        /*写你要的js*/
        $(document).ready(function () {
            /*初始加载js*/
//                pagernator();
            testFunction();
            console.log("启动");
            pager();

/*            var options = {
                bootstrapMajorVersion: 2,
                currentPage: 1,
                numberOfPages: 1,
                totalPages: 11,
                itemTexts: function (type, page, current) {
                    switch (type) {
                        case "first":
                            return "First";
                        case "prev":
                            return "Previous";
                        case "next":
                            return "Next";
                        case "last":
                            return "Last";
                        case "page":
                            return "p" + page;
                    }
                }
            }
            $('#example').bootstrapPaginator(options);*/

        });
        /*写你自己的方法*/
        function testFunction() {
            $.ajax({
                url: "admin/getAdminList",
                contentType: 'application/json;charset=utf-8', //设置请求头信息[适合于对象请求]
                dataType: "JSON",
                type: "POST",
//                    data: JSON.stringify(loginDate),//原生态方法
                success: function (data) {
                    var pageCount = data.pageCount; //取到pageCount的值(把返回数据转成object类型)
                    var currentPage = data.CurrentPage; //得到urrentPage
                    var adminList = eval("(" + data + ")").adminList;
                    console.log("pageCount=" + pageCount + "currentPage=" + currentPage + " adminList=" + adminList);
                    console.log(data);
                },
                error: function (err) {
                    alert("未知错误！" + err);
                }
            });
        }
        //分页功能
        /*            var page=$('#pager1');
         var options = {
         currentPage:page.attr('pageNum'),
         totalPages:page.attr('pageCount'),
         numberOfPages:page.attr('numberOfPages'),
         pageUrl: function(type, page, current){
         return "/admin/getAdminListByPage?"+composeUrlParams()+"&p="+page;
         }
         }
         $('#pager1').bootstrapPaginator(options);*/

        function pager() {
            console.log("pager start");
            $.ajax({
                url: "admin/getAdminList",
                contentType: 'application/json;charset=utf-8', //设置请求头信息[适合于对象请求]
                dataType: "JSON",
                type: "POST",
                error: function () {
                },
                // success start
                success: function (data) {
                    if (data != null) {
                        var adminList = data.adminList;
                        console.log("adminList=" + adminList);
                        var result_html = '<table class="table table-striped">'
                                + '<caption>客户经理列表</caption>'
                                + '<thead>'
                                + '<tr>'
                                + '<th>姓名</th>'
                                + '<th>登入名</th>'
                                + '<th>工号</th>'
                                + '<th>直接提成</th>'
                                + '<th>工作状态</th>'
                                + '<th>间接提成</th>'
                                + '</tr>'
                                + '</thead>'
                                + '<tbody>';

                        for (var i = 0; i < adminList.length; i++) {
                            result_html += '<tr class="success<%--warning  danger active--%>">'
                                    + '<td>' + adminList[i].name + '</td>'
                                    + '<td>' + adminList[i].userName + '</td>'
                                    + '<td>' + adminList[i].code + '</td>'
                                    + '<td>' + adminList[i].sellRate + '</td>'
                                    + '<td>' + adminList[i].status + '</td>'
                                    + '<td>' + adminList[i].childSellRate + '</td>'
                                    + '<td>'
                                    + '<button class="btn btn-warning" onclick="Edit(' + adminList[i].id + ' );">修改</button>'
                                    + '<button class="btn btn-warning" onclick="Delete(' + adminList[i].id + ' );">修改</button>'
                                    + '</td>'
                                    + '</tr> ';
                        }
                        result_html += '</tbody>' + '</table>';
                        $("#list").append(result_html);
                        // --------------------读取数据成功后 填充数据table ---end

                        var pageCount = data.pageCount; //取到pageCount的值(把返回数据转成object类型)
                        var currentPage = data.CurrentPage; //得到urrentPage

                        var options = {
                            bootstrapMajorVersion: 2, //版本
                            currentPage: currentPage, //当前页数
                            totalPages: pageCount, //总页数
                            itemTexts: function (type, page, current) {
                                switch (type) {
                                    case "first":
                                        return "首页";
                                    case "prev":
                                        return "上一页";
                                    case "next":
                                        return "下一页";
                                    case "last":
                                        return "末页";
                                    case "page":
                                        return page;
                                }
                            },//点击事件，用于通过Ajax来刷新整个list列表
                            onPageClicked: function (event, originalEvent, type, page) {
                                console.log("page="+page);
                                var dataFormate = {pageNO:page,pageSize:2};
                                $.ajax({
                                    url: "admin/getAdminListByPage",
                                    type: "POST",
                                    /*contentType: 'application/json;charset=utf-8', //设置请求头信息[适合于对象请求]*/
                                    dataType: "JSON",
                                    data: {pageNO:page,pageSize:2},
                                    error: function () {
                                        alert("未知错误");
                                    },
                                    success: function (data1) {
                                        console.log(data1);
                                        if (data1 != null) {
                                            //var adminListTemp =eval("("+data1+")").adminListTemp;
                                            var adminListTemp =data1.adminListTemp;
                                            console.log("adminListTemp=" + adminListTemp);
                                            var result_html1 = '<table class="table table-striped">'
                                                    + '<caption>客户经理列表</caption>'
                                                    + '<thead>'
                                                    + '<tr>'
                                                    + '<th>姓名</th>'
                                                    + '<th>登入名</th>'
                                                    + '<th>工号</th>'
                                                    + '<th>直接提成</th>'
                                                    + '<th>工作状态</th>'
                                                    + '<th>间接提成</th>'
                                                    + '</tr>'
                                                    + '</thead>'
                                                    + '<tbody>';

                                            for (var i = 0; i < adminListTemp.length; i++) {
                                                result_html1 = result_html1 + '<tr class="success<%--warning  danger active--%>">'
                                                        + '<td>' + adminListTemp[i].name + '</td>'
                                                        + '<td>' + adminListTemp[i].userName + '</td>'
                                                        + '<td>' + adminListTemp[i].code + '</td>'
                                                        + '<td>' + adminListTemp[i].sellRate + '</td>'
                                                        + '<td>' + adminListTemp[i].status + '</td>'
                                                        + '<td>' + adminListTemp[i].childSellRate + '</td>'
                                                        + '<td>'
                                                        + '<button class="btn btn-warning" onclick="Edit(' + adminListTemp[i].id + ' );">修改</button>'
                                                        + '<button class="btn btn-warning" onclick="Delete(' + adminListTemp[i].id + ' );">修改</button>'
                                                        + '</td>'
                                                        + '</tr> ';
                                            }
                                            result_html1 += '</tbody>' + '</table>';
                                            $("#list").html("").fadeOut();
                                            $("#list").html(result_html1).fadeIn();
                                            console.log(result_html1);
                                            //$("#list").append(result_html1);

                                        }
                                    }
                                })
                            }
                        }

                        $('#example').bootstrapPaginator(options);
                    }

                }
                // success end
            });
        }


    </script>
</head>

<body>
<div class="span12">
    <label>客户经理列表</label>
    <br>
    <hr/>
    <div id="list"></div>
    <div id="example"></div>
</div>
<%--测试table--%>
<table class="table">
    <caption>客户经理列表</caption>
    <thead>
    <tr>
        <th>产品</th>
        <th>付款日期</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr class="active">
        <td>产品1</td>
        <td>23/11/2013</td>
        <td>待发货</td>
    </tr>
    <tr class="success">
        <td>产品2</td>
        <td>10/11/2013</td>
        <td>发货中</td>
    </tr>
    <tr class="warning">
        <td>产品3</td>
        <td>20/10/2013</td>
        <td>待确认</td>
    </tr>
    <tr class="danger">
        <td>产品4</td>
        <td>20/10/2013</td>
        <td>已退货</td>
    </tr>
    </tbody>
</table>
<%--实战table--%>
<c:forEach items="${adminList}" var="item">
    <ul>
        <span class="username"> ${item.userName } </span>
        <li style="width:10.66666666666667%; color:#BD45C0">${item.name} </li>
    </ul>
</c:forEach>
<div class="table-responsive">
    <table class="table">
        <caption>客户经理列表</caption>
        <thead>
        <tr>
            <th>姓名</th>
            <th>登入名</th>
            <th>工号</th>
            <th>直接提成</th>
            <th>工作状态</th>
            <th>间接提成</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${adminList}" var="item">
            <tr class="success<%--warning  danger active--%>">
                <td>${item.name}</td>
                <td>${item.userName}</td>
                <td>${item.code}</td>
                <td>${item.sellRate}</td>
                <td>${item.status}</td>
                <td>${item.childSellRate}</td>
            </tr>
        </c:forEach>

        </tbody>

    </table>
    <div class="span12">
        <ul id="pager1" class="pagination">
            <li><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">&laquo;</a></li>
        </ul>
        <ul class="pager">
            <il class="previous"><a href="#">&larr; 上一页</a></il>
            <il class="next"><a href="#">下一页 &rarr;</a></il>
        </ul>
    </div>
</div>


</body>
</html>