<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蜂巢TV内容管理云平台</title>
<jsp:include page="../../jsp_css/commoncss.jsp"></jsp:include>
<script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/common/jquery/jquery.easyui.min.js"></script>
<!-- 页面相关JS -->
<script type="text/javascript" src="js/recommend/appfocus_list.js"></script>
<body  class="easyui-layout">
<div data-options="region:'center',title:'应用推荐'" class="regionCenter">
	<div id="common_search" class="common_search">
	<input type="button" id="btn_add" class="btn btn-success" value="添加">
	<select id="recommendType"><option value=1>游戏推荐</option><option value=5>软件推荐</option></select>
	</div>
	<table id="detail_table"></table>
</div>
	<div id="detail_dialog" data-options="closed:true,modal:true,title:'appfocus'" style="padding:1px;width:850px;height:500px;">
	<form action="" id="detail_form" style="display:block;float:left;width:280px;">
	<input type="hidden" id="id"/>
	<table>
			<tr>	
				<td>变化时间：</td>	
				<td><input type="text" value="5000" id="intervalTime"></td>
			</tr>
			<tr>	
				<td>位置：</td>	
				<td><input type="text" id="position"></td>
			</tr>
			<tr>	
				<td>顺序：</td>	
				<td><input type="text" id="seq"></td>
			</tr>
			<tr>	
				<td>名称：</td>	
				<td><input type="text" id="contentName"></td>
			</tr>
			<tr>	
				<td>描述：</td>	
				<td><input type="text" id="contentDesc"></td>
			</tr>
			<tr>	
				<td>状态：</td>	
				<td><select id="isEffective"><option value=1>有效</option><option value=0>无效</option></select></td>
			</tr>
			<tr>	
				<td>焦点图：</td>	
				<td><span id="focusLargeImg_span"></span>
				<input type="button" id="browse_uploadify_large" value="浏览" class="btn btn-inverse"><input type="file" class="fileCommon">
				<span id="appFocusLargeImgUpload" style="display:none;"><img src="images/uploading.gif"></span>
				</td>
			</tr>
			<tr>	
				<td>缩略图：</td>
				<td><span id="focusThumbImg_span"></span>
				<input type="button" id="browse_uploadify_thumb" value="浏览" class="btn btn-inverse"><input type="file" class="fileCommon">
				<span id="appFocusThumbImgUpload" style="display:none;"><img src="images/uploading.gif"></span></td>
			</tr>
	</table>
	</form>
	<div style="float:left;width:550px;height:420px;">
	<div id="common_app_search" class="common_search">
	<select id="contentType"><option value=1003>应用推荐</option><option value=1004>应用专题推荐</option></select>
	<select id="category"></select>
	</div>
	<table id="tableData"></table></div>
	<div class="clearBoth"></div>
    </div>
<script type="text/javascript" src="js/common/jquery/jquery.ajaxupload.js"></script>
<script type="text/javascript" src="js/common/common_function.js"></script>
</body>
</html>