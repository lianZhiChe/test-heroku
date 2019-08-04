/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.pojo.Provinces;
import com.example.service.ProvincestService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lian
 */
@RestController
@RequestMapping("/provinces")
public class ProvincesController {

	@Autowired
	private ProvincestService provincesService;

	@RequestMapping("/findAll")
	public List<Provinces> findAll() {
		return provincesService.findAll();
	}

	@Autowired
	private DataSource dataSource;

	@RequestMapping("/db")
	String db(Map<String, Object> model) {
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
			stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
			ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

			ArrayList<String> output = new ArrayList<String>();
			while (rs.next()) {
				output.add("练String: " + rs.getTimestamp("tick"));
			}
			model.put("records", output);
			return output.toString();
		} catch (Exception e) {
			model.put("message", e.getMessage());
			return "error";
		}
	}

}
