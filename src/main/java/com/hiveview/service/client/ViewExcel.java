package com.hiveview.service.client;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.hiveview.entity.client.DeviceLog;
@Component
public class ViewExcel extends AbstractExcelView{

	
	@Autowired
	private DeviceService deviceService;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyyMMdd-hhmmss");
		String dataTime = format.format(new Date());
		String excelName = dataTime+".xls";  
        // 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开  
        response.setContentType("APPLICATION/OCTET-STREAM");  
        response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(excelName, "UTF-8"));
        
        @SuppressWarnings("unchecked")
		List<DeviceLog> deviceVoList = (List<DeviceLog>) model.get("list");
        
        HSSFSheet sheet = workbook.createSheet("设备信息表"); //产生工作表对象
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		
		//创建标题行
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("SN号");//device_sn
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("MAC地址");//device_mac
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("设备版本");//device_version
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("生产商ID");//cp_id
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("生产商");//cp_name
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("硬件型号ID");//hardware_id
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("硬件型号");//hardware_no
		cell.setCellStyle(style);
		cell = row.createCell(7);
		cell.setCellValue("渠道ID");//cp_channel_id
		cell.setCellStyle(style);
		cell = row.createCell(8);
		cell.setCellValue("渠道");//cp_channel_name
		cell.setCellStyle(style);
		cell = row.createCell(9);
		cell.setCellValue("ROM版本");//rom_version
		cell.setCellStyle(style);
		
		for (int i = 0; i < deviceVoList.size(); i++){
			row = sheet.createRow(i + 1);
			DeviceLog temp = deviceVoList.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(temp.getDeviceSn());
			row.createCell(1).setCellValue(temp.getDeviceMac());
			row.createCell(2).setCellValue(temp.getDeviceVersion());
			row.createCell(3).setCellValue(temp.getCpId());
			row.createCell(4).setCellValue(temp.getCpName());
			row.createCell(5).setCellValue(temp.getHardwareId());
			row.createCell(6).setCellValue(temp.getHardwareNo());
			row.createCell(7).setCellValue(temp.getCpChannelId());
			row.createCell(8).setCellValue(temp.getCpChannelName());
			row.createCell(9).setCellValue(temp.getRomVersion());
		}
	}

}
