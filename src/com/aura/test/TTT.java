package com.aura.test;

import java.util.List;

import org.junit.Test;

import com.aura.dao.BookDao;
import com.aura.dao.impl.BookDaoImpl;
import com.aura.entity.Book;

public class TTT {
	BookDao bd = new BookDaoImpl();

	@Test // 查询、
	public void test2() {
		List<Book> book = bd.getBook();
		System.out.println(book);
	}

	@Test // 添加书籍
	public void test1() {
		Book b1 = new Book(6, "睡sad", "XXX", 29);
		Integer num = bd.addBook(b1);
		if (num != 0) {
			System.out.println("添加成功");
		}
	}

	@Test // 模糊查询
	public void test3() {
		List<Book> book = bd.getBook("XX");
		System.out.println(book);
	}

	@Test // 删除
	public void test4() {
		int n = bd.delBook(6);
		System.out.println(n);
	}

	@Test // 更新
	public void test5() {
		int n = bd.update(new Book(1, "娃哈哈", "语言",  34));
		if (n != 0) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}

}
