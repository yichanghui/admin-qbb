package com.hiveview.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.client.CpChannelTvDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.client.CpChannelTv;
import com.hiveview.entity.vo.client.CpChannelTvVo;

@Service
public class CpChannelTvService {
	
	@Autowired
	private CpChannelTvDao cpChannelTvDao;
	
	/** 添加 **/
	public int save(CpChannelTv cpchanneltv){
		if(!validate(cpchanneltv)){
			return cpChannelTvDao.save(cpchanneltv);
		}else{
			return -1;
		}
	}
	
	/** 修改 **/
	public int update(CpChannelTv cpchanneltv){
		return cpChannelTvDao.update(cpchanneltv);
	}
	
	/** 删除 **/
	public int delete(CpChannelTv cpchanneltv){
		return cpChannelTvDao.delete(cpchanneltv);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(CpChannelTv cpchanneltv,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		cpchanneltv.setPageIndex(ajaxPage.getSkipNo());
		cpchanneltv.setPageSize(ajaxPage.getPageSize());
		List<CpChannelTvVo> rows = cpChannelTvDao.getCpChannelTvByPage(cpchanneltv);
		scriptPage.setRows(rows);
		int total = cpChannelTvDao.getCount(cpchanneltv);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	/**
	 * 验证cpChannnel关联的TV是否已经存在
	 * @param tv
	 * @return true存在  false不存在
	 */
	public Boolean validate(CpChannelTv cpchanneltv){
		Boolean flag = true;
		CpChannelTv channelTv = cpChannelTvDao.get(cpchanneltv);
		if(channelTv == null){
			flag = false;
		}
		return flag;
	}
}
