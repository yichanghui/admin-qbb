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
import com.hiveview.entity.client.CpChannel;
import com.hiveview.service.data.DataCollectService;
import com.hiveview.util.DateUtil;

@Service
public class CpChannelService {
	@Autowired
	private CpChannelMapper cpChannelMapper;
	@Autowired
	private DataCollectService collectService;

	public List<CpChannel> getCpChannelByPage(Map<String, Object> map){
		try {
			List<CpChannel> list=cpChannelMapper.getAllByPage("CpChannelMapper.getCpChannelByPage", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(Map<String, Object> map){
		try {
			return cpChannelMapper.getCountByPage("CpChannelMapper.getCountByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int save(CpChannel cpChannel){
		try {
			if(null!=cpChannel){
				cpChannel.setCpCreateTime(DateUtil.getTimeStamp(new Date()));
			}
			int num = cpChannelMapper.saveInfo("CpChannelMapper.save", cpChannel);
			collectService.deviceManager(Constants.DATA_COLLECT.CPCHANNEL_ADD, cpChannel2JsonStr(cpChannel));
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int update(CpChannel cpChannel){
		try {
			collectService.deviceManager(Constants.DATA_COLLECT.CPCHANNEL_UPATE, cpChannel2JsonStr(cpChannel));
			return cpChannelMapper.updateById("CpChannelMapper.update", cpChannel);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 格式化cpChannel
	 * @param cp
	 * @return
	 */
	private String cpChannel2JsonStr(CpChannel cpChannel){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", cpChannel.getCpChannelId());
		map.put("name", cpChannel.getCpChannelName());
		map.put("state", cpChannel.getCpChannelState());
		return JSONObject.toJSONString(map);
	}
}
