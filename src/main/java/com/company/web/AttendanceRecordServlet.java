package com.company.web;

import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.service.AttendanceRecordService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AttendanceRecordServlet", value = "/AttendanceRecordServlet")
public class AttendanceRecordServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        request.setAttribute("attendanceRecordResponse", AttendanceRecordService.getAllAttendanceRecords());
        RequestDispatcher dispatcher = request.getRequestDispatcher("attendanceRecord.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            LOGGER.error("" + e.getMessage());
        }
    }
}