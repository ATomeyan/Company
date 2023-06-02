package com.company.web;

import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        request.setAttribute("employeeResponse", EmployeeService.getAllEmployees());
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            LOGGER.error(" " + e.getMessage());
        }
    }
}