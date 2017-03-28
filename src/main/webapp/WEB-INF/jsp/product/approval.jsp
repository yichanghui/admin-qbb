<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/global.jsp" %>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>企巴巴</title>
    <link rel="stylesheet" href="../css/buysell.css">
    <link rel="stylesheet" href="../plugins/layui/css/global.css">
    <style>
        .memver_c{margin-top: 15px;margin-bottom: 15px;}
        .c_left{width: 210px;float:left;}
        .member_menu{border: 1px solid #EEE;}
        .member_menu li{width: 100%;height:35px;line-height:35px;border-bottom: 1px solid #eee;}
        .member_menu li a{margin-left:20px;}
        .gonggao_title{margin: 15px 5px;}
        .gonggao{border: 1px solid #EEE;}
        .gonggao li{width: 100%;height:45px;line-height:45px;border-bottom: 1px solid #eee;}
        .gonggao li a{margin-left: 15px;}
        .c_right{margin-left:10px;width: 958px;float: left;}
        .site-demo-upload, .site-demo-upload img{border-radius:0;}
    </style>
</head>
<body>
<div id="container">
    <div class="content memver_c">

        <div class="c_right">
            <form class="layui-form" action="" id="dataForm">
                <input type="hidden" name="id" value="${productId}">
                <div class="layui-form-item">
                    <label class="layui-form-label">产品状态</label>
                    <div class="layui-input-inline">
                        <select  lay-filter="statusSearch" name="status" id="statusSearch">
                            <option value="-1">请选择</option>
                            <option value="4" >批准</option>
                            <option value="5" >驳回</option>
                            <option value="7" >关闭</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">确定</button>
                    </div>
                </div>
            </form>

        </div>
        <div class="clear"></div>
    </div>
</div>
<script src="../plugins/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form()
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

        //监听提交
        form.on('submit(demo1)', function(data){
            $.ajax({
                type: "POST",
                url: "/product/operation.json",
                data: $("#dataForm").serialize(),
                dataType: "json",
                async:false,
                success: function (data) {
                    if (data) {
//                        parent.layer.closeAll();
                        parent.location.reload();
                    } else {
                        layer.msg("发布失败！");
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
