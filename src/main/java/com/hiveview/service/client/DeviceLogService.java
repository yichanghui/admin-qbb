package com.hiveview.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.client.DeviceLogDao;
import com.hiveview.entity.client.DeviceLog;

@Service
public class DeviceLogService {
	
	@Autowired
	private DeviceLogDao deviceLogDao;
	
	public int batchSave(List<DeviceLog> deviceLogs){
		return deviceLogDao.batchSave(deviceLogs);
	}
	
}
