package com.hiveview.dao.huanwang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseMapper;
import com.hiveview.entity.po.huanwang.ContentMedia;
import com.hiveview.entity.po.huanwang.ContentVideo;
import com.hiveview.entity.po.huanwang.JsonStr;
import com.hiveview.entity.video.tag.ClassFirst;

@Repository
public class InterfaceListDao extends BaseMapper<JsonStr>  {
	
	public List<ClassFirst> getAllClassFirst(Map<String,Object> map){
		return this.getSqlSession().selectList("HuanMapper.getAllClassFirst",map);
	}
	
	public List<ContentMedia> getAllMediaByPage(Map<String,Object> map){
		return this.getSqlSession().selectList("HuanMapper.getAllMediaByPage",map);
	}
	
	public List<ContentVideo> getAllVideoByPage(Map<String,Object> map){
		return this.getSqlSession().selectList("HuanMapper.getAllVideoByPage",map);
	}
	
	public Integer getMediaCount(Map<String,Object> map){
		return this.getSqlSession().selectOne("HuanMapper.getMediaCount",map);
	}
	
}
