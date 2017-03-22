package com.hiveview.action.matrix;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.bo.Data;
import com.hiveview.service.bitmatrix.MatrixtToImgService;

@Controller
@RequestMapping("/matrix")
public class MatrixAction {

	@Autowired
	private MatrixtToImgService matrixtToImgService;

	@RequestMapping("/create")
	@ResponseBody
	public Data createMatrixUrl(HttpServletRequest request,
			String contentUrl) {
		Data data = new Data();
		try {
			String requestUrl = request.getScheme() + "://" + request.getServerName();// 访问路径：http://localhost
			URL serverPath = this.getClass().getResource("/img/douban.PNG");
			String imgUrl = matrixtToImgService.createMatrixWithLogo(requestUrl, serverPath, contentUrl);
			data.setCode(1);
			data.setObj(imgUrl);
		} catch (Exception e) {
			e.printStackTrace();
			data.setCode(0);
		}
		return data;
	}
}
