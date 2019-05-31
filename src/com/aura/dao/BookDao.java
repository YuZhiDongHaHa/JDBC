package com.aura.dao;

import java.util.List;

import com.aura.entity.Book;

/**
 * 用户表数据的增删改查操作
 * @author Administrator
 *
 */
public interface BookDao {
	//查询
	public List<Book> getBook();
	//模糊查询
	public List<Book> getBook(String name);
	//增
	public Integer addBook(Book book);
	
	//删除
	public  int delBook(int sid);
	//更新
	public int update(Book book);
	//登录
//	public boolean login(int bid,String psd);
}
