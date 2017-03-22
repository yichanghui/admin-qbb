package com.hiveview.dao.client;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.client.Hardware;
import com.hiveview.entity.vo.client.HardwareVo;

public interface HardwareDao extends BaseDao<Hardware>{
	
	public Hardware getByHardwareNo(Hardware hardware);
	
	public List<HardwareVo> getInfoList(Hardware hardware);
}
