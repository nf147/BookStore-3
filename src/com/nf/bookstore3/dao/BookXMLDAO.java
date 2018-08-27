package com.nf.bookstore3.dao;

import com.nf.bookstore3.entity.Book;

import java.util.List;

public class BookXMLDAO implements BookDAO {
    @Override
    public List<Book> listAll() {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return null;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Book add(Book book) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
