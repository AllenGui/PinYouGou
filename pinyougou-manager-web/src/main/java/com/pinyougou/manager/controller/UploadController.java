package com.pinyougou.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import entity.CurrentResult;
import util.FastDFSClient;

/**
 * 
 * @ClassName: UploadController   
 * @Description: 图片上传控制器
 * @author: Focus
 * @date: 2018年7月28日 下午2:51:27   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
@RestController
public class UploadController {

	@Value("${FILE_SERVER_URL}")
	private String FILE_SERVER_URL;

	@RequestMapping("/upload")
	public CurrentResult upload(MultipartFile file) {
		// 获取文件名
		String filename = file.getOriginalFilename();
		// 得到扩展名
		String extName = filename.substring(filename.lastIndexOf(".") + 1);
		try {
			FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
			String fileId = client.uploadFile(file.getBytes(), extName);
			String url = FILE_SERVER_URL + fileId;
			return new CurrentResult(true, url);
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "上传失败!");
		}
	}

}
