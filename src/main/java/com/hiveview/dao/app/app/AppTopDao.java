package com.hiveview.dao.app.app;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.app.app.AppTop;
import com.hiveview.entity.vo.app.AppTopVo;

public interface AppTopDao extends BaseDao<AppTop>{
	
	public List<AppTopVo> getAppTopList(AppTop appTop);
	
}
