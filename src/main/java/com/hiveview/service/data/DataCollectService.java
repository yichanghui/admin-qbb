package com.hiveview.service.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hiveview.common.Constants;
import com.hiveview.util.HttpUtil;

@Service
public class DataCollectService {

	/**
	 * 统计接口
	 * @param flag 见Constants.DATA_COLLECT说明
	 * @param msg 数据JSONSTR
	 */
	public void deviceManager(int flag,String msg){
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("flag",flag+"");
		paramMap.put("command",msg);
		HttpUtil.reqPost(Constants.DATA_COLLECT.DATA_COLLECT_URL,paramMap);
	}
}
