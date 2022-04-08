package com.company.web;

import com.company.logger.Logger;
import com.company.logger.LoggerConfigurator;
import com.company.service.PositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PositionServlet", value = "/PositionServlet")
public class PositionServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerConfigurator.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");

        request.setAttribute("positionResponse", PositionService.getAllPositions());
        RequestDispatcher dispatcher = request.getRequestDispatcher("position.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            LOGGER.error("Something bad happened." + e.getMessage());
        }
    }
}