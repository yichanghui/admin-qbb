package com.hiveview.dao.client;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.client.CpChannelTv;
import com.hiveview.entity.vo.client.CpChannelTvVo;

public interface CpChannelTvDao extends BaseDao<CpChannelTv>{
	
	public List<CpChannelTvVo> getCpChannelTvByPage(CpChannelTv channelTv);
}
