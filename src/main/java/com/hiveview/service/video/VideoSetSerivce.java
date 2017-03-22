package com.hiveview.service.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.VideoDao;
import com.hiveview.dao.video.VideoSetDao;
import com.hiveview.dao.video.VideoUrlDao;
import com.hiveview.entity.video.VideoSet;
import com.hiveview.util.huan.HuanUtil;

@Service
public class VideoSetSerivce{

	@Autowired
	private VideoSetDao videoSetMapper;
	@Autowired
	private VideoDao videoMapper;
	@Autowired
	private VideoUrlDao videoUrlMapper;
	@Autowired
	private com.hiveview.dao.video.VideoSetClassMapper videoSetClassMapper;

	public List<VideoSet> getVideoSetByPage(Map<String, Object> map) {
		try {
			List<VideoSet> list = videoSetMapper.getAllByPage(
					"VideoSetMapper.getVideoSetByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<VideoSet> getVideoSetRelateByPage(Map<String, Object> map) {
		try {
			List<VideoSet> list = videoSetMapper.getAllByPage(
					"VideoSetMapper.getVideosetRelateByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public VideoSet getVideoSetById(Long videoSetId) {
		try {
			VideoSet videoSet = videoSetMapper.getInfoById(
					"VideoSetMapper.getVideoSetById", videoSetId);
			return videoSet;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	public int getVideoSetCountByPage(Map<String, Object> map) {
		try {
			int count = videoSetMapper.getCountByPage(
					"VideoSetMapper.getCountByPage", map);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int getVideoSetRelateCountByPage(Map<String, Object> map) {
		try {
			int count = videoSetMapper.getCountByPage(
					"VideoSetMapper.getVideosetRelateCountByPage", map);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int updateVideoSet(VideoSet videoSet) {
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("videosetId",videoSet.getVideosetId());
			map.put("videoType",videoSet.getVideosetType());
			//1.修改剧集频道
			videoMapper.updateByIf("VideoMapper.updateVideoType",map);
			//2.修改码流频道
			videoUrlMapper.updateByIf("VideoUrlMapper.updateVideoType",map);
			//3.删除关联标签
			map.remove("videoType");
			videoSetClassMapper.delById("VideoSetClassMapper.delVideosetClass", map);
			HuanUtil.threadSyncMediaForHuan("updateMedia",videoSet);
			return videoSetMapper.updateById("VideoSetMapper.updateVideoSet",videoSet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	//上移和下移
	public int updateVideoSetSeq(VideoSet videoSet) {
		try {
			return videoSetMapper.updateById("VideoSetMapper.updateVideoSet",videoSet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	public int updateVideoSet(Integer start,Integer end,Integer flag) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		try {
			if(flag==1)
				return videoSetMapper.updateByIf("VideoSetMapper.upVideoSetSequence",map);
			else
				return videoSetMapper.updateByIf("VideoSetMapper.downVideoSetSequence",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteVideoSet(Long videoSetId,Integer isEffective,String classFirstName) {
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("videosetId", videoSetId);
			map.put("isEffective", isEffective);
			VideoSet videoSet = new VideoSet();
			videoSet.setVideosetId(videoSetId);
			if(isEffective==1){
				videoSet=videoSetMapper.getInfoById("VideoSetMapper.getVideoSetById",videoSetId);
				videoSet.setClassFirstName(classFirstName);
				HuanUtil.threadSyncMediaForHuan("addMedia",videoSet);
			}
			else
				HuanUtil.threadSyncMediaForHuan("deleteMedia",videoSet);
			return videoSetMapper.delByIf("VideoSetMapper.deleteVideoSet",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

	}

	public int saveVideoSet(VideoSet videoSet) {
		int flag=0;
		try {
			flag = videoSetMapper.saveInfo("VideoSetMapper.addVideoSet",videoSet);
			if(flag>0)
				HuanUtil.threadSyncMediaForHuan("addMedia",videoSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public int updateVideoSetSequence(Map<String, Object> map,int flag) {
		try {
			if(videoSetMapper.updateByIf("VideoSetMapper.updateVideoSetSequence",map)>0){
				return 1;
			}else{
				return videoSetMapper.updateByIf("VideoSetMapper.saveVideoSetSequence",map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public long getVideoSetidBySequence(Integer sequence){
		try {
			return new Long(videoSetMapper.getSqlSession().selectOne("VideoSetMapper.getVideoSetidBySequence", sequence).toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}

}
