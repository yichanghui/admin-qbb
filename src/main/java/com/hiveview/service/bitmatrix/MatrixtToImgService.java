package com.hiveview.service.bitmatrix;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

import org.springframework.stereotype.Service;

import com.google.zxing.common.BitMatrix;
import com.hiveview.common.Constants;
import com.hiveview.util.FilePathUtil;

@Service
public class MatrixtToImgService {
//	private String url = "http://124.207.119.78/tvimg/jstx0000/8e26eb39-1b8c-4c65-a388-779cd873485c.jpg";

	/**
	 * @param contentUrl 生成二维码的URL
	 * @param logoImgUrl 中间LOGO的URL
	 * @param width 二维码的宽度
	 * @param height 二维码的高度
	 * @return
	 */
	public String createMatrixWithLogo(String basePath,URL serverPath,String contentUrl) throws Exception{
		BitMatrix matrix = MatrixToImageWriterEx.createQRCode(contentUrl, Constants.MATRIX_WIDTH, Constants.MATRIX_HEIGHT);
		MatrixToLogoImageConfig logoConfig = new MatrixToLogoImageConfig(Color.WHITE, Constants.MATRIX_LOGO_SIZE);
		String propPath = FilePathUtil.getPathForProperties(Constants.MATRIX_OUT_PATH_KEY);
		String realPath = FilePathUtil.mkdir(propPath,2);
		String extName = Constants.MATRIX_IMG_SUFFIX;// 扩展名
		String newFileName= System.currentTimeMillis() + "." + extName;//新文件名
		MatrixToImageWriterEx.writeToFile(matrix, extName, realPath+File.separator+newFileName, serverPath, logoConfig);
		return URLDecoder.decode(FilePathUtil.getVisitPath(propPath, basePath, realPath, newFileName),"UTF-8");
	}
	/**
	 * @param contentUrl 生成二维码的URL
	 * @param width 二维码的宽度
	 * @param height 二维码的高度
	 * @return
	 */
	public String createMatrix(String basePath,String contentUrl){
		BitMatrix matrix = MatrixToImageWriterEx.createQRCode(contentUrl, Constants.MATRIX_WIDTH, Constants.MATRIX_HEIGHT);
		String outUrl = "";
		try {
			String propPath = FilePathUtil.getPathForProperties(Constants.MATRIX_OUT_PATH_KEY);
			String realPath = FilePathUtil.mkdir(propPath,2);
			String extName = "jpg";// 扩展名
			String newFileName= System.currentTimeMillis() + "." + extName;//新文件名
			File localFile =new File(realPath+File.separator+newFileName);
			MatrixToImageWriter.writeToFile(matrix, extName, localFile, new MatrixToImageConfig());
			outUrl = URLDecoder.decode(FilePathUtil.getVisitPath(propPath, basePath, realPath, newFileName),"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outUrl;
	}
}
