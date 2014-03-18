package com.gpower.common.dao;

import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Anonymity;

public interface AnonymityDao {
	public Anonymity save(Anonymity anonymity);
	
	public Anonymity update(Anonymity anonymity);
	
	public Anonymity getById(Long id); 
	
	public Anonymity getByDeviceId(String deviceId);

	public Page<Anonymity> getAnonymity(Page<Anonymity> page);
}
