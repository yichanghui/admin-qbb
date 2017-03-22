<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中讯担保</title>
<jsp:include page="../jsp_css/commoncss.jsp"></jsp:include>
<script type="text/javascript" src="js/common/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/common/jquery/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<jsp:include page="../jsp/common/top.jsp" />
	<jsp:include page="../jsp/common/left.jsp" />
	<jsp:include page="../jsp/common/bottom.jsp" />
	<div data-options="region:'center'" class="regionCenter">
	<iframe id="centerIframe" src="welcome.html" FRAMEBORDER=0 SCROLLING=NO style="margin:0px;padding:0px;width:100%;height:99.5%;overflow:hidden;">
	</iframe>
	</div>
</body>
</html>