package com.jane.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.Book;

public interface BookDao {
	//ВщевЫљга
	public ArrayList<Book> findAll() throws SQLException;
}
