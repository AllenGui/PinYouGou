package com.pinyougou.manager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojogroup.Goods;
import com.pinyougou.sellergoods.service.GoodsService;

import entity.PageResult;
import entity.CurrentResult;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public CurrentResult update(@RequestBody Goods goods){
		try {
			goodsService.update(goods);
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
	public Goods findSingle(Long id){
		return goodsService.findSingle(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public CurrentResult delete(Long [] ids){
		try {
			goodsService.delete(ids);
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
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		return goodsService.findPage(goods, page, rows);		
	}

	/**
	 * 
	 * @Title: updateStatus   
	 * @Description: 批量修改状态  
	 * @param ids
	 * @param status
	 * @return: CurrentResult     
	 * @author: Focus
	 * @date: 2018年7月29日下午4:44:48
	 */
	@RequestMapping("/updateStatus")
	public CurrentResult updateStatus(Long[] ids, String status) {
		try {
			goodsService.updateStatus(ids, status);
			return new CurrentResult(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "失败");
		}
	}
	
}
