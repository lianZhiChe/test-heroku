/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.pojo.Test;
import com.example.service.TestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lian
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	//创建Test表
	@RequestMapping("/CreateTables")
	public String CreateTables() {
		System.out.println("访问:test-CreateTables");
		testService.CreateTables();
		return "创建成功";
	}

	//添加数据
	@RequestMapping("/add")
	public String add(@RequestBody Test test) {
		System.out.println("访问:test-add");
		testService.add(test);
		return "添加成功";
	}

	//查询数据
	@RequestMapping("/findAll")
	public List<Test> findAll() {
		System.out.println("访问:test-findAll");
		return testService.findAll();
	}
}
