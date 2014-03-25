package com.gpower.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gpower.common.dao.AnonymityDao;
import com.gpower.common.dao.page.Page;
import com.gpower.common.dao.page.PageFilter;
import com.gpower.common.dao.page.PageOrder;
import com.gpower.common.entity.Anonymity;
import com.gpower.common.type.FreeType;

public class AnonymityDaoImpl implements AnonymityDao {

	private JdbcTemplate jdbcTemplate;

	protected class AnonymityMapper implements RowMapper<Anonymity> {

		public Anonymity mapRow(ResultSet rs, int rowNum) throws SQLException {
			Anonymity anonymity = new Anonymity();
			anonymity.setId(rs.getLong("id"));
			anonymity.setClientDeviceId(rs.getString("clientDeviceId"));
			anonymity.setClientDeviceName(rs.getString("clientDeviceName"));
			anonymity.setClientDeviceToken(rs.getString("clientDeviceToken"));
			anonymity.setLoginIp(rs.getString("loginIp"));
			anonymity.setClientOS(rs.getString("clientOS"));
			anonymity.setClientLang(rs.getString("clientLang"));
			anonymity.setProductID(rs.getString("productID"));
			anonymity.setProductVersion(rs.getString("productVersion"));
			anonymity.setFreeType(FreeType.fromInt(rs.getInt("freeType")));
			Timestamp timeStamp = rs.getTimestamp("createTime");
			if (timeStamp != null) {
				Calendar createTime = Calendar.getInstance();
				createTime.setTimeInMillis(timeStamp.getTime());
				anonymity.setCreateTime(createTime);
			}
			timeStamp = rs.getTimestamp("updateTime");
			if (timeStamp != null) {
				Calendar updateTime = Calendar.getInstance();
				updateTime.setTimeInMillis(timeStamp.getTime());
				anonymity.setUpdateTime(updateTime);
			}
			timeStamp = rs.getTimestamp("uninstallTime");
			if (timeStamp != null) {
				Calendar uninstallTime = Calendar.getInstance();
				uninstallTime.setTimeInMillis(timeStamp.getTime());
				anonymity.setUninstallTime(uninstallTime);
			}
			return anonymity;
		}
	}

	public Anonymity save(final Anonymity anonymity) {

		final String sql = "INSERT INTO anonymity "
				+ "(clientDeviceId, clientDeviceName, clientDeviceToken, loginIp, clientOS, clientLang, productID, productVersion, freeType, createTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			 @Override
	            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
	                PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	                int index = 1;
	                ps.setString(index, anonymity.getClientDeviceId());
	                ps.setString(++index, anonymity.getClientDeviceName());
	                ps.setString(++index, anonymity.getClientDeviceToken());
	                ps.setString(++index, anonymity.getLoginIp());
	                ps.setString(++index, anonymity.getClientOS());
	                ps.setString(++index, anonymity.getClientLang());
	                ps.setString(++index, anonymity.getProductID());
	                ps.setString(++index, anonymity.getProductVersion());
	                ps.setInt(++index, anonymity.getFreeType().ordinal());
	                ps.setTimestamp(++index, new Timestamp(Calendar.getInstance().getTimeInMillis()));
	                return ps;
	            }
		}, keyHolder);
		
//		jdbcTemplate.update(
//				sql,
//				new Object[] { anonymity.getClientDeviceId(), anonymity.getClientDeviceName(),
//						anonymity.getClientDeviceToken(), anonymity.getLoginIp(), anonymity.getClientOS(),
//						anonymity.getClientLang(), anonymity.getProductID(), anonymity.getProductVersion(), anonymity.getFreeType().ordinal(),
//						Calendar.getInstance()}, keyHolder);
		anonymity.setId(keyHolder.getKey().longValue());
		return anonymity;
	}

	public Anonymity getByDeviceId(String deviceId) {
		String sql = "SELECT * FROM anonymity WHERE clientDeviceId = ?";
		List<Anonymity> result = jdbcTemplate.query(sql, new Object[] { deviceId }, new AnonymityMapper());
		if (result.isEmpty()) {
			return null;
		} else if (result.size() == 1) { // list contains exactly 1 element
			return result.get(0);
		} else {
			throw new RuntimeException("duplicate deviceId" + deviceId + "in DB");
		}
	}

	public Anonymity getById(Long id) {
		String sql = "SELECT * FROM anonymity WHERE id = ?";
		List<Anonymity> result = jdbcTemplate.query(sql, new Object[] { id }, new AnonymityMapper());
		if (result.isEmpty()) {
			return null;
		} else if (result.size() == 1) { // list contains exactly 1 element
			return result.get(0);
		} else {
			throw new RuntimeException("duplicate deviceId" + id + "in DB");
		}
	}

	public Page<Anonymity> getAnonymity(Page<Anonymity> page) {
		PageOrder order = page.getPageOrder();
		PageFilter filter = page.getPageFilter();
		String querySql = "SELECT * FROM anonymity a WHERE true";
		String countSql = "SELECT count(*) FROM anonymity a WHERE true";

		if (filter.has("productID")) {
			querySql += " and a.productID = " + filter.getString("productID");
			countSql += " and a.productID = " + filter.getString("productID");
		}

		if ("id".equals(order.getName())) {
			querySql += " order by a.id desc";
		} else if ("updateTime".equals(order.getName())) {
			querySql += " order by u.updateTime desc";
		}

		List<Anonymity> result = jdbcTemplate.query(querySql + " limit ?, ?", new Object[] { page.getStartPosition(),
				page.getPageSize() }, new AnonymityMapper());

		Long count = jdbcTemplate.queryForObject(countSql, Long.class);

		if (!result.isEmpty()) {
			page.setResult(result);
		}
		page.setTotalSize(count);
		return page;
	}

	public Anonymity update(Anonymity anonymity) {
		String sql = "UPDATE anonymity SET clientDeviceId=?, clientDeviceName=?, clientDeviceToken=?, loginIp=?, clientOS=?, clientLang=?, productID=?, productVersion=?, freeType=?, createTime=?, updateTime=?, uninstallTime=?";
		jdbcTemplate.update(
				sql,
				new Object[] { anonymity.getClientDeviceId(), anonymity.getClientDeviceName(),
						anonymity.getClientDeviceToken(), anonymity.getLoginIp(), anonymity.getClientOS(),
						anonymity.getClientLang(), anonymity.getProductID(), anonymity.getProductVersion(),
						anonymity.getFreeType().ordinal(), anonymity.getCreateTime(), Calendar.getInstance(),
						anonymity.getUninstallTime() });

		return anonymity;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
