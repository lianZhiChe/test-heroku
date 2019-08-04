/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.pojo.Provinces;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author lian
 */
@Service
public class ProvincestService {

	//获取所有
	public List<Provinces> findAll() {
		List<Provinces> list = new ArrayList<>();
		Provinces provinces = new Provinces();
		provinces.setId(1);
		provinces.setProvince("应用");
		provinces.setProvinceid("23444");
		list.add(provinces);
		return list;
	}

}
