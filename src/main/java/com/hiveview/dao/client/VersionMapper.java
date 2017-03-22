package com.hiveview.dao.client;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseMapper;
import com.hiveview.entity.bo.client.CpChannelBo;
import com.hiveview.entity.bo.client.VersionUpdateBo;
import com.hiveview.entity.client.Cp;
import com.hiveview.entity.client.Version;
import com.hiveview.entity.po.client.VersionUpdatePo;


@Repository
public class VersionMapper extends BaseMapper<Version> {

	public List<Cp> getCpListForSelect(String arg) {
		return this.getSqlSession().selectList(arg);
	}

	public List<CpChannelBo> getCpChannelForVersion(String arg,Map<String, Object> map) {
		return this.getSqlSession().selectList(arg, map);
	}
	public Integer getCpChannelForVersionCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("VersionMapper.getCpChannelForVersionCount", map);
	}
	public int batchAddVersionUpdate(String arg,List<VersionUpdatePo> v){
		return this.getSqlSession().insert(arg, v);
	}
	
	public List<VersionUpdateBo> getVersionUpdateByPage(Map<String,Object> map){
		return this.getSqlSession().selectList("VersionMapper.getVersionUpdateByPage",map);
	}
	public Integer getVersionCount(Map<String,Object> map){
		return this.getSqlSession().selectOne("VersionMapper.getVersionCount",map);
	}
	
	public Integer addSysVersionUpdate(VersionUpdatePo versionUpdatePo){
		return this.getSqlSession().insert("VersionMapper.addSysVersionUpdate",versionUpdatePo);
	}
	public Integer deleteSysVersionUpdate(Map<String,Object> map){
		return this.getSqlSession().delete("VersionMapper.deleteSysVersionUpdate",map);
	}
}
