package com.nf.bookstore3.test;

import com.nf.bookstore3.dao.BookDAO;
import com.nf.bookstore3.dao.BookSqliteDAO;

public class SqliteTest {
    static BookDAO bookDAO = new BookSqliteDAO();

    public static void main(String[] args) {
        testlistAll();
    }

    public static void testlistAll() {
        System.out.println(bookDAO.listAll());
    }
}
