package com.nf.bookstore3.json;

import com.nf.bookstore3.dao.BookDAO;
import com.nf.bookstore3.dao.BookSqliteDAO;
import com.nf.bookstore3.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/json/book")
public class BookInfo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        BookDAO bookDAO = new BookSqliteDAO();
        Book books = bookDAO.getBookById(Integer.parseInt(request.getParameter("id")));

        String requ = "{\"id\":" + books.getId() + ",\"press\":\"" + books.getPress() + "\",\"name\":\"" + books.getName() + "\",\"price\":\"" + books.getPrice() + "\",\"author\":\"" + books.getAuthor() + "\"}";

        response.getWriter().print(requ);
    }
}
