package com.example.webprogramming;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// библиотечный класс для работы с потоками вывода
import java.io.*;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub 30
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
            // Задание типа кодировки для параметров запроса
            request.setCharacterEncoding("utf-8");
            // Чтение параметра name из запроса
            String name = request.getParameter("name");
            // Задание типа содержимого для ответа (в том числе кодировки)
            response.setContentType("text/html;charset=UTF-8");
            // Получение потока для вывода ответа
            PrintWriter out = response.getWriter();
        try {
            // Создание HTML-страницы
            out.println("<html>");
            out.println("<head><title></title></head>");
            out.println("<body>");
            out.println("<h1>Привет, " + (name != null ? name : "Мир") + "!" + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            // Закрытие потока вывода
            out.close();
        }
    }
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
    31
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}