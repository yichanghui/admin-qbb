package com.hiveview.service.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.client.VersionMapper;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.client.Cp;
import com.hiveview.entity.client.Version;
import com.hiveview.entity.po.client.VersionUpdatePo;
import com.hiveview.util.DateUtil;

@Service
public class VersionService{
	
	@Autowired
	private VersionMapper versionMapper;

	public List<Version> getVersionByPage(Map<String, Object> map){
		try {
			List<Version> list=versionMapper.getAllByPage("VersionMapper.getVersionByPage", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(Map<String, Object> map){
		try {
			return versionMapper.getCountByPage("VersionMapper.getCountByPage", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
	public int save(Version version){
		try {
			if(versionMapper.saveInfo("VersionMapper.add", version)>0){
//				VersionUpdatePo[] versionUpdatePoList = JSON.parseObject(versionUpdateJson,new TypeReference<VersionUpdatePo[]>(){});
//				List<VersionUpdatePo> list = new ArrayList<VersionUpdatePo>();
//				for(VersionUpdatePo versionUpdatePo : versionUpdatePoList){
//					if(versionUpdatePo!=null){
//						versionUpdatePo.setCvid(version.getCvId());
//						versionUpdatePo.setVersion(version.getVersion());
//						list.add(versionUpdatePo);
//					}
//				}
//				if(list.size()>0)
//					versionMapper.batchAddVersionUpdate("VersionMapper.batchAddVersionUpdate",list);
				return 1;
			}else{
				return -1000;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateClassFirst(Version version){
		try {
			version.setUpdateTime(DateUtil.getTimeStamp(new Date()));
			return versionMapper.updateById("VersionMapper.update", version);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteSysVersion(Long cvid){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("cvid", cvid);
		if(versionMapper.delById("VersionMapper.deleteSysVersionUpdate",map)>=0){
			return versionMapper.delById("VersionMapper.deleteSysVersion", map);
		}
		return -1;
	}
	
	public List<Cp> getCpListForSelect(){
		try {
			return versionMapper.getCpListForSelect("VersionMapper.getCpListForSelect");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public ScriptPage getCpChannelForVersion(VersionUpdatePo versionUpdatePo){
		ScriptPage script = new ScriptPage();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("cpId", versionUpdatePo.getCpId());
			map.put("cvid", versionUpdatePo.getCvid());
			map.put("hardwareId", versionUpdatePo.getHardwareId());
			map.put("currentPage", versionUpdatePo.getSkipNo());
			map.put("pageSize", versionUpdatePo.getPageSize());
			script.setRows(versionMapper.getCpChannelForVersion("VersionMapper.getCpChannelForVersion",map));
			script.setTotal(versionMapper.getCpChannelForVersionCount(map));
			return script;
		} catch (Exception e) {
			e.printStackTrace();
			script.setMsg(e.getMessage());
			return script;
		}
	}
	
	public ScriptPage getVersionUpdateByPage(VersionUpdatePo versionUpdatePo){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("cvid", versionUpdatePo.getCvid());
			map.put("currentPage",versionUpdatePo.getSkipNo());
			map.put("pageSize",versionUpdatePo.getRows());
			ScriptPage scriptPage = new ScriptPage();
			scriptPage.setRows(versionMapper.getVersionUpdateByPage(map));
			scriptPage.setTotal(versionMapper.getVersionCount(map));
			return scriptPage;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public Integer addSysVersionUpdate(VersionUpdatePo versionUpdatePo){
		try {
			return this.versionMapper.addSysVersionUpdate(versionUpdatePo);
		} catch (Exception e) {
			e.printStackTrace();
			return -1000;
		}
	}
	public Integer deleteSysVersionUpdate(Integer id){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id",id);
			return this.versionMapper.deleteSysVersionUpdate(map);
		} catch (Exception e) {
			e.printStackTrace();
			return -1000;
		}
	}
}
