package com.hiveview.action.video.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.tag.ClassSecond;
import com.hiveview.entity.video.tag.ClassSecondKey;
import com.hiveview.service.video.tag.ClassSecondService;

@Controller
@RequestMapping("/classSecond")
public class ClassSecondAction{
	
	
	@Autowired
	private ClassSecondService classSecondService;
	/**
	 * 分页查询ClassSecond
	 * @param pageAjax
	 * @param classSecond
	 * @return
	 */
	@RequestMapping(value="/getClassSecondByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getClassSecondByPage(AjaxPage pageAjax,ClassSecond classSecond){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("classSecond", classSecond);
		List<ClassSecond> classSecondList = classSecondService.getClassSecondByPage(map);
		scriptPage.setRows(classSecondList);
		scriptPage.setTotal(classSecondService.getClassSecondCount(map));
		return scriptPage;
	}
	/**
	 * 更新ClassSecond信息
	 * @param classSecond
	 * @return
	 */
	@RequestMapping(value="/updateClassSecond", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateClassSecond(ClassSecond classSecond){
		int num=classSecondService.updateClassSecond(classSecond);
		if(num==1){
			return new Data();
		}else{
			return new Data(0, "修改错误");
		}
	}
	/**
	 * 根据ID查询ClassSecond信息
	 * @param classSecondKey
	 * @return
	 */
	@RequestMapping(value="/getSecondById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ClassSecond getSecondById(ClassSecondKey classSecondKey){
		ClassSecond classSecond=classSecondService.getSecondById(classSecondKey);
		return classSecond==null?classSecond:null;
	}
	
	/**
	 * 根据ClassFirstId获取ClassSecond信息
	 * @param firstId
	 * @return
	 */
	@RequestMapping(value="/getSecondByFirstId", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getSecondByFirstId(Long firstId){
		ScriptPage scriptPage=new ScriptPage();
		List<ClassSecond> list=classSecondService.getSecondByFirstId(firstId);
		scriptPage.setRows(list);
		return scriptPage;
	}
	
	/**
	 * 保存ClassSecond信息
	 * @param classSecond
	 * @return
	 */
	@RequestMapping(value="/saveClassSecond", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveClassSecond(ClassSecond classSecond){
		int num=classSecondService.saveClassSecond(classSecond);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"添加失败");
		}
	}
/**
 * 删除ClassSecond信息
 * @param classSecondKey
 * @return
 */
	@RequestMapping(value="/deleteClassSecond", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteClassSecond(ClassSecondKey classSecondKey){
		int num=classSecondService.deleteClassSecond(classSecondKey);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}

}
