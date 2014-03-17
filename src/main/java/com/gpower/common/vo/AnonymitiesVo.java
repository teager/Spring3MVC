package com.gpower.common.vo;

import java.util.List;

import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Anonymity;

public class AnonymitiesVo {

	private Long count;

	private List<Anonymity> anonymity;

	public AnonymitiesVo() {

	}

	public AnonymitiesVo(Page<Anonymity> page) {
		this.count = page.getTotalSize();
		this.anonymity = page.getResult();
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<Anonymity> getAnonymity() {
		return anonymity;
	}

	public void setAnonymity(List<Anonymity> anonymity) {
		this.anonymity = anonymity;
	}

}
