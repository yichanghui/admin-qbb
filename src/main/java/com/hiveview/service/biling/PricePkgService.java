package com.hiveview.service.biling;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.biling.PricePkgDao;
import com.hiveview.entity.biling.PricePkg;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.biling.PricePkgVo;
import com.hiveview.util.DateUtil;

@Service
public class PricePkgService {
	
	@Autowired
	private PricePkgDao pricePkgDao;
	
	/** 添加 **/
	public int save(PricePkg pricepkg){
		pricepkg.setCtime(DateUtil.getTimeStamp(new Date()));
		pricepkg.setUtime(DateUtil.getTimeStamp(new Date()));
		return pricePkgDao.save(pricepkg);
	}
	
	/** 修改 **/
	public int update(PricePkg pricepkg){
		pricepkg.setUtime(DateUtil.getTimeStamp(new Date()));
		return pricePkgDao.update(pricepkg);
	}
	
	/** 删除 **/
	public int delete(PricePkg pricepkg){
		return pricePkgDao.delete(pricepkg);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(PricePkg pricepkg){
		ScriptPage scriptPage = new ScriptPage();
		List<PricePkgVo> PricePkgVos = pricePkgDao.getListByPage(pricepkg);
		scriptPage.setRows(PricePkgVos);
		int total = pricePkgDao.getCount(pricepkg);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
