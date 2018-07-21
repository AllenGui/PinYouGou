package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.CurrentResult;
import entity.PageResult;

/**
 * 
 * @ClassName: BrandController   
 * @Description: TODO 
 * @author: Focus
 * @date: 2018年7月21日 下午8:54:55   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		List<TbBrand> list = brandService.findAll();
		return list;
	}

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		PageResult pageResult = brandService.findPage(page, rows);
		return pageResult;
	}

	@RequestMapping("/add")
	public CurrentResult add(@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new CurrentResult(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "新增失败");
		}
	}

	@RequestMapping("/findSingle")
	public TbBrand findSingle(Long id) {
		TbBrand brand = brandService.findSingle(id);
		return brand;
	}

	@RequestMapping("/update")
	public CurrentResult update(@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new CurrentResult(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public CurrentResult delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new CurrentResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrentResult(false, "删除失败");
		}
	}
	
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand, int page, int rows) {
		PageResult result = brandService.findPage(brand, page, rows);
		return result;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList() {
		return brandService.selectOptionList();
	}

}
