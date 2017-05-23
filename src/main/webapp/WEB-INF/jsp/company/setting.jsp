<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/global.jsp" %>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>企巴巴</title>
    <!-- <link rel="stylesheet" href="../css/buysell.css"> -->
    <link rel="stylesheet" href="../plugins/layui/css/global.css">
    <style>
        .memver_c{margin-top: 15px;margin-bottom: 15px;}
        .member_menu li{width: 100%;height:35px;line-height:35px;border-bottom: 1px solid #eee;}
        .member_menu li a{margin-left:20px;}
        .gonggao li{width: 100%;height:45px;line-height:45px;border-bottom: 1px solid #eee;}
        .gonggao li a{margin-left: 15px;}
        .site-demo-upload, .site-demo-upload img{border-radius:0;}
    </style>
</head>
<body>
<div id="container">
            <form class="layui-form" action="" id="dataForm">
                <input type="hidden"  name="id" value="${company.id}">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">公司名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="companyName" value="${company.companyName}" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">公司区域</label>
                    <div class="layui-input-inline">
                        <select name="areaId" id="areaselect">
                        	<c:forEach items="${areas}" var="area" >
                        		 <option value="${area.id }">${area.fullName }</option>
                        	</c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
				<label class="layui-form-label">具体地址</label>
				<div class="layui-input-block">
					<textarea name="address" style="width: 80%" placeholder="请输入内容" class="layui-textarea">${company.address}</textarea>
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">一句话简介</label>
				<div class="layui-input-block">
					<textarea name="summary" style="width: 80%" placeholder="请输入内容" class="layui-textarea">${company.summary}</textarea>
				</div>
			</div>
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">公司介绍</label>
				<div class="layui-input-block">
					<textarea name="introduce" style="width: 80%" placeholder="请输入内容" class="layui-textarea">${company.introduce}</textarea>
				</div>
			</div>
			<div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">确定</button>
                    </div>
                </div>
            </form>
            <div id="dataMsg"></div>
            <div id="memberPager"></div>
</div>
<script src="../plugins/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate','laypage'], function(){
        var form = layui.form()
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;
        var laypage = layui.laypage;

        //监听提交
        form.on('submit(demo1)', function(data){
            $.ajax({
                type: "POST",
                url: "/company/operation.json",
                data: $("#dataForm").serialize(),
                dataType: "json",
                success: function (data) {
                    if (data) {
                        parent.layer.closeAll();
                    } else {
                        layer.msg("失败！");
                    }
                }
            });
            return false;
        });

//        form.on('select', function(data){
//            var selectVal = data.value;
//            $("#status").val(selectVal)
//        });
    });
    /*
    *选中到地区列表
    **/
    
</script>
<script type="text/javascript">
	$(function(){
		$("#areaselect").val(${company.areaId});
	});
</script>
</body>
</html>
