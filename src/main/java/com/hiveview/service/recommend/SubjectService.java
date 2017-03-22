package com.hiveview.service.recommend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.recommend.SubjectDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	/** 添加 **/
	public int save(Subject subject){
		return subjectDao.save(subject);
	}
	
	/** 修改 **/
	public int update(Subject subject){
		return subjectDao.update(subject);
	}
	
	/** 删除 **/
	public int delete(Subject subject){
		return subjectDao.delete(subject);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(Subject subject,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subject",subject);
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<Subject> rows = subjectDao.getList(map);
		scriptPage.setRows(rows);
		int total = subjectDao.getCount(map);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
