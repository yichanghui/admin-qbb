package com.hiveview.service.bluray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.bluray.HdSubjectDao;
import com.hiveview.entity.bluray.HdSubject;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;

@Service
public class HdSubjectService {
	
	@Autowired
	private HdSubjectDao hdSubjectDao;
	
	/** 添加 **/
	public int save(HdSubject hdsubject){
		return hdSubjectDao.save(hdsubject);
	}
	
	/** 修改 **/
	public int update(HdSubject hdsubject){
		return hdSubjectDao.update(hdsubject);
	}
	
	/** 删除 **/
	public int delete(HdSubject hdsubject){
		return hdSubjectDao.delete(hdsubject);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(HdSubject hdsubject,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subjectName",hdsubject.getSubjectName());
		map.put("isEffective",hdsubject.getIsEffective());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<HdSubject> rows = hdSubjectDao.getList(map);
		scriptPage.setRows(rows);
		int total = hdSubjectDao.getCount(hdsubject);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
