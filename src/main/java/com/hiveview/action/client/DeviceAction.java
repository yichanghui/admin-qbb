package com.hiveview.action.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.client.Device;
import com.hiveview.entity.vo.client.DeviceInfoVo;
import com.hiveview.entity.vo.client.DeviceVo;
import com.hiveview.service.client.DeviceService;
import com.hiveview.service.client.ViewExcel;
import com.hiveview.util.DateUtil;
import com.hiveview.util.IOUtil;

@Controller
@RequestMapping("/device")
public class DeviceAction{

	@Autowired
	private DeviceService deviceService;
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/device_list");
		return mv;
	}
	
	@RequestMapping(value="/getDeviceByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVersionByPage(AjaxPage pageAjax,Device device){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("device", device);
		List<DeviceInfoVo> versionList = deviceService.getDeviceByPage(map);
		scriptPage.setRows(versionList);
		scriptPage.setTotal(deviceService.getCount(map));
		return scriptPage;
	}
	
	@RequestMapping(value="/updateDevice", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateVersion(Device device){
		int num=deviceService.update(device);
		if(num==1){
			return new Data(1,"");
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping(value="/saveDevice", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveDevice(Device device){
		int num=deviceService.save(device);
		if(num==1){
			return new Data(1,"");
		}else{
			return new Data(0,"添加失败");
		}
	}
	
	@RequestMapping(value="/saveForeach", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveForeach(String filePath,Long channelId,String version){
		URL url;
		Data data = new Data(0,"");
		try {
//			filePath = "file:/D:/home/nginx/upload/tvimg/device/201312/1388045805371.csv";
			url = new URL(filePath);
			String fileContent = IOUtil.getFileString(url);
			if(fileContent==null||"".equals(fileContent)){
				data = new Data(0,"文件导入失败");
			}else{
				//文件内容转化成 list
				String[] lineContent = fileContent.split("\n");
				Device device = null;
				int loopTimes = 0;
				int max = 50;
				if(lineContent.length>max){
					loopTimes = lineContent.length/max+1;
				}else{
					max = lineContent.length;
				}
				for(int j=0;j<=loopTimes;j++){
					List<Device> list = new ArrayList<Device>();
					for(int i=0;i<max;i++){
						if((j*max+i)<lineContent.length){
							String[] field = lineContent[j*max+i].split(",");
							device = new Device();
							device.setDeviceId(field[0]);
							device.setDeviceMac(field[1]);
							device.setDeviceState(1);
							device.setDeviceCreateTime(DateUtil.getTimeStamp(new Date()));
							device.setDeviceVersion(version);
							device.setCpChannelId(channelId);
							list.add(device);
						}
					}
					if(list.size()>0){
						deviceService.saveForeach(list);
					}
					data = new Data(1,"");
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@RequestMapping(value="/deleteDevice", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteDevice(Device device){
		int num=deviceService.delete(device);
		if(num==1){
			return new Data(1,"");
		}else{
			return new Data(0,"删除失败");
		}
	}
	/**
	 * 查询未激活设备数
	 * @param device
	 * @param amount
	 * @return
	 */
	@RequestMapping(value="/countDevice", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data countDevice(){
		Data data = new Data();
		try {
			Integer amount = deviceService.countDevice();
			data.setCode(1);
			data.setObj(amount);
		} catch (Exception e) {
			e.printStackTrace();
			data.setCode(0);
		}
		return data;
	}
	/**
	 * 导出设备
	 * @param device
	 * @param amount
	 * @return
	 */
	@RequestMapping(value="/exportDevice", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ModelAndView exportDevice(DeviceVo device,int amount,HttpServletResponse response){
		Map<String,Object> model = new HashMap<String,Object>();        
        model.put("list", deviceService.exportDevice(device,amount));         
        return new ModelAndView(new ViewExcel(), model);
//		try {
//			mv.s
//			HSSFWorkbook wb = deviceService.exportDevice(device,amount);
//			response.setHeader("Content-Disposition", "attachment; filename=\"" + new Date()  + ".xlsx"); 
//			response.setContentType("APPLICATION/OCTET-STREAM"); 
//			//		    response.setContentType("application/octet-stream; charset=UTF-8");
//		    OutputStream ops = response.getOutputStream();
//		    wb.write(ops);
//		    ops.flush();
//		    ops.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
