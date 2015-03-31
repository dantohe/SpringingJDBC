package com.danielantohe.refressher.spring.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.danielantohe.refressher.spring.jdbc.dto.DTO;
import com.danielantohe.refressher.spring.jdbc.dto.DTOMapper;

public class DAO implements IDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertRecords(String name, Integer value, String id) {
		String SQL = "insert into name_records (name, value, id) values (?, ?, ?)";

		jdbcTemplateObject.update(SQL, name, value, id);
		System.out.println("Insert Record Name = " + name + " Value = " + value
				+ " Id = " + id);
		return;
	}

	public List<DTO> getRecordsForId(String id) {
		String SQL = "select * from name_records where id = ?";
		List<DTO> records = jdbcTemplateObject.query(SQL,
				new Object[] { id }, new DTOMapper());
		return records;
	}

	public List<DTO> listRecords() {
		String SQL = "select * from name_records";
		List<DTO> records = jdbcTemplateObject.query(SQL,
				new DTOMapper());
		return records;
	}

	public void delete(Integer id) {
		String SQL = "delete from name_records where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	public void update(Integer id, Integer value) {
		String SQL = "update name_records set value = ? where id = ?";
		jdbcTemplateObject.update(SQL, value, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

}