package com.hiveview.service.app.operatehistory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiveview.dao.app.operatehistory.OperatehistoryMapper;
import com.hiveview.entity.app.AppOperateHistory;
import com.hiveview.entity.sys.SysUser;
import com.hiveview.util.DateUtil;

@Repository
public class OperatehistoryService {

	@Autowired
	private OperatehistoryMapper operatehistoryMapper;
	
	public List<AppOperateHistory> getAppOperateHistoryList(AppOperateHistory history,Integer currentPage,Integer pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("history",history);
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		return operatehistoryMapper.getAllByPage("AppMapper.getAppOperateHistoryList", map);
	}
	
	public Integer getCount(AppOperateHistory history){
		return operatehistoryMapper.getCount("AppMapper.getCountForOperateHistory", history);
	}
	
	public Integer save(HttpSession session,AppOperateHistory history){
		try {
			//HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			SysUser sysUser = (SysUser)session.getAttribute("currentUser");
			history.setAccount(sysUser.getUserName());
			history.setOperateTime(DateUtil.getTimeStamp(new Date()));
			return operatehistoryMapper.saveInfo("AppMapper.saveOperateHistory",history);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
