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
<title>焦点图管理</title>
<jsp:include page="../../jsp_css/commoncss.jsp"></jsp:include>
<script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/common/jquery/jquery.easyui.min.js"></script>
<body  class="easyui-layout">
<%-- center列表--%>
<div data-options="region:'center',title:'焦点图管理'" class="regionCenter">
	<div id="common_search" class="common_search">
	<input type="button" id="btn_add" class="btn btn-success" value="添加">
	</div>
	<table id="detail_table"></table>
</div>
	<div id="detail_dialog" data-options="closed:true,modal:true,title:'焦点图设置'" 
			style="padding:3px;width:930px;height: 520px;">
	<form action="" id="detail_form">
	<input type="hidden" id="id">
	<table style="width:100%">
		<tr>
			<%--左侧信息栏 --%>
			<td style="width:240px;">
				<table style="height:340px;">
						<tr>	
							<td style="width:140px;">变化时间：</td>	
							<td><input type="text" id="intervalTime" value="5000" placeholder="单位为毫秒" class="easyui-numberbox"></td>
						</tr>
						<tr>	
							<td>位置：</td>	
							<td><input type="text" id="position" class="easyui-numberbox"></td>
						</tr>
						<tr>	
							<td>顺序：</td>	
							<td><input type="text" id="seq" class="easyui-numberbox"></td>
						</tr>
						<tr>	
							<td>名称：</td>	
							<td><input type="text" id="contentName" readonly><input type="hidden" id="contentId"></td>
						</tr>
						<tr>	
							<td>描述：</td>	
							<td><textarea id="contentDesc" style="width: 140px;height:50px;" maxlength="200"></textarea></td>
						</tr>
						<tr>	
							<td>大图：</td>	
							<td>
								<img alt="" id="focusLargeImg_url" style="width: 80px;height: 80px;"/>
								<input type="hidden" id="focusLargeImg" readonly class="uploadify_input"/>
								<span class="spanUpload"><input type="button" id="filePath_add_uploadify_large" value="浏览" class="btn btn-inverse">
								<input type="file" class="fileCommon"></span><span style="color:red">1027×577</span>
							</td>
						</tr>
						<tr>	
							<td>缩略图：</td>	
							<td>
								<img alt="" id="focusThumbImg_url" style="width: 80px;height: 80px;"/>
								<input type="hidden" id="focusThumbImg" readonly class="uploadify_input"/>
								<span class="spanUpload"><input type="button" id="filePath_add_uploadify_thumb" value="浏览" class="btn btn-inverse">
								<input type="file" class="fileCommon"></span><span style="color:red">198×112</span>
							</td>
						</tr>
						<tr>	
							<td>状态：</td>	
							<td><select id="isEffective">
								<option value="1">上线</option>
								<option value="0">下线</option>
							</select>
						</tr>
				</table>
			</td>
			<%--右侧数据列表 --%>
			<td>
				<%-- 内容展示--%>
				<div id="content_search" class="common_search">
					<select id="contentType"></select>
					<select id="categoryId" style="display:none;"></select>
					<input type="text" id="content" class="text" placeholder="输入搜索内容">
					<input type="button" id="btn_search" class="btn btn-success" value="搜索">
				</div>
				<table id="info_table"></table>
			</td>
		</tr>
	</table>
	</form>
	</div>
<%-- east图片展示区--%>
<div id="photo_div" data-options="region:'east',split:true,collapsed:false,title:'图片'" style="width:350px;padding:1px;">
<div id="showLarge"></div>
<div id="showThumb"></div></div>
<script type="text/javascript" src="js/common/jquery/jquery.ajaxupload.js"></script>
<!-- 页面相关JS -->
<script type="text/javascript" src="js/recommend/focus_list.js"></script>
</body>
</html>