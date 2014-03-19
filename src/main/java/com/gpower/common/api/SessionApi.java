package com.gpower.common.api;

import java.util.Calendar;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpower.common.api.exceptions.NotFoundException;
import com.gpower.common.dao.AnonymityDao;
import com.gpower.common.dao.PropertyDao;
import com.gpower.common.dao.page.Page;
import com.gpower.common.dto.AnonymityDto;
import com.gpower.common.entity.Anonymity;
import com.gpower.common.type.FreeType;
import com.gpower.common.utils.FreePeriodUtils;
import com.gpower.common.vo.AnonymitiesVo;
import com.gpower.common.vo.SessionVo;

@Controller
@RequestMapping("/sessions")
public class SessionApi {

	static final Logger logger = LoggerFactory.getLogger(SessionApi.class);

	@Autowired
	private AnonymityDao anonymityDao;

	@Autowired
	private PropertyDao gpPropertyDao;

	@ResponseBody
	@RequestMapping(value = "test/{name}", method = RequestMethod.GET)
	public Anonymity getShopInJSON(@PathVariable String name) {

		Anonymity anonymity = new Anonymity();
		anonymity.setClientDeviceId("deviceId");
		anonymity.setClientDeviceName("deviceName");
		anonymity.setCreateTime(Calendar.getInstance());
		anonymityDao.save(anonymity);

		return anonymity;

	}

	@ResponseBody
	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public AnonymitiesVo getDevice(@RequestParam Map<String, String> allRequestParams) {
		Page<Anonymity> page = new Page<Anonymity>(allRequestParams);
		page = anonymityDao.getAnonymity(page);
		return new AnonymitiesVo(page);

	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public SessionVo postAnonymity(@RequestBody AnonymityDto dto) {
		if (dto.getClientDeviceId() == null) {
			throw new NotFoundException("deviceId is null", "null");
		}

		Map<String, String> properties = gpPropertyDao.getProperty();
		Anonymity anonymity = anonymityDao.getByDeviceId(dto.getClientDeviceId());
		if (anonymity != null) {
			anonymity = dto.toObject(anonymity);
			anonymityDao.update(anonymity);
		} else {
			anonymity = dto.toObject(new Anonymity());
			String freePeriods = properties.get(anonymity.getProductID() + "freePeriods");
			if (freePeriods == null) {
				anonymity.setFreeType(FreeType.EVER);
			} else if (FreePeriodUtils.isFreePeriod(freePeriods)) {
				anonymity.setFreeType(FreeType.PERIOD_FREE);
			} else {
				anonymity.setFreeType(FreeType.PAYMENT);
			}
			anonymity = anonymityDao.save(anonymity);
		}

		SessionVo session = new SessionVo(properties, anonymity, dto);
		return session;

	}

}