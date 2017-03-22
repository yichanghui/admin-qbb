package com.hiveview.dao.client;

import java.util.List;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.client.DeviceLog;

public interface DeviceLogDao extends BaseDao<DeviceLog>{
	
	/**
	 * 批量保存“分配设备”信息
	 * @param deviceLogs
	 * @return
	 */
	public int batchSave(List<DeviceLog> deviceLogs);
}
