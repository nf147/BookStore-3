package com.nf.bookstore3.json;

import com.google.gson.Gson;
import com.nf.bookstore3.dao.BookDAO;
import com.nf.bookstore3.dao.BookSqliteDAO;
import com.nf.bookstore3.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/json/books")
public class BookList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        BookDAO bookDAO = new BookSqliteDAO();
        List<Book> books = bookDAO.listAll();

        PrintWriter writer = resp.getWriter();

        Gson gson = new Gson();
        String bookStr = gson.toJson(books);
        writer.write(bookStr);

        writer.close();
    }
}
