package com.hiveview.service.cache;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hiveview.dao.cache.CacheUrlDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.cache.CacheUrl;
import com.hiveview.util.HttpUtil;
import com.hiveview.util.ProperManager;

@Service
public class CacheUrlService {

	@Autowired
	private CacheUrlDao cacheUrlDao;
	
	private static String SUCCESS_CODE = "N000000";

	/** 添加 **/
	public int save(CacheUrl cacheurl) {
		return cacheUrlDao.save(cacheurl);
	}

	/** 修改 **/
	public int update(CacheUrl cacheurl) {
		return cacheUrlDao.update(cacheurl);
	}

	/** 删除 **/
	public int delete(CacheUrl cacheurl) {
		return cacheUrlDao.delete(cacheurl);
	}

	/** 获取列表 **/
	public ScriptPage getList(CacheUrl cacheurl, AjaxPage ajaxPage) {
		ScriptPage scriptPage = new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cacheUrl", cacheurl);
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<CacheUrl> rows = cacheUrlDao.getList(map);
		scriptPage.setRows(rows);
		int total = cacheUrlDao.getCount(map);
		scriptPage.setTotal(total);
		return scriptPage;
	}

	/** 删除缓存 **/
	public Integer removeCache(CacheUrl cacheUrl){
		Integer result = 0;
		try {
			String jsonStr = HttpUtil.reqPost(MessageFormat.format(ProperManager.getString("clear_redis"), cacheUrl.getCacheUrl()));
			JSONObject dataJson = JSONObject.parseObject(jsonStr);
			if(SUCCESS_CODE.equals(dataJson.get("code"))){
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
