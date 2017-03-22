package com.hiveview.dao.app.app;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.app.app.AppSubjectContent;
import com.hiveview.entity.vo.app.AppSubjectContentVo;

public interface AppSubjectContentDao extends BaseDao<AppSubjectContent>{
	
	/**
	 * 查询专题内容详情，包含应用详情
	 * @param appSubjectContent
	 * @return
	 */
	public List<AppSubjectContentVo> getInfoList(AppSubjectContent appSubjectContent);
}
