package com.hiveview.action.video.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.tag.ClassFirst;
import com.hiveview.service.video.tag.ClassFirstService;

@Controller
@RequestMapping("/classFirst")
public class ClassFirstAction{
	
	@Autowired
	private ClassFirstService classFirstService;
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("channel/classFrist_list");
		return mv;
	}
	/**
	 * 分页查询ClassFrist
	 * @param pageAjax
	 * @param classFirst
	 * @return
	 */
	@RequestMapping(value="/getClassFirstByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getClassFirstByPage(AjaxPage pageAjax,ClassFirst classFirst){
		ScriptPage s=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("classFirst", classFirst);
		List<ClassFirst> classFirstList = classFirstService.getClassFirstByPage(map);
		s.setRows(classFirstList);
		s.setTotal(classFirstService.getClassFirstCount(map));
		return s;
	}
	
	
	@RequestMapping(value="/getAllEffectiveClassFirst", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAllEffectiveClassFirst(){
		ScriptPage s=new ScriptPage();
		List<ClassFirst> classFirstList = classFirstService.getAllEffectiveClassFirst();
		s.setRows(classFirstList);
		s.setTotal(classFirstList.size());
		return s;
	}
	/**
	 * 根据ID查询ClassFirst信息
	 * @param firstId
	 * @return
	 */
	@RequestMapping(value="/getClassFirstById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data getClassFirstById(Long firstId){
		ClassFirst classFirst=classFirstService.getClassFirstById(firstId);
		if(classFirst!=null){
			return new Data();
		}else{
			return new Data(0,"未知错误");
		}
	}
	
	/**
	 * 更新ClassFrist信息
	 * @param classFirst
	 * @return
	 */
	@RequestMapping(value="/updateClassFirst", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateClassFirst(ClassFirst classFirst){
		int num=classFirstService.updateClassFirst(classFirst);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"未知错误");
		}
	}
	
	
	
	/**
	 * 保存ClassFirst信息
	 * @param classFirst
	 * @return
	 */
	@RequestMapping(value="/saveClassFirst", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveClassFirst(ClassFirst classFirst){
		int num=classFirstService.saveClassFirst(classFirst);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"未知错误");
		}
	}
	/**
	 * 删除ClassFirst信息
	 * @param classFirstId
	 * @return
	 */
	@RequestMapping(value="/deleteClassFirst", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteClassFirst(Long classFirstId){
		int num=classFirstService.deleteClassFirst(classFirstId);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"未知错误");
		}
	}
}
