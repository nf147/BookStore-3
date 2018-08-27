package com.nf.bookstore3.dao;

import com.nf.bookstore3.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookSqliteDAO implements BookDAO {

    @Override
    public List<Book> listAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            conn = getConnectin();
            statement = conn.createStatement();
            //PreparedStatement preparedStatement = conn.prepareStatement("");
            //CallableStatement callableStatement = conn.prepareCall("");

            String sql = "select id, name, price, author, press from book order by price desc";

            //statement.execute("");
            resultSet = statement.executeQuery(sql);
            //statement.executeUpdate("");

            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                books.add(book);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, statement, conn);
        }

        return books;
    }

    @Override
    public Book getBookById(int id) {
        Connection connectin = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connectin = getConnectin();
            String sql = "select id, name, price, author, press from book where id=? order by price desc";
            preparedStatement = connectin.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Book(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connectin);
        }
        return null;
    }

    @Override
    public List<Book> getBooksByName(String name) {
        Connection connectin = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Book> books = new ArrayList<>();

        try {
            connectin = getConnectin();
            String sql = "select id, name, price, author, press from book where name like ? order by price desc";
            preparedStatement = connectin.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                books.add(book);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connectin);
        }
        return books;
    }

    @Override
    public boolean update(Book book) {
        Connection connectin = null;
        PreparedStatement preparedStatement = null;

        try {
            connectin = getConnectin();
            String sql = "update book set name=?, price=?, author=?, press=? where id=?";
            preparedStatement = connectin.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPress());
            preparedStatement.setInt(5, book.getId());

            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            release(null, preparedStatement, connectin);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connectin = null;
        PreparedStatement preparedStatement = null;

        List<Book> books = new ArrayList<>();

        try {
            connectin = getConnectin();
            String sql = "delete from book where id = ?";
            preparedStatement = connectin.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            release(null, preparedStatement, connectin);
        }
        return false;
    }

    @Override
    public Book add(Book book) {
        Connection connectin = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Book> books = new ArrayList<>();

        try {
            connectin = getConnectin();
            String sql = "insert into book (name, price, author, press) values (?, ?, ?, ?)";
            preparedStatement = connectin.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPress());

            preparedStatement.executeUpdate();

            return book;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connectin);
        }
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    public static Connection getConnectin () throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite://D:/web-demo/BookStore2/book.db");
        return conn;
    }

    public static void release(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException ignored) {
        }
    }
}
