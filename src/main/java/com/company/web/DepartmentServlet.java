package com.company.web;

import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.service.DepartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DepartmentServlet", value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("test/html");

        request.setAttribute("departmentResponse", DepartmentService.getAllDepartments());
        RequestDispatcher dispatcher = request.getRequestDispatcher("department.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            LOGGER.error("" + e.getMessage());
        }
    }
}