/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.pojo.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lian
 */
public interface TestDao extends JpaRepository<Test, String> {

}
