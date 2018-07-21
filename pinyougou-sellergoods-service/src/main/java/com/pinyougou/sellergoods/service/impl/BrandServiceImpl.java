package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		List<TbBrand> list = brandMapper.selectByExample(null);
		return list;
	}

	@Override
	public PageResult findPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		Page<TbBrand> pageList = (Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(pageList.getTotal(), pageList.getResult());
	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}

	@Override
	public TbBrand findSingle(Long id) {
		TbBrand brand = brandMapper.selectByPrimaryKey(id);
		return brand;
	}

	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbBrand brand, int page, int rows) {
		PageHelper.startPage(page, rows);
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if (null != brand) {
			if (StringUtils.isNotEmpty(brand.getName())) {
				criteria.andNameLike("%" + brand.getName() + "%");
			}
			if (StringUtils.isNotEmpty(brand.getFirstChar())) {
				criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
			}
		}
		Page<TbBrand> pageList = (Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(pageList.getTotal(), pageList.getResult());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> selectOptionList() {		
		return brandMapper.selectOptionList();
	}

}
