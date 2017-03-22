package com.hiveview.service.video.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.tag.ClassSecondMapper;
import com.hiveview.entity.video.tag.ClassSecond;
import com.hiveview.entity.video.tag.ClassSecondKey;

@Service
public class ClassSecondService{

	@Autowired
	private ClassSecondMapper classSecondMapper;

	public List<ClassSecond> getClassSecondByPage(Map<String, Object> map){
		try {
			List<ClassSecond> list=classSecondMapper.getAllByPage("ClassSecondMapper.getClassSecondByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	public int getClassSecondCount(Map<String, Object> map){
		try {
			int count=classSecondMapper.getCountByPage("ClassSecondMapper.getCountByPage", map);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public ClassSecond getSecondById(ClassSecondKey classSecondKey){
		try {
			ClassSecond classSecond=classSecondMapper.getInfoById("ClassSecondMapper.getClassSecondById",classSecondKey);
			return classSecond;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<ClassSecond> getSecondByFirstId(Long firstclassId){
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("firstclassId", firstclassId);
		List<ClassSecond> list=classSecondMapper.getInfoById("ClassSecondMapper.getClassSecondByFirstId", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int saveClassSecond(ClassSecond classSecond){
		try {
			return classSecondMapper.saveInfo("ClassSecondMapper.addClassSecond", classSecond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int updateClassSecond(ClassSecond classSecond){
		try {
			return classSecondMapper.updateById("ClassSecondMapper.updateClassSecond", classSecond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int deleteClassSecond(ClassSecondKey classSecondKey){
		try {
			return classSecondMapper.delById("ClassSecondMapper.deleteClassSecond",classSecondKey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
}
