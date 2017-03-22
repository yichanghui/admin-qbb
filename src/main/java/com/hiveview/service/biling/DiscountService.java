package com.hiveview.service.biling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.biling.DiscountDao;
import com.hiveview.entity.biling.Discount;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.biling.DiscountVo;

@Service
public class DiscountService {
	
	@Autowired
	private DiscountDao discountDao;
	
	
	/** 添加 **/
	public int save(Discount discount){
		if(!validateDiscount(discount)){
			int num = discountDao.save(discount);
			return num;
		}else {
			return -1;
		}
	}
	
	/** 修改 **/
	public int update(Discount discount){
		return discountDao.update(discount);
	}
	
	/** 删除 **/
	public int delete(Discount discount){
		return discountDao.delete(discount);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(Discount discount,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		discount.setPageIndex(ajaxPage.getSkipNo());
		discount.setPageSize(ajaxPage.getPageSize());
		List<DiscountVo> rows = discountDao.getInfoList(discount);
		scriptPage.setRows(rows);
		int total = discountDao.getCount(discount);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	
	/**
	 * 验证折扣名称是否已经存在
	 * @param discount
	 * @return true 存在
	 */
	public boolean validateDiscount(Discount discount){
		Discount temp = discountDao.getByDiscountName(discount);
		if(temp==null){
			return false;
		}else{
			return true;
		}
	}
	
	
}
