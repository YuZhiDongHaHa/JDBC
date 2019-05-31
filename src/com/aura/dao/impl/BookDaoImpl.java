package com.aura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aura.dao.BookDao;
import com.aura.entity.Book;
import com.aura.util.JdbcUtil;

public class BookDaoImpl implements BookDao {
	// 查询
	@Override
	public List<Book> getBook() {
		List<Book> list = new ArrayList<>();
		Book book = new Book();
		Connection connection = null;
		String sql = "select * from book";
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			connection = JdbcUtil.getConnection();
			stat = connection.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				Integer bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String author = rs.getString("author");
				String p = rs.getString("price");
				int price = Integer.parseInt(p);
				book.setBid(bid);
				book.setBname(bname);
				book.setAuthor(author);
				book.setPrice(price);
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, stat, rs);
		}
		return list;
	}

	// 模糊查询
	@Override
	public List<Book> getBook(String name) {
		List<Book> list = new ArrayList<Book>();
		Book book = new Book();
		String sql = "select * from book where bname like ?";
		Connection connection = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			connection = JdbcUtil.getConnection();

			stat = connection.prepareStatement(sql);
			stat.setString(1, "%" + name + "%");
			res = stat.executeQuery();
			while (res.next()) {
				int num = res.getInt("bid");
				String bname = res.getString("bname");
				String author = res.getString("author");
				String p = res.getString("price");
				int price = Integer.parseInt(p);
				book.setBid(num);
				book.setBname(bname);
				book.setAuthor(author);
				book.setPrice(price);
				list.add(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JdbcUtil.closeAll(connection, stat, res);
		}
		return list;
	}

	// 增加
	@Override
	public Integer addBook(Book b1) {
		Connection connection = null;
		PreparedStatement stat = null;
		String sql = "insert into book values(?,?,?,?)";
		int n = 0;
		try {
			connection = JdbcUtil.getConnection();
			stat = connection.prepareStatement(sql);

			stat.setInt(1, b1.getBid());
			stat.setString(2, b1.getBname());
			stat.setString(3, b1.getAuthor());
			stat.setInt(4, b1.getPrice());
			n = stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, stat);
		}
		return n;
	}

	// 删除
	@Override
	public int delBook(int sid) {
		int num = 0;
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement stat = null;
		try {
			String sql = "delete from book where bid=?";
			stat = connection.prepareStatement(sql);
			stat.setInt(1, sid);
			num = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, stat);

		}

		return num;
	}

	// 更新
	@Override
	public int update(Book b) {
		int num = 0;
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement stat = null;
		String sql = "update book set bname=?,author=?,price=? where bid=?";
		try {
			stat = connection.prepareStatement(sql);
			stat.setString(1, b.getBname());
			stat.setString(2, b.getAuthor());
			stat.setInt(3, b.getPrice());
			stat.setInt(4, b.getBid());
			num = stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, stat);

		}
		return num;
	}

	// 登录验证
//	@Override
//	public boolean login(int bid, String psd) {
//		boolean flag = false;
//		ResultSet rs = null;
//		PreparedStatement stat = null;
//		Connection connection = JdbcUtil.getConnection();
//		String sql = "SELECT * from book where (select psd from book where bid= ?)=?";
//		try {
//			stat = connection.prepareStatement(sql);
//			stat.setInt(1, bid);
//			stat.setString(2, psd);
//			rs = stat.executeQuery();
//			if (rs.next())
//				flag = true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.closeAll(connection, stat, rs);
//		}
//		return flag;
//	}
}
