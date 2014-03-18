package com.gpower.common.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gpower.common.dao.BannerDao;
import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Banner;
import com.gpower.common.type.BannerType;
import com.gpower.common.type.BooleanType;

public class BannerDaoImpl implements BannerDao {

	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_BANNER = "INSERT INTO banner(productId, appStoreId, imageUrl, bannerType, status) VALUES(?,?,?,?,?)";
	private static final String UPDATE_BANNER = "UPDATE banner SET status=? WHERE id=?";

	private static final Logger logger = LoggerFactory.getLogger(BannerDaoImpl.class);

	protected class BannerMapper implements RowMapper<Banner> {
		public Banner mapRow(ResultSet rs, int rowNum) throws SQLException {
			Banner banner = new Banner();
			banner.setId(rs.getLong("id"));
			banner.setProductId(rs.getString("productId"));
			banner.setAppStoreId(rs.getString("appStoreId"));
			banner.setImageUrl(rs.getString("imageUrl"));
			banner.setBannerType(BannerType.fromInt(rs.getInt("bannerType")));
			banner.setStatus(BooleanType.fromInt(rs.getInt("status")));
			return banner;
		}
	}

	public Banner save(Banner banner) {
		logger.info("insert a new banner!");
		jdbcTemplate.update(
				INSERT_BANNER,
				new Object[] { banner.getProductId(), banner.getAppStoreId(), banner.getImageUrl(),
						banner.getImageUrl(), banner.getBannerType(), banner.getStatus() });
		return banner;
	}

	public Banner updateBanner(Banner banner) {
		jdbcTemplate.update(UPDATE_BANNER, new Object[] { banner.getStatus(), banner.getId() });
		return banner;
	}

	public List<Banner> getBanner(Page<Banner> page) {
		String querySql = "SELECT * FROM banner b WHERE true";
		if (page.getPageFilter().has("status")) {
			querySql += " and b.status = " + page.getPageFilter().getString("status");
		}

		if ("id".equals(page.getPageOrder().getName())) {
			querySql += " order by a.id desc";
		} else if ("updateTime".equals(page.getPageOrder().getName())) {
			querySql += " order by u.updateTime desc";
		}

		List<Banner> result = jdbcTemplate.query(querySql + " limit ?, ?",
				new Object[] { page.getStartPosition(), page.getPageSize() }, new BannerMapper());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
