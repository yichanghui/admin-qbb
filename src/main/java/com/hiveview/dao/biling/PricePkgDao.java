package com.hiveview.dao.biling;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.biling.PricePkg;
import com.hiveview.entity.vo.biling.PricePkgVo;

public interface PricePkgDao extends BaseDao<PricePkg>{
	
	public List<PricePkgVo> getListByPage(PricePkg pricepkg);
	
}
