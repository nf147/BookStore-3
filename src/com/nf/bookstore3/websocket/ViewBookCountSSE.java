package com.nf.bookstore3.websocket;

import com.nf.bookstore3.dao.BookDAO;
import com.nf.bookstore3.dao.BookInMemoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/ws/book_es")
public class ViewBookCountSSE extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 基本要求
        // Content-Type: text/event-stream
        // Cache-Control: no-cache
        // Connection: keep-alive
        //
        // 返回的内容，要求
        // 字段(id/data/retry/event): 值
        // 字段: 值

        BookDAO bookDAO = new BookInMemoryDAO();
        int count = bookDAO.count();

        resp.setContentType("text/event-stream;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Prama", "no-cache");
        resp.setDateHeader("Expires", 0);

        PrintWriter writer = resp.getWriter();
        writer.write("retry:5000\n");
        System.out.println(new Date());
        writer.write("data:" + count + "\n\n");
    }
}
