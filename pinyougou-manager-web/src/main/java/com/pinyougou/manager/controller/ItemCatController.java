package com.pinyougou.manager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;

import entity.PageResult;
import entity.CurrentResult;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

	@Reference
	private ItemCatService itemCatService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbItemCat> findAll(){			
		return itemCatService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return itemCatService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/add")
	public CurrentResult add(@RequestBody TbItemCat itemCat){
		try {
			itemCatService.add(itemCat);
			return new CurrentResult(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/update")
	public CurrentResult update(@RequestBody TbItemCat itemCat){
		try {
			itemCatService.update(itemCat);
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
	public TbItemCat findSingle(Long id){
		return itemCatService.findSingle(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CurrentResult delete(Long [] ids){
		try {
			itemCatService.delete(ids);
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
	public PageResult search(@RequestBody TbItemCat itemCat, int page, int rows  ){
		return itemCatService.findPage(itemCat, page, rows);		
	}
	
	/**
	 * 
	 * @Title: findByParentId   
	 * @Description: 根据上级id查询商品分类列表 
	 * @param parentId
	 * @return: List<TbItemCat>     
	 * @author: Focus
	 * @date: 2018年7月25日下午8:16:21
	 */
	@RequestMapping("/findByParentId")
	public List<TbItemCat> findByParentId(long parentId) {
		return itemCatService.findByParentId(parentId);
	}
	
}
