package com.hiveview.service.recommend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.recommend.SubjectContentDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.SubjectContent;

@Service
public class SubjectContentService {
	
	@Autowired
	private SubjectContentDao SubjectContentDao;
	
	/** 添加 **/
	public int save(SubjectContent subjectcontent){
		//判断是否已经存在
		SubjectContent temp = SubjectContentDao.get(subjectcontent);
		if(temp == null){
			return SubjectContentDao.save(subjectcontent);
		}else{
			return -1;
		}
	}
	
	/** 修改 **/
	public int update(SubjectContent subjectcontent){
		return SubjectContentDao.update(subjectcontent);
	}
	
	/** 删除 **/
	public int delete(SubjectContent subjectcontent){
		return SubjectContentDao.delete(subjectcontent);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(SubjectContent subjectContent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subjectContent",subjectContent);
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<SubjectContent> rows = SubjectContentDao.getList(map);
		scriptPage.setRows(rows);
		int total = SubjectContentDao.getCount(map);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
