package com.hiveview.service.video.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.tag.ClassThirdMapper;
import com.hiveview.entity.video.tag.ClassThird;
import com.hiveview.entity.video.tag.ClassThirdKey;

@Service
public class ClassThirdService{
	
	@Autowired
	private ClassThirdMapper classThirdMapper;

	public List<ClassThird> getClassThirdByPage(Map<String, Object> map){
		try {
			List<ClassThird> list=classThirdMapper.getAllByPage("ClassThirdMapper.getClassThirdByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ClassThird getClassThirdById(ClassThirdKey classThirdKey){
		try {
			ClassThird classThird=classThirdMapper.getInfoById("ClassThirdMapper.getClassThirdById", classThirdKey);
			return classThird;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public int getClassThirdCount(Map<String, Object> map){
		try {
			int count=classThirdMapper.getCountByPage("ClassThirdMapper.getCountByPage", map);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public List<ClassThird> getThirdByFirstId(Long firstclassId){
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("firstclassId", firstclassId);
		List<ClassThird> list=classThirdMapper.getInfoById("ClassThirdMapper.getClassThirdByFirstId", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ClassThird> getThirdBySecondId(Long secondclassId){
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("secondclassId", secondclassId);
		List<ClassThird> list=classThirdMapper.getInfoById("ClassThirdMapper.getClassThirdBySecondId", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int saveClassThird(ClassThird classThird){
		try {
			return classThirdMapper.saveInfo("ClassThirdMapper.addClassThird", classThird);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int updateClassThird(ClassThird classThird){
		try {
			return classThirdMapper.updateById("ClassThirdMapper.updateClassThird", classThird);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int deleteClassThird(long thirdclassId){
		try {
			return classThirdMapper.delById("ClassThirdMapper.deleteClassThird",thirdclassId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

}
