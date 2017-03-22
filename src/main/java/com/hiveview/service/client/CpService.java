package com.hiveview.service.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hiveview.common.Constants;
import com.hiveview.dao.client.CpChannelMapper;
import com.hiveview.dao.client.CpMapper;
import com.hiveview.entity.client.Cp;
import com.hiveview.service.data.DataCollectService;
import com.hiveview.util.DateUtil;

@Service
public class CpService{
	
	@Autowired
	private CpMapper cpMapper;
	@Autowired
	private CpChannelMapper cpChannelMapper;
	@Autowired
	private DataCollectService collectService;
	
	/**
	 * 用于得到厂商下拉列表
	 * @param map
	 * @return
	 */
	public List<Cp> getCpList(Map<String, Object> map){
		try {
			List<Cp> list=cpMapper.getAllByPage("CpMapper.getCpList", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Cp> getCpByPage(Map<String, Object> map){
		try {
			List<Cp> list=cpMapper.getAllByPage("CpMapper.getCpByPage", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(Map<String, Object> map){
		try {
			return cpMapper.getCountByPage("CpMapper.getCountByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int save(Cp cp){
		try {
			if(null!=cp){
				cp.setCpCreateTime(DateUtil.getTimeStamp(new Date()));
			}
			int num = cpMapper.saveInfo("CpMapper.add", cp);
			collectService.deviceManager(Constants.DATA_COLLECT.CP_ADD, cp2JsonStr(cp));
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int update(Cp cp){
		try {
			collectService.deviceManager(Constants.DATA_COLLECT.CP_UPATE, cp2JsonStr(cp));
			return cpMapper.updateById("CpMapper.update", cp);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int delete(Cp cp){
		try {
			collectService.deviceManager(Constants.DATA_COLLECT.CP_DELETE, cp2JsonStr(cp));
			return cpMapper.updateById("CpMapper.update", cp);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 格式化CP
	 * @param cp
	 * @return
	 */
	private String cp2JsonStr(Cp cp){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", cp.getCpId());
		map.put("name", cp.getCpName());
		map.put("state", cp.getCpState());
		return JSONObject.toJSONString(map);
	}
	
	public List<Cp> getCpByDeviceByCpChannelId(String cpchannelIds){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("cpchannelIds",cpchannelIds);
			List<Cp> list = cpMapper.getAllByPage("CpMapper.getCpByDeviceByCpChannelId", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
