package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 
 * @ClassName: BrandService   
 * @Description: 品牌接口 
 * @author: Focus
 * @date: 2018年7月15日 下午9:46:08   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
public interface BrandService {

	/**
	 * 
	 * @Title: findAll   
	 * @Description: TODO   
	 * @return: List<TbBrand>     
	 * @author: Focus
	 * @date: 2018年7月17日下午8:04:06
	 */
	public List<TbBrand> findAll();

	/**
	 * 
	 * @Title: findPage   
	 * @Description: 品牌分页
	 * @param page 当前页面
	 * @param rows 每页记录数
	 * @return: PageResult     
	 * @author: Focus
	 * @date: 2018年7月17日下午8:04:33
	 */
	public PageResult findPage(int page, int rows);

	/**
	 * 
	 * @Title: add   
	 * @Description: TODO   
	 * @param brand: void     
	 * @author: Focus
	 * @date: 2018年7月17日下午8:39:10
	 */
	public void add(TbBrand brand);

	/**
	 * 
	 * @Title: findSingle   
	 * @Description: 根据id查找实体   
	 * @param id
	 * @return: TbBrand     
	 * @author: Focus
	 * @date: 2018年7月17日下午9:23:30
	 */
	public TbBrand findSingle(Long id);

	/**
	 * 
	 * @Title: update   
	 * @Description: 修改实体   
	 * @param brand: void     
	 * @author: Focus
	 * @date: 2018年7月17日下午9:24:24
	 */
	public void update(TbBrand brand);
	
	/**
	 * 
	 * @Title: delete   
	 * @Description: 删除   
	 * @param ids: void     
	 * @author: Focus
	 * @date: 2018年7月17日下午10:01:56
	 */
	public void delete(Long[] ids);
	
	/**
	 * 
	 * @Title: findPage   
	 * @Description: 查询   
	 * @param brand
	 * @param page
	 * @param rows
	 * @return: PageResult     
	 * @author: Focus
	 * @date: 2018年7月17日下午11:07:47
	 */
	public PageResult findPage(TbBrand brand, int page, int rows);
	
	/**
	 * 
	 * @Title: selectOptionList   
	 * @Description: 返回下拉列表数据 
	 * @return: List<Map>     
	 * @author: Focus
	 * @date: 2018年7月21日下午8:53:23
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> selectOptionList();
}
