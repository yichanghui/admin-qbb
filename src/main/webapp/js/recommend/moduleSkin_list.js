//
var recomTypeArray = new Array();
recomTypeArray[1]="游戏";
recomTypeArray[2]="电视";
recomTypeArray[3]="推荐";
recomTypeArray[4]="影院";
recomTypeArray[5]="应用";
recomTypeArray[6]="2.0设置";
recomTypeArray[7]="蓝光极清";
recomTypeArray[8]="1.0设置";
var flagUpdate = true;
var parameter = {};
$(function(){
	$("#recomType").html("");
	for(var i=1;i<recomTypeArray.length;i++)
		$("#recomType").append('<option value='+i+'>'+recomTypeArray[i]+'</option');
	//init dataGridTable
	initDataGrid();
	//init dialog
	$('#detail_dialog').dialog({
		buttons:[{
			text:'确 定',
			handler:function(){
				submitModel();
			}
		},{
			text:'取消',
			handler:function(){
				dialogClose();
			}
		}]
	});
	//open add dialog
	$('#btn_add').click(function(){
		//clear default values
		$('#imgUrlInside_show').attr("src","");
		$('#imgUrlOutside_show').attr("src","");
		flagUpdate=false;
		$('#detail_form')[0].reset();
		$('#recomType').show();
		dialogOpen();
	});
	
	   _initFileUpload("uploadify_imgUrlInside",{
	   		data:{imgName:"wallPaperPath"},
	        onComplete: function (file, response) {//文件提交完成后可执行的方法
        	var imgUrl=ParseTextToJsonObject(response);
        	$("#imgUrlInside").val(imgUrl);
        	$("#imgUrlInside_show").attr("src",imgUrl);
        	$("#uploadFlag").val("");
        	$("#imgUrlInside_loading").hide();
        },
        onSubmit:function(file, extension){
        	if (extension && /^(jpg|png|jpeg|gif)$/.test(extension)){
	    		$("#imgUrlInside_loading").show();
	    		$("#uploadFlag").val("uploading");
	    	}else{
	    		$.messager.alert(titleInfo, "非图片类型文件，请重传");
	    		return false;
	    	}
        }
	 });
	   
	   _initFileUpload("uploadify_imgUrlOutside",{
	   		data:{imgName:"wallPaperPath"},
	        onComplete: function (file, response) {//文件提交完成后可执行的方法
        	var imgUrl=ParseTextToJsonObject(response);
        	$("#imgUrlOutside").val(imgUrl);
        	$("#imgUrlOutside_show").attr("src",imgUrl);
        	$("#uploadFlag").val("");
        	$("#imgUrlOutside_loading").hide();
        },
        onSubmit:function(file, extension){
        	if (extension && /^(jpg|png|jpeg|gif)$/.test(extension)){
	    		$("#imgUrlOutside_loading").show();
	    		$("#uploadFlag").val("uploading");
	    	}else{
	    		$.messager.alert(titleInfo, "非图片类型文件，请重传");
	    		return false;
	    	}
        }
	 });
//	new AjaxUpload($('#uploadify_imgUrlInside'), {//绑定AjaxUpload
//        action: "fileUpload/upload.html",//文件要上传到的处理页面,语言可以PHP,ASP,JSP等
//        data:{"propKey":"recommendImgPath"},
//        type:"POST",//提交方式
//        autoSubmit:true,//选择文件后,是否自动提交.这里可以变成true,自己去看看效果吧.
//        onComplete: function (file, response) {//文件提交完成后可执行的方法
//        	var imgUrl=ParseTextToJsonObject(response);
//        	$("#imgUrlInside").val(imgUrl);
//        	$("#imgUrlInside_show").attr("src",imgUrl);
//        	$("#uploadFlag").val("");
//        	$("#imgUrlInside_loading").hide();
//        },
//        onSubmit:function(file, extension){
//        	if (extension && /^(jpg|png|jpeg|gif)$/.test(extension)){
//	    		$("#imgUrlInside_loading").show();
//	    		$("#uploadFlag").val("uploading");
//	    	}else{
//	    		$.messager.alert(titleInfo, "非图片类型文件，请重传");
//	    		return false;
//	    	}
//        }
//    });
	
//	new AjaxUpload($('#uploadify_imgUrlOutside'), {//绑定AjaxUpload
//        action: "fileUpload/upload.html",//文件要上传到的处理页面,语言可以PHP,ASP,JSP等
//        data:{"propKey":"recommendImgPath"},
//        type:"POST",//提交方式
//        autoSubmit:true,//选择文件后,是否自动提交.这里可以变成true,自己去看看效果吧.
//        onComplete: function (file, response) {//文件提交完成后可执行的方法
//        	var imgUrl=ParseTextToJsonObject(response);
//        	$("#imgUrlOutside").val(imgUrl);
//        	$("#imgUrlOutside_show").attr("src",imgUrl);
//        	$("#uploadFlag").val("");
//        	$("#imgUrlOutside_loading").hide();
//        },
//        onSubmit:function(file, extension){
//        	if (extension && /^(jpg|png|jpeg|gif)$/.test(extension)){
//	    		$("#imgUrlOutside_loading").show();
//	    		$("#uploadFlag").val("uploading");
//	    	}else{
//	    		$.messager.alert(titleInfo, "非图片类型文件，请重传");
//	    		return false;
//	    	}
//        }
//    });
});
//dataGrid load data
function dataGridload(param){
	$('#detail_table').datagrid('load',param);
}
//close dialog
function dialogClose(){
	$('#detail_dialog').dialog('close');
}
//open dialog
function dialogOpen(){
	$('#detail_dialog').dialog('open');
}
//edit info
function infoEdit(id){
	$('#detail_table').datagrid('selectRecord',id);
	$('#recomType').hide();
	var rowInfo =  $('#detail_table').datagrid('getSelected');
	$('#imgUrlInside_show').attr("src","");
	$('#imgUrlOutside_show').attr("src","");
	if(id){
		flagUpdate=true;
//		$('#id').val(rowInfo.id);
		$('#recomType').val(rowInfo.recomType);
		$('#imgUrlInside').val(rowInfo.imgUrlInside);
		$('#imgUrlOutside').val(rowInfo.imgUrlOutside);
		$('#imgUrlInside_show').attr("src",rowInfo.imgUrlInside);
		$('#imgUrlOutside_show').attr("src",rowInfo.imgUrlOutside);
		dialogOpen();
	}
}
//delete
function infoDelete(){
	$.messager.confirm(titleInfo, '您确定删除吗？', function(r){
		if (r){
			var rowInfo = $('#detail_table').datagrid('getSelected');
			if(rowInfo){
				var param = {
					"recomType":rowInfo.recomType,
					recomTypeName:recomTypeArray[rowInfo.recomType]
				};
				$.post("moduleskin/delete.json",param,function(data){
					if(1==data.code){
						$('#detail_table').datagrid('reload');
						$.messager.show({title:titleInfo,msg:'删除成功！',timeout:timeoutValue,showType:'slide'});
					}else{
						$.messager.alert(titleInfo,"删除失败！");
					}
				},"json");
			}
		}
	});
}
//save or update info
function submitModel(){
	var dataInfo={
		recomType:$('#recomType').val(),
		imgUrlInside:$('#imgUrlInside').val(),
		imgUrlOutside:$('#imgUrlOutside').val(),
		recomTypeName:recomTypeArray[$('#recomType').val()]
	};
	//获取主键值，根据主键值判断添加或修改
	
	var imgUrlInside=$("#imgUrlInside_show").attr("src");
	if(HIVEVIEW.upload.isRsync(imgUrlInside)){
		_sendFileToServer("wallPaperPath",HIVEVIEW.upload.separate(imgUrlInside));
		dataInfo["imgUrlInside"]=HIVEVIEW.upload.urlCombination({
			"confUrl":HIVEVIEW.upload.conf.wallPaperPath,"showUrl":imgUrlInside
		});
	}
	
	var imgUrlOutside=$("#imgUrlOutside_show").attr("src");
	if(HIVEVIEW.upload.isRsync(imgUrlOutside)){
		_sendFileToServer("wallPaperPath",HIVEVIEW.upload.separate(imgUrlOutside));
		dataInfo["imgUrlOutside"]=HIVEVIEW.upload.urlCombination({
			"confUrl":HIVEVIEW.upload.conf.wallPaperPath,"showUrl":imgUrlOutside
		});
	}
	
	if(flagUpdate){
		$.post("moduleskin/update.json",dataInfo,function(data){
			if(1==data.code){
				$('#detail_table').datagrid('reload');
				$('#detail_dialog').dialog('close');
				$.messager.show({title:titleInfo,msg:'修改成功！',timeout:timeoutValue,showType:'slide'});
			}else{
				$.messager.alert(titleInfo,"修改失败！");
			}
		},"json");
	}else{
		$.post("moduleskin/add.json",dataInfo,function(data){
			if(1==data.code){
				$('#detail_table').datagrid('reload');
				$('#detail_dialog').dialog('close');
				$.messager.show({title:titleInfo,msg:'保存成功！',timeout:timeoutValue,showType:'slide'});
			}else if(-1==data.code){
				$.messager.alert(titleInfo,"推荐位已经存在！");
			}else{
				$.messager.alert(titleInfo,"保存失败！");
			}
		},"json");
	}
}
//init dataGridTable
function initDataGrid(){
	$('#detail_table').datagrid({
		nowrap: true,
		autoRowHeight: true,
		striped: true,
		toolbar: "#common_search",
		fit:true,
		fitColumns:true,
		collapsible:true,
		url:'moduleskin/getList.json',
		queryParams:parameter,
		remoteSort: false,
		singleSelect:true,
		idField:'recomType',
		columns:[[
{field:'recomType',title:'推荐位类型',width:80,align:"center",formatter:function(value){
	return recomTypeArray[value];
}},{field:'imgUrlOutside',title:'首屏背景',width:110,align:"center",formatter:function(value){
	return '<img src='+value+' style="height:100px;">';
}},{field:'imgUrlInside',title:'内容背景',width:110,align:"center",formatter:function(value){
	if(value=="")
		return "无图片";
	return '<img src='+value+' style="height:100px;">';
}},{field:'id',title:'操作',width:100,
				formatter:function(value,row){
					return '<a href="javascript:infoEdit('+row.recomType+')">编辑</a>'
						+ '  <a href="javascript:infoDelete('+row.recomType+')">删除</a>';
				}
			}
		]],
		pagination:true,
		rownumbers:true,
		onClickRow:function(rowIndex){
        }
	});
}