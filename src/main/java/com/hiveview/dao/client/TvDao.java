package com.hiveview.dao.client;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bo.client.CpChannelTvBo;
import com.hiveview.entity.client.Tv;

public interface TvDao extends BaseDao<Tv>{
	
	/**
	 * 查询未与当前渠道关联的电视台列表
	 * @param tvBo
	 * @return
	 */
	List<Tv> getUnselectList(CpChannelTvBo tvBo);
	/**
	 * 查询未与当前渠道关联的电视台数量
	 * @param tvBo
	 * @return
	 */
	Integer getUnselectCount(CpChannelTvBo tvBo);
}
