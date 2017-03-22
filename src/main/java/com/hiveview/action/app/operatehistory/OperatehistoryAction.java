package com.hiveview.action.app.operatehistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.app.AppOperateHistory;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.operatehistory.OperatehistoryService;

@Controller
@RequestMapping("/operatehistory")
public class OperatehistoryAction{

	@Autowired
	private OperatehistoryService operatehistoryService;
	
	@RequestMapping(value="/getAppOperateHistoryList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAppOperateHistoryList(AppOperateHistory history,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		try {
			scriptPage.setRows(operatehistoryService.getAppOperateHistoryList(history, pageAjax.getSkipNo(), pageAjax.getPageSize()));
			scriptPage.setTotal(operatehistoryService.getCount(history));
			return scriptPage;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			scriptPage.setMsg(e.getMessage());
			return scriptPage;
		}
	}
}
