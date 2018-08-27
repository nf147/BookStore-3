package com.nf.bookstore3.websocket;

import com.nf.bookstore3.dao.BookDAO;
import com.nf.bookstore3.dao.BookInMemoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ws/bookcount")
public class ViewBookCount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/ws/book_count.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        BookDAO bookDAO = new BookInMemoryDAO();
        int count = bookDAO.count();

        resp.getWriter().write("{ \"count\" : \"" + count + "\" }");
    }
}
