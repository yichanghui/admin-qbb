package com.hiveview.service.app.tag;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiveview.dao.app.tag.CategoryMapper;
import com.hiveview.dao.app.tag.TagMapper;
import com.hiveview.entity.app.Category;
import com.hiveview.entity.app.Tag;
import com.hiveview.util.DateUtil;


@Repository
public class TagService {

	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	/*** tag start ***/
	public List<Tag> getTagList(Integer categoryId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryId",categoryId);
		return tagMapper.getAllByPage("TagMapper.getTagList", map);
	}

	public List<Tag> getTagListByPage(Tag tag,Integer currentPage,Integer pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tag", tag);
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		return tagMapper.getAllByPage("TagMapper.getTagListByPage", map);
	}
	
	public Integer updateTag(Tag tag){
		tag.setUpdateTime(DateUtil.getTimeStamp(new Date()));
		return tagMapper.updateById("TagMapper.updateTag", tag);
	}
	
	public Integer saveTag(Tag tag){
		tag.setCreateTime(DateUtil.getTimeStamp(new Date()));
		return tagMapper.saveInfo("TagMapper.saveTag", tag);
	}
	
	public Integer deleteTag(Integer id){
		Tag tag = new Tag();
		tag.setTagId(id);
		tag.setState(0);
		return tagMapper.updateById("TagMapper.deleteTag", tag);
	}
	
	public Integer getCountForTag(Tag tag){
		return tagMapper.getCount("TagMapper.getCountForTag", tag);
	}
	/*** tag end ***/
	
	/*** category start ***/
	public List<Category> getCategoryListByPage(Category category,Integer currentPage,Integer pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("currentPage",currentPage);
		map.put("pageSize", pageSize);
		return categoryMapper.getInfoById("TagMapper.getCategoryListByPage", map);
	}
	
	public List<Category> getCategoryList(){
		Map<String, Object> map = new HashMap<String, Object>();
		return categoryMapper.getInfoById("TagMapper.getCategoryList", map);
	}
	public Integer updateCategory(Category category){
		category.setUpdateTime(DateUtil.getTimeStamp(new Date()));
		return categoryMapper.updateById("TagMapper.updateCategory", category);
	}
	public Integer saveCategory(Category category){
		category.setCreateTime(DateUtil.getTimeStamp(new Date()));
		return categoryMapper.saveInfo("TagMapper.saveCategory", category);
	}
	public Integer deleteCategory(Integer id){
		Category category = new Category();
		category.setCategoryId(id);
		category.setState(0);
		return categoryMapper.updateById("TagMapper.deleteCategory", category);
	}
	public Integer getCountForCategory(Category category){
		return categoryMapper.getCount("TagMapper.getCountForCategory", category);
	}
	/*** category end ***/
}
