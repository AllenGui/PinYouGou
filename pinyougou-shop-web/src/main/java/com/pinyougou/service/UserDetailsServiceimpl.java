package com.pinyougou.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;

/**
 * 
 * @ClassName: UserDetailsServiceimpl   
 * @Description: 认证类 
 * @author: Focus
 * @date: 2018年7月22日 下午4:16:46   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
public class UserDetailsServiceimpl implements UserDetailsService {

	private SellerService sellerService;

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 构建角色列表
		List<GrantedAuthority> grantAuths = new ArrayList<>();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));
		// 得到商家对象
		TbSeller seller = sellerService.findSingle(username);
		if (null != seller) {
			if ("1".equals(seller.getStatus())) {
				return new User(username, seller.getPassword(), grantAuths);
			} else {
				return null;
			}
 		} else {
			return null;
		}
	}

}
