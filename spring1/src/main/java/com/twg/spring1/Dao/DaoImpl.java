package com.twg.spring1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import com.twg.spring1.Entities.User;

@Component
public class DaoImpl implements Dao {

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}

