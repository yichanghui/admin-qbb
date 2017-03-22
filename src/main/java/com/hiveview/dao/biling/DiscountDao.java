package com.hiveview.dao.biling;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.biling.Discount;
import com.hiveview.entity.vo.biling.DiscountVo;

public interface DiscountDao extends BaseDao<Discount> {
	
	public Discount getByDiscountName(Discount discount);
	
	public List<DiscountVo> getInfoList(Discount discount);
	
}
