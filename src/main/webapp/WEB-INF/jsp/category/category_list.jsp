<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE HTML>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/global.jsp" %>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="Shortcut Icon" href="/favicon.ico" />
	<style>
		.color1{color:#FF5722}
		.color2{color:#F7B824}
		.color3{color:#5FB878}
	</style>
	<![endif]-->
	<jsp:include page="../common/static.jsp"></jsp:include>
	<![endif]-->
	<title>类目管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 类目管理 <span class="c-gray en">&gt;</span> 类目列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<form class="layui-form" action="" >
				<div class="layui-inline">
					<label class="layui-form-label">类目名称</label>
					<div class="layui-input-inline">
						<input type="text" name="categoryName" id="categoryName" class="layui-input">
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">类目级别</label>
						<div class="layui-input-inline">
							<select  lay-filter="statusSearch" name="categoryLevel" id="categoryLevel">
								<option value="-1">全部</option>
								<option value="1" >一级类目</option>
								<option value="2" >二级类目</option>
								<option value="3" >三级类目</option>
							</select>
						</div>
					</div>
				</div>
			<button type="button"  class="btn btn-success"  id="search" ><i class="Hui-iconfont">&#xe665;</i>搜索</button>
			<button type="button"  class="btn btn-success" name="addCategory" level="1" >添加一级类目</button>
			<%--<button type="button"  class="btn btn-success" name="addCategory" level="2" >添加二级类目</button>--%>
			<%--<button type="button"  class="btn btn-success" name="addCategory" level="3" >添加三级类目</button>--%>
		</div>
		<%--<div class="layui-input-block">--%>
		<%--<button class="layui-btn" lay-submit="" lay-filter="demo1" >搜索</button>--%>
		<%--</div>--%>
		</form>
	<div id="dataMsg"></div>
	<div id="categoryPager"></div>
</div>
</div>
<!--_footer 作为公共模版分离出去-->
<jsp:include page="../common/static-js.jsp"></jsp:include>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">


	$(function () {
		layui.use(['form', 'laypage', 'layer'], function () {
			var laypage = layui.laypage
					, layer = layui.layer;

			var form = layui.form()
					, layedit = layui.layedit
					, laydate = layui.laydate;
			//以下将以jquery.ajax为例，演示一个异步分页
			var pageSize = 15;

			function paging(curr) {
				var categoryLevel = $("#categoryLevel").val();
				categoryLevel = categoryLevel == -1 ? "" : categoryLevel;
				$.ajax({
					type: "POST",
					url: "/category/page.html",
					data: {
						categoryLevel: categoryLevel,
						categoryName: $("#categoryName").val(),
						currentPage: curr || 1,
						pageSize: pageSize
					},
					success: function (data) {
						$("#dataMsg").html(data);
						var totalPages = $("#totalPages").val();
						//显示分页
						laypage({
							cont: 'categoryPager', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
							pages: totalPages, //通过后台拿到的总页数
							curr: curr || 1, //当前页
							groups: 5,//连续显示分页数
							jump: function (obj, first) { //触发分页后的回调
								if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
									paging(obj.curr);
								}
							}
						});
					}
				});
			};
			//运行
			paging();
			$("#search").click(function () {
				paging();
			});
		});

		$("button[name='addCategory']").click(function () {
			admin_edit('新建类目', '/category/toAdd/0.html', '1', '800', '500');
		});
	});







	/*
	 参数解释：
	 title	标题
	 url		请求的url
	 id		需要操作的数据id
	 w		弹出层宽度（缺省调默认值）
	 h		弹出层高度（缺省调默认值）
	 */
	/*管理员-增加*/
	function admin_add(title,url,w,h){
		layer_show(title,url,w,h);
	}
	/*管理员-删除*/
	function admin_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});
		});
	}

	/*管理员-编辑*/
	function admin_edit(title,url,id,w,h){
		layer_show(title,url,w,h);
	}
	/*管理员-停用*/
	function admin_stop(obj,id){
		layer.confirm('确认要停用吗？',function(index){
			//此处请求后台程序，下方是成功后的前台处理……

			$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
			$(obj).remove();
			layer.msg('已停用!',{icon: 5,time:1000});
		});
	}

	/*管理员-启用*/
	function admin_start(obj,id){
		layer.confirm('确认要启用吗？',function(index){
			//此处请求后台程序，下方是成功后的前台处理……


			$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
			$(obj).remove();
			layer.msg('已启用!', {icon: 6,time:1000});
		});
	}
</script>
</body>
</html>