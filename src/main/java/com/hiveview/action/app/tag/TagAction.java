package com.hiveview.action.app.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hiveview.entity.app.Category;
import com.hiveview.entity.app.Tag;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.tag.TagService;

@Controller
@RequestMapping("/apptag")
public class TagAction{
	@Autowired
	private TagService tagService;
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/tag/category_list");
		return mv;
	}
	/************ tag start ********************/
	@RequestMapping(value="/getTagList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getTagList(Integer categoryId){
		try {
			return JSON.toJSONString(tagService.getTagList(categoryId));
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("system exception");
		}
	}
	
	@RequestMapping(value="/getTagListByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getTagListByPage(Tag tag,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		scriptPage.setRows(tagService.getTagListByPage(tag, pageAjax.getSkipNo(), pageAjax.getPageSize()));
		scriptPage.setTotal(this.tagService.getCountForTag(tag));
		return scriptPage;
	}
	
	@RequestMapping(value="/updateTag", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateTag(Tag tag){
		if(tagService.updateTag(tag)>0){
			return new Data();
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping(value="/saveTag", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveTag(Tag tag){
		if(tagService.saveTag(tag)>0){
			return new Data();
		}else{
			return new Data(0,"保存失败");
		}
	}
	
	@RequestMapping(value="/deleteTag", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteTag(Integer id){
		if(tagService.deleteTag(id)>0){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}
	/************ tag end  ********************/
	
	/************** category start *******************/
	@RequestMapping(value="/getCategroyList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getCategroyList(){
		return JSON.toJSONString(tagService.getCategoryList());
	}
	
	@RequestMapping(value="/getCategroyListByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getCategroyListByPage(Category category,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		scriptPage.setRows(tagService.getCategoryListByPage(category, pageAjax.getSkipNo(), pageAjax.getPageSize()));
		scriptPage.setTotal(this.tagService.getCountForCategory(category));
		return scriptPage;
	}
	
	@RequestMapping(value="/updateCategroy", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateCategroy(Category category){
		if(tagService.updateCategory(category)>0){
			return new Data();
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping(value="/saveCategory", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveCategory(Category category){
		if(tagService.saveCategory(category)>0){
			return new Data();
		}else{
			return new Data(0,"添加失败");
		}
	}
	
	@RequestMapping(value="/deleteCategory", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteCategory(Integer id){
		if(tagService.deleteCategory(id)>0){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}
	
	/************** category end  *******************/
}
