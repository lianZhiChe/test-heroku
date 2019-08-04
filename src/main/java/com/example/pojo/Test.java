/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author lian
 */
@Entity
@Table(name = "test")
public class Test {

	//id
	@Id
	private String id;

	//名字
	private String name;

	//年龄
	private int age;

	//性别 1 == 男  2 == 女
	private int gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Test{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + '}';
	}

}
