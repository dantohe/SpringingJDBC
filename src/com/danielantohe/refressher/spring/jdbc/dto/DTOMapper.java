package com.danielantohe.refressher.spring.jdbc.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DTOMapper implements RowMapper<DTO> {
	public DTO mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		DTO record = new DTO();
		record.setId(rs.getInt("id"));
		record.setName(rs.getString("name"));
		record.setValue(rs.getInt("value"));
		return record;
	}
}
