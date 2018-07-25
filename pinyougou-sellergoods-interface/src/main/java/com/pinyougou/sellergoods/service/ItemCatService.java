package com.pinyougou.sellergoods.service;
import java.util.List;
import com.pinyougou.pojo.TbItemCat;

import entity.PageResult;
/**
 * 
 * @ClassName: ItemCatService   
 * @Description: 商品分类
 * @author: Focus
 * @date: 2018年7月25日 下午8:08:51   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
public interface ItemCatService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbItemCat> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbItemCat itemCat);
	
	
	/**
	 * 修改
	 */
	public void update(TbItemCat itemCat);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbItemCat findSingle(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbItemCat itemCat, int pageNum,int pageSize);
	
	/**
	 * 
	 * @Title: findByParentId   
	 * @Description: 根据上级id查询分类列表   
	 * @param parentId
	 * @return: List<TbItemCat>     
	 * @author: Focus
	 * @date: 2018年7月25日下午8:10:06
	 */
	public List<TbItemCat> findByParentId(long parentId);
	
}
