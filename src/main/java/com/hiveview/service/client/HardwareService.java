package com.hiveview.service.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hiveview.common.Constants;
import com.hiveview.dao.client.HardwareDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.client.Hardware;
import com.hiveview.entity.vo.client.HardwareVo;
import com.hiveview.service.data.DataCollectService;

@Service
public class HardwareService {
	
	@Autowired
	private HardwareDao hardwareDao;
	@Autowired
	private DataCollectService collectService;
	
	/** 添加 **/
	public int save(Hardware hardware){
		if(!validateHardware(hardware)){
			int num = hardwareDao.save(hardware);
			collectService.deviceManager(Constants.DATA_COLLECT.HARDWARE_ADD, hardware2JsonStr(hardware));
			return num;
		}else{
			return -1;
		}
	}
	
	/** 修改 **/
	public int update(Hardware hardware){
		collectService.deviceManager(Constants.DATA_COLLECT.HARDWARE_UPATE, hardware2JsonStr(hardware));
		return hardwareDao.update(hardware);
	}
	
	/** 删除 **/
	public int delete(Hardware hardware){
		collectService.deviceManager(Constants.DATA_COLLECT.HARDWARE_DELETE, hardware2JsonStr(hardware));
		return hardwareDao.delete(hardware);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(Hardware hardware,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		hardware.setPageIndex(ajaxPage.getSkipNo());
		hardware.setPageSize(ajaxPage.getPageSize());
		List<HardwareVo> rows = hardwareDao.getInfoList(hardware);
		scriptPage.setRows(rows);
		int total = hardwareDao.getCount(hardware);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	/**
	 * 验证生产商和硬件型号是否已经存在
	 * @param hardware
	 * @return true 存在
	 */
	public boolean validateHardware(Hardware hardware){
		Hardware temp = hardwareDao.getByHardwareNo(hardware);
		if(temp==null){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 格式化hardware
	 * @param cp
	 * @return
	 */
	private String hardware2JsonStr(Hardware hardware){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", hardware.getId());
		map.put("hardwareNo", hardware.getHardwareNo());
		map.put("state", hardware.getIsEffective());
		map.put("cpId", hardware.getCpId());
		return JSONObject.toJSONString(map);
	}
}
