package com.nf.bookstore3.web;

import com.nf.bookstore3.dao.BookDAO;
import com.nf.bookstore3.dao.BookSqliteDAO;
import com.nf.bookstore3.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class BookList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isAjax = (String) req.getParameter("ajax");
        String retPage = req.getContextPath() + "/WEB-INF/jsp/book_list" + (isAjax == null ? "" : "_ajax") + ".jsp";

        BookDAO bookDAO = new BookSqliteDAO();
        List<Book> books = bookDAO.listAll();
        req.setAttribute("books", books);

        req.getRequestDispatcher(retPage).forward(req, resp);
    }

}
