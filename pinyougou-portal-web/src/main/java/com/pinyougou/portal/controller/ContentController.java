package com.pinyougou.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.pojo.TbContent;

/**
 * 
 * @ClassName: ContentController   
 * @Description: TODO 
 * @author: Focus
 * @date: 2018年8月4日 上午9:48:20   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;

	@RequestMapping("/findByCategoryId")
	public List<TbContent> findByCategoryId(Long categoryId) {
		return contentService.findByCategoryId(categoryId);
	}

}
