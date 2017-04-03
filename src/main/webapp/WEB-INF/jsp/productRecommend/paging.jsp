<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<table class="table table-border table-bordered table-bg">
    <thead>
    <tr>
        <th scope="col" colspan="9">产品推荐列表</th>
    </tr>
    <tr class="text-c">
        <%--<th width="25"><input type="checkbox" name="" value=""></th>--%>
        <%--<th width="40">ID</th>--%>
        <th>产品标题</th>
        <th>类目</th>
        <th>操作人</th>
        <th>状态</th>
        <th>推荐时间</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product" >
    <tr class="text-c">
        <%--<td><input type="checkbox" value="1" name=""></td>--%>
        <%--<td>1</td>--%>
            <td>${product.productName}</td>
            <td>${product.categoryName}</td>
            <td>${product.userName}</td>
            <td >
                <c:if test="${product.status == 1}">
                    有效
                </c:if>
            </td>
            <td> <fmt:formatDate value="${product.updateTime != null ? product.updateTime:product.addTime}"   pattern="yyyy-MM-dd HH:mm:ss" type="date" dateStyle="long" /></td>
        <td class="td-manage">
            <a title="删除" href="javascript:;" name="delete" id="${product.id}" class="ml-5" style="text-decoration:none">
                <i class="Hui-iconfont">&#xe6df;</i></a>
        </td>
    </tr>
    </c:forEach>
    <c:if test="${empty products}">
        <tr>
            <td colspan="6" style="text-align: center;">暂无推荐产品！</td>
        </tr>
    </c:if>
    </tbody>
</table>

   <input type="hidden" id="totalPages" value="${paging.totalPages}"/>
   <input type="hidden" id="currentPage" value="${paging.currentPage}"/>
<script type="text/javascript">
    $(function () {
        $("a[name='delete']").click(function() {
            var thisObj = $(this);
            var id = thisObj.attr("id");
            layer.confirm("您确定要删除吗？", {
                btn: ['确定','取消'] //按钮
            }, function(index){
                $.ajax({
                    type: "POST",
                    url: "/productRecommend/delete.json",
                    data: {recommendId:id},
                    dataType: "json",
                    success: function(data){
                        layer.close(index);
                        if(data) {
                            thisObj.parents("tr").remove();
//                            location.reload();
                        }else {
                            layer.msg("操作失败！");
                        }
                    }
                });
            }, function(index){
//                 layer.close(index);
            });
        });
    });
</script> 