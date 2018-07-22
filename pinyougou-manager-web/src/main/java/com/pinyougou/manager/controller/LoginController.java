package com.pinyougou.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @ClassName: LoginController   
 * @Description: TODO 
 * @author: Focus
 * @date: 2018年7月22日 下午1:34:00   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/name")
	public Map getName() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map map = new HashMap<>();
		map.put("loginName", name);
		return map;
	}

}
