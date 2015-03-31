package com.danielantohe.refressher.spring.jdbc.mainapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danielantohe.refressher.spring.jdbc.dao.DAO;
import com.danielantohe.refressher.spring.jdbc.dto.DTO;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");

		DAO dao = (DAO) context.getBean("DAO");

		System.out.println("------insert records--------");
		dao.insertRecords("hkjhkjh", 11, "1");
		dao.insertRecords("kljklj", 2, "2");
		dao.insertRecords("kljkljkls", 15, "3");

		System.out.println("------Retriving Records--------");
		List<DTO> semiComplexRecords = dao.listRecords();
		for (DTO record : semiComplexRecords) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Value : " + record.getValue());
		}

		System.out.println("----Updating Records  -----");
		dao.update(2, 20);

		System.out.println("----Listing Record with ID = 2 -----");
		List<DTO> records = dao.getRecordsForId("2");
		for (DTO record : records) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getValue());
		}

	}
}