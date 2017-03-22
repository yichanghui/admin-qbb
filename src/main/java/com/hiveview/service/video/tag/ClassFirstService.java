package com.hiveview.service.video.tag;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.tag.ClassFirstMapper;
import com.hiveview.entity.video.tag.ClassFirst;

@Service
public class ClassFirstService{
	
	@Autowired
	private ClassFirstMapper classFirstMapper;
	

	public List<ClassFirst> getClassFirstByPage(Map<String, Object> map){
		try {
			List<ClassFirst> list=classFirstMapper.getAllByPage("ClassFirstMapper.getClassFirstByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ClassFirst> getAllEffectiveClassFirst(){
		try {
			List<ClassFirst> list=classFirstMapper.getAllByPage("ClassFirstMapper.getAllEffectiveClassFirst",null);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	public int getClassFirstCount(Map<String, Object> map){
		try {
			int count=classFirstMapper.getCountByPage("ClassFirstMapper.getCountByPage", map);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public ClassFirst getClassFirstById(Long firstId){
		try {
			ClassFirst classFirst=classFirstMapper.getInfoById("ClassFirstMapper.getClassFirstById", firstId);
			return classFirst;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int saveClassFirst(ClassFirst classFirst){
		try {
			return classFirstMapper.saveInfo("ClassFirstMapper.addClassFirst", classFirst);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int updateClassFirst(ClassFirst classFirst){
		try {
			return classFirstMapper.updateById("ClassFirstMapper.updateClassFirst", classFirst);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int deleteClassFirst(Long classFirstId){
		try {
			return classFirstMapper.delById("ClassFirstMapper.deleteClassFirst", classFirstId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
}
