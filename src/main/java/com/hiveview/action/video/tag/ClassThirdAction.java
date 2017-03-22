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
import com.hiveview.entity.video.tag.ClassThird;
import com.hiveview.entity.video.tag.ClassThirdKey;
import com.hiveview.service.video.tag.ClassThirdService;

@Controller
@RequestMapping("/classThird")
public class ClassThirdAction{
	
	@Autowired
	private ClassThirdService classThirdService;
	
	/**
	 * 分页查询ClassThird
	 * @param pageAjax
	 * @param classThird
	 * @return
	 */
		@RequestMapping(value="/getClassThirdByPage", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ScriptPage getClassThirdByPage(AjaxPage pageAjax,ClassThird classThird){
			ScriptPage scriptPage=new ScriptPage();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("currentPage",pageAjax.getSkipNo());
			map.put("pageSize", pageAjax.getPageSize());
			map.put("classThird", classThird);
			List<ClassThird> ClassThirdList = classThirdService.getClassThirdByPage(map);
			scriptPage.setRows(ClassThirdList);
			scriptPage.setTotal(classThirdService.getClassThirdCount(map));
			return scriptPage;
		}
		/**
		 * 更新ClassThird信息
		 * @param ClassThird
		 * @return
		 */
		@RequestMapping(value="/updateClassThird", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public Data updateClassThird(ClassThird classThird){
			int num=classThirdService.updateClassThird(classThird);
			if(num==1){
				return new Data();
			}else{
				return new Data(0,"修改失败");
			}
		}
		/**
		 * 根据ID查询ClassThird信息
		 * @param classThirdKey
		 * @return
		 */
		@RequestMapping(value="/getClassThirdById", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ClassThird getClassThirdById(ClassThirdKey classThirdKey){
			ClassThird classThird=classThirdService.getClassThirdById(classThirdKey);
			return classThird==null?classThird:null;
		}
		
		/**
		 * 根据ClassFirstId获取ClassThird信息
		 * @param firstId
		 * @return
		 */
		@RequestMapping(value="/getThirdByFirstId", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ScriptPage getThirdByFirstId(Long firstId){
			ScriptPage scriptPage=new ScriptPage();
			List<ClassThird> list=classThirdService.getThirdByFirstId(firstId);
			scriptPage.setRows(list);
			return scriptPage;
		}
		
		
		
		/**
		 * 根据ClassSecondId获取ClassThird信息
		 * @param firstId
		 * @return
		 */
		@RequestMapping(value="/getThirdBySecondId", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ScriptPage getThirdBySecondId(Long secondId){
			List<ClassThird> list=classThirdService.getThirdByFirstId(secondId);
			ScriptPage scriptPage=new ScriptPage();
			scriptPage.setRows(list);
			return scriptPage;
		}
		
		
		/**
		 * 保存ClassThird信息
		 * @param ClassThird
		 * @return
		 */
		@RequestMapping(value="/saveClassThird", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public Data saveClassThird(ClassThird classThird){
			int num=classThirdService.saveClassThird(classThird);
			if(num==1){
				return new Data();
			}else{
				return new Data(0,"添加失败");
			}
		}
	/**
	 * 删除ClassThird信息
	 * @param ClassThirdKey
	 * @return
	 */
		@RequestMapping(value="/deleteClassThird", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public Data deleteClassThird(long thirdclassId){
			int num=classThirdService.deleteClassThird(thirdclassId);
			if(num==1){
				return new Data();
			}else{
				return new Data(0,"删除失败");
			}
		}


}
