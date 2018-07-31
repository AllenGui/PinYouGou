package com.pinyougou.content.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.pojo.TbContent;

import entity.CurrentResult;
import entity.PageResult;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbContent> findAll() {
		return contentService.findAll();
	}

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return contentService.findPage(page, rows);
	}

	/**
	 * 增加
	 * @param content
	 * @return
	 */
	@RequestMapping("/add")
	public CurrentResult add(@RequestBody TbContent content) {
		try {
			contentService.add(content);
			return new CurrentResult(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * @param content
	 * @return
	 */
	@RequestMapping("/update")
	public CurrentResult update(@RequestBody TbContent content) {
		try {
			contentService.update(content);
			return new CurrentResult(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "修改失败");
		}
	}

	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findSingle")
	public TbContent findSingle(Long id) {
		return contentService.findSingle(id);
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CurrentResult delete(Long[] ids) {
		try {
			contentService.delete(ids);
			return new CurrentResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "删除失败");
		}
	}

	/**
	* 查询+分页
	* @param brand
	* @param page
	* @param rows
	* @return
	*/
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbContent content, int page, int rows) {
		return contentService.findPage(content, page, rows);
	}

}
