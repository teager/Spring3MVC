package com.gpower.common.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpower.common.api.exceptions.NotAuthException;
import com.gpower.common.api.exceptions.NotFoundException;
import com.gpower.common.dao.AnonymityDao;
import com.gpower.common.dao.BannerDao;
import com.gpower.common.dao.ProductDao;
import com.gpower.common.dao.PropertyDao;
import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Banner;
import com.gpower.common.entity.Product;
import com.gpower.common.utils.SessionUtils;
import com.gpower.common.vo.BannersVo;
import com.gpower.common.vo.ProductsVo;

@Controller
@RequestMapping("/systems")
public class SystemApi {

	static final Logger logger = LoggerFactory.getLogger(SystemApi.class);

	@Autowired
	private AnonymityDao anonymityDao;

	@Autowired
	private PropertyDao gpPropertyDao;

	@Autowired
	private BannerDao bannerDao;

	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody
	ProductsVo getProductList(@RequestParam(required = false) String session) {
		Long anonymityId = SessionUtils.getAnonymityId(session);
		if (anonymityId == null) {
			throw new NotAuthException(session);
		}
		Anonymity anonymity = anonymityDao.getById(anonymityId);
		if (anonymity == null) {
			throw new NotFoundException("anonymity is null", "null");
		}
		List<Product> products = productDao.getProduct(new Page<Product>());
		return new ProductsVo(products, anonymity);

	}

	@ResponseBody
	@RequestMapping(value = "/banners", method = RequestMethod.GET)
	public BannersVo getBanners(@RequestParam(required = false) String session) {
		Long anonymityId = SessionUtils.getAnonymityId(session);
		if (anonymityId == null) {
			throw new NotAuthException(session);
		}
		Anonymity anonymity = anonymityDao.getById(anonymityId);
		if (anonymity == null) {
			throw new NotFoundException("anonymity is null", "null");
		}
		Page<Banner> page = new Page<Banner>();
		page.getPageFilter().add("status", "0");
		List<Banner> banners = bannerDao.getBanner(new Page<Banner>());
		return new BannersVo(banners, anonymity);
	}

}