package com.hiveview.service.huanwang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiveview.action.comm.FileUploadAction;
import com.hiveview.common.Constants;
import com.hiveview.dao.huanwang.InterfaceListDao;
import com.hiveview.entity.po.huanwang.ContentMedia;
import com.hiveview.entity.po.huanwang.ContentVideo;
import com.hiveview.entity.video.VideoSet;
import com.hiveview.entity.video.tag.ClassFirst;
import com.hiveview.util.HttpUtil;
import com.hiveview.util.huan.HuanUtil;

@Repository
public class InterfaceListService {
	
	Logger logger = Logger.getLogger(FileUploadAction.class);
	
	@Autowired
	private InterfaceListDao interfaceListDao;
	
	public void syncMedia(){
		List<ClassFirst> classFirstList = this.getAllClassFirst(null);
		for(ClassFirst cf:classFirstList){
			int classFirstId = Integer.parseInt(cf.getFirstclassId()+"");
			VideoSet videoSet = new VideoSet();
			videoSet.setVideosetType(classFirstId);
			//获得总专辑数count()
			int mediaTotal = this.getMediaCount(videoSet);//
			//计算总共多少页
			int mediaTotalPage = mediaTotal%10==0?mediaTotal/Constants.pageSize_huan:mediaTotal/Constants.pageSize_huan+1;
			for(int currentPage=0;currentPage<mediaTotalPage;currentPage++){
				List<ContentMedia> mediaList = getMediaList(videoSet,currentPage,Constants.pageSize_huan);//获得专辑列表
				for(ContentMedia media:mediaList){//循环获得每一个专辑
					media.setModel(cf.getFirstclassName());
					//调用发送专辑接口
					logger.info("media信息："+media.getMediaId()+" -- "+media.getTitle());
					HttpUtil.reqPost(Constants.uri_huan,HuanUtil.getMap("addMedia",media.getMediaId(),media));
					//通过专辑获得剧集
					List<ContentVideo> videoList = getVideoList(media.getMediaId());
					for(ContentVideo video:videoList){//循环获得每一个剧集
						video.setType("完整版");
						if(classFirstId!=1)
							video.setEpisode(media.getVideosetTotal());
						else
							video.setEpisode(0);//频道为电影的全部设置为0
						logger.info("video信息："+video.getMediaId()+" -- "+video.getVideoId()+" -- "+video.getTitle());
						HttpUtil.reqPost(Constants.uri_huan,HuanUtil.getMap("addVideo",video.getMediaId(),video));
					}
				}
			}
		}
	}
	
	//获得频道列表
	private List<ClassFirst> getAllClassFirst(Map<String,Object> map){
		List<ClassFirst> list=interfaceListDao.getAllClassFirst(map);
		return list;
	}
	
	//获得专辑列表
	private List<ContentMedia> getMediaList(VideoSet videoSet,int currentPage,int pageSize){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("isEffective",videoSet.getIsEffective());
		map.put("videosetType",videoSet.getVideosetType());
		map.put("currentPage",currentPage);
		map.put("pageSize",pageSize);
		return interfaceListDao.getAllMediaByPage(map);
	}
	
	//获得专辑数量
	private Integer getMediaCount(VideoSet videoSet){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("isEffective",videoSet.getIsEffective());
		map.put("videosetType",videoSet.getVideosetType());
		return interfaceListDao.getMediaCount(map);
	}
	
	//获得剧集列表
	private List<ContentVideo> getVideoList(Integer videosetId){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("videosetId",videosetId);
		return interfaceListDao.getAllVideoByPage(map);
	}

}
