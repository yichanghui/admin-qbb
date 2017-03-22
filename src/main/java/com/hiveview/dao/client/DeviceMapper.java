package com.hiveview.dao.client;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseMapper;
import com.hiveview.entity.client.Device;
import com.hiveview.entity.client.DeviceLog;
import com.hiveview.entity.vo.client.DeviceInfoVo;

@Repository
public class DeviceMapper extends BaseMapper<Device>{

	public int saveForBatch(List<Device> list){
		return this.getSqlSession().insert("DeviceMapper.addForeach",list);
	}
	
	public List<DeviceLog> getDeviceList(Device device){
		return this.getSqlSession().selectList("DeviceMapper.getDeviceList",device);
	}
	/**
	 * 更新设备信息
	 * @param deviceList
	 */
	public void batchUpdate(List<DeviceLog> deviceList){
		this.getSqlSession().selectList("DeviceMapper.batchUpdate",deviceList);
	}
	public List<DeviceInfoVo> getAllByPage(Map<String, Object> map){
		return this.getSqlSession().selectList("DeviceMapper.getDeviceByPage",map);
	}
}
