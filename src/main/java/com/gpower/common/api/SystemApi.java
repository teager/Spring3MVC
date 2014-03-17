package com.gpower.common.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpower.common.dao.AnonymityDao;
import com.gpower.common.dao.PropertyDao;
import com.gpower.common.entity.Banner;
import com.gpower.common.entity.Product;

@Controller
@RequestMapping("/systems")
public class SystemApi {

	static final Logger logger = LoggerFactory.getLogger(SystemApi.class);

	@Autowired
	private AnonymityDao anonymityDao;

	@Autowired
	private PropertyDao gpPropertyDao;

	@ResponseBody
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public Product getProductList(@RequestParam String session) {
		Product product = new Product();
		return product;

	}

	@ResponseBody
	@RequestMapping(value = "/banners", method = RequestMethod.GET)
	public Banner getBanners(@RequestParam String session) {
		Banner banner= new Banner();
		return banner;
	}

}