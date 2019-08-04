/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.dao.TestDao;
import com.example.pojo.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lian
 */
@Service
public class TestService {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private TestDao testDao;

	//创建Test表
	public void CreateTables() {
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS test (id varchar(50),name varchar(50),age int,gender int)");
		} catch (Exception e) {
			System.out.println("Dao-CreateTables:" + e.getMessage());
		}
	}

	//添加数据
	public void add(Test test) {
//		System.out.println("add-test:" + test.toString());
//		try (Connection connection = dataSource.getConnection()) {
//			Statement stmt = connection.createStatement();
//			String id = test.getId();
//			String name = test.getName();
//			int age = test.getAge();
//			int gender = test.getGender();
////			String sql = "INSERT INTO test VALUES ('1','LIAN',18,1)";
//			String sql = "INSERT INTO test VALUES ('"+id+"','"+name+"',"+age+","+gender+")";
//			stmt.executeUpdate(sql);
//		} catch (Exception e) {
//			System.out.println("Dao-add:" + e.getMessage());
//		}
		testDao.save(test);
	}

	//查询数据
	public List<Test> findAll() {
//		try (Connection connection = dataSource.getConnection()) {
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT id,name,age,gender FROM test");
//			System.out.println("findAll--:" + rs.toString());
//			List<Test> list = new ArrayList<>();
//			while (rs.next()) {
//				Test test = new Test();
//				test.setId(rs.getString("id"));
//				test.setName(rs.getString("name"));
//				test.setAge(rs.getInt("age"));
//				test.setGender(rs.getInt("gender"));
//				list.add(test);
//			}
//			return list;
//		} catch (Exception e) {
//			System.out.println("Dao-add:" + e.getMessage());
//			return new ArrayList<>();
//		}
		return testDao.findAll();
	}
}
