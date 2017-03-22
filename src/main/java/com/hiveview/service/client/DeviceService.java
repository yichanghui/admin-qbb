package com.hiveview.service.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.hiveview.common.Constants;
import com.hiveview.dao.client.CpChannelDao;
import com.hiveview.dao.client.CpDao;
import com.hiveview.dao.client.DeviceLogDao;
import com.hiveview.dao.client.DeviceMapper;
import com.hiveview.entity.client.Device;
import com.hiveview.entity.client.DeviceLog;
import com.hiveview.entity.vo.client.DeviceInfoVo;
import com.hiveview.entity.vo.client.DeviceVo;
import com.hiveview.service.data.DataCollectService;
import com.hiveview.util.DateUtil;

@Service
public class DeviceService{
	
	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private CpDao cpDao;
	@Autowired
	private CpChannelDao cpChannelDao;
	@Autowired
	private DeviceLogDao deviceLogDao;
	@Autowired
	private DataCollectService collectService;

	/**
	 * 用于得到下拉列表
	 * @param map
	 * @return
	 */
	public List<Device> getDeviceList(Map<String, Object> map){
		try {
			List<Device> list=deviceMapper.getAllByPage("DeviceMapper.getDeviceList", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<DeviceInfoVo> getDeviceByPage(Map<String, Object> map){
		try {
			List<DeviceInfoVo> list=deviceMapper.getAllByPage(map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(Map<String, Object> map){
		try {
			return deviceMapper.getCountByPage("DeviceMapper.getCountByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int save(Device device){
		try {
			device.setDeviceCreateTime(DateUtil.getTimeStamp(new Date()));
			return deviceMapper.saveInfo("DeviceMapper.add", device);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int saveForeach(List<Device> list){
		try {
			return deviceMapper.saveForBatch(list);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int update(Device device){
		try {
			device.setDeviceLastTime(DateUtil.getTimeStamp(new Date()));
			return deviceMapper.updateById("DeviceMapper.update", device);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int delete(Device device){
		try {
			int flag = deviceMapper.updateById("DeviceMapper.delete", device);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 查询设备未激活数量
	 * @return
	 */
	public Integer countDevice(){
		Device device = new Device();
		device.setDeviceState(0);//0：未激活，1：已激活
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("device", device);
		return deviceMapper.getCountByPage("DeviceMapper.getCountByPage",map);
	}
	/**
	 * 生成EXCEL文件并保存信息
	 * @param device 分配的设备信息
	 * @param amount 需求的设备数
	 */
	public List<DeviceLog> exportDevice(DeviceVo device,int amount){
		device.setRows(amount);
		device.setDeviceState(0);//0：未激活，1：已激活
		//查询未激活设备数量
		List<DeviceLog> deviceList = deviceMapper.getDeviceList(device);
		
		if(deviceList.size()>0){
			for (DeviceLog temp : deviceList) {
				temp.setDeviceState(1);//更新设备状态
				temp.setCpId(device.getCpId());
				temp.setCpName(device.getCpName());
				temp.setCpChannelId(device.getCpChannelId());
				temp.setCpChannelName(device.getCpChannelName());
				temp.setRomVersion(device.getRomVersion());
				temp.setHardwareId(device.getHardwareId());
				temp.setHardwareNo(device.getHardwareNo());
			}
			
			//更新device数据库
			deviceMapper.batchUpdate(deviceList);
			//同步到设备日志表
			deviceLogDao.batchSave(deviceList);
			//同步到统计平台
			collectService.deviceManager(Constants.DATA_COLLECT.DEVICE_ADD, deviceList2Str(deviceList));
			//生成excel文件
			return deviceList;
		}else{
			return new ArrayList<DeviceLog>();
		}
	}

	/**
	 * 统计接口使用，将设备信息列表按要求显示
	 * @param deviceList
	 * @return
	 */
	private String deviceList2Str(List<DeviceLog> deviceList){
		List<Object> mapList = new ArrayList<Object>();
		for (DeviceLog deviceLog : deviceList) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("deviceSn", deviceLog.getDeviceSn());
			map.put("deviceMac", deviceLog.getDeviceMac());
			map.put("deviceVersion", deviceLog.getDeviceVersion());
			map.put("cpId", deviceLog.getCpId());
			map.put("hardwareId", deviceLog.getHardwareId());
			map.put("cpChannelId", deviceLog.getCpChannelId());
			map.put("romVersion", deviceLog.getRomVersion());
			mapList.add(map);
		}
		JSONArray array = new JSONArray(mapList);
		return array.toJSONString();
	}
}
