package com.hiveview.service.bluray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.bluray.HdSubjectContentDao;
import com.hiveview.entity.bluray.HdSubjectContent;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;

@Service
public class HdSubjectContentService {
	
	@Autowired
	private HdSubjectContentDao hdSubjectContentDao;
	
	/** 添加 **/
	public int save(HdSubjectContent hdsubjectcontent){
		//判断是否已经存在
		HdSubjectContent temp = hdSubjectContentDao.get(hdsubjectcontent);
		if(temp == null){
			return hdSubjectContentDao.save(hdsubjectcontent);
		}else{
			return -1;
		}
	}
	
	/** 修改 **/
	public int update(HdSubjectContent hdsubjectcontent){
		return hdSubjectContentDao.update(hdsubjectcontent);
	}
	
	/** 删除 **/
	public int delete(HdSubjectContent hdsubjectcontent){
		return hdSubjectContentDao.delete(hdsubjectcontent);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(HdSubjectContent hdsubjectcontent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subjectId",hdsubjectcontent.getSubjectId());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<HdSubjectContent> rows = hdSubjectContentDao.getList(map);
		scriptPage.setRows(rows);
		int total = hdSubjectContentDao.getCount(hdsubjectcontent);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
