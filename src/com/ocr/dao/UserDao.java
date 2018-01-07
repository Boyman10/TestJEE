package com.ocr.dao;

import java.util.List;

import com.ocr.beans.User;

public interface UserDao {
	void add( User user ) throws DaoException;
	List<User> list() throws DaoException;
}