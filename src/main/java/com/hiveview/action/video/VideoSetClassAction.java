package com.hiveview.action.video;

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
import com.hiveview.entity.video.VideoSetClass;
import com.hiveview.service.video.VideoSetClassService;
@Controller
@RequestMapping("/videosetClass")
public class VideoSetClassAction{
	
	@Autowired
	private VideoSetClassService videoSetClassService;
	
	/**
	 * 分页获取标签关系信息
	 * @param pageAjax
	 * @param videoSetClass
	 * @return
	 */
	@RequestMapping(value="/getClassByPage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getClassByPage(AjaxPage pageAjax,VideoSetClass videoSetClass){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object>  map=new HashMap<String,Object>();
		map.put("currentPage", pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("videoSetClass", videoSetClass);
		List<VideoSetClass>  list=videoSetClassService.getClassByPage(map);
		scriptPage.setRows(list);
		scriptPage.setTotal(videoSetClassService.getClassCountByPage(map));
		return scriptPage;
	}
	
	
//	/**
//	 * 保存标签与专辑的关系
//	 * @param videoSetClass
//	 * @return
//	 */
//	@RequestMapping(value="/saveVideoSetClass",produces={"application/json;charset=UTF-8"})
//	@ResponseBody
//	public String saveVideosetClass(VideoSetClass videoSetClass){
//		int num=videoSetClassService.saveVideoSetClass(videoSetClass);
//		if(num==1){
//			return this.setJSONObject(SUCCESS);
//		}else{
//			return this.setJSONObject(ERROR);
//		}
//	}
	
	/**
	 * 保存标签与专辑的关系
	 * @param videoSetClass
	 * @return
	 */
	@RequestMapping(value="/addVideoSetClass",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveVideosetClass(VideoSetClass videoSetClass,String thirdclassIds){
		String[] thirdclass=thirdclassIds.split(",");
		int num=1;
		for(String thirdclassId:thirdclass){
			VideoSetClass myVideoSetClass=new VideoSetClass();
			myVideoSetClass.setFirstclassId(videoSetClass.getFirstclassId());
			myVideoSetClass.setSecondclassId(videoSetClass.getSecondclassId());
			myVideoSetClass.setThirdclassId(Long.parseLong(thirdclassId));
			myVideoSetClass.setSequence(videoSetClass.getSequence());
			myVideoSetClass.setVideosetId(videoSetClass.getVideosetId());
			myVideoSetClass.setVideosetType(videoSetClass.getVideosetType());
			int count=videoSetClassService.saveVideoSetClass(myVideoSetClass);
			if(count==0){
				num=-1;
			}
		}
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"保存失败");
		}
	}
	
	
	
	/**
	 * 删除标签与专辑的关系
	 * @param videoSetClass
	 * @return
	 */
	@RequestMapping(value="/deleteVideosetClass",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data delVideosetClass(VideoSetClass videoSetClass){
		int num=videoSetClassService.deleteClass(videoSetClass);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}
}
