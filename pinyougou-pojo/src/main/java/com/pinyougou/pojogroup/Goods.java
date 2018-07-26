package com.pinyougou.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

/**
 * 
 * @ClassName: Goods   
 * @Description: 商品组合实体类 
 * @author: Focus
 * @date: 2018年7月26日 下午8:31:34   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
public class Goods implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO  
	 */
	private static final long serialVersionUID = 1186417220866775950L;

	private TbGoods goods;// 商品SPU基本信息
	private TbGoodsDesc goodsDesc;// 商品SPU扩展信息
	private List<TbItem> itemList;// 商品SKU列表

	public TbGoods getGoods() {
		return goods;
	}

	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}

	public TbGoodsDesc getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(TbGoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public List<TbItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}

}
