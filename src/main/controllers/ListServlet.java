package main.controllers;

import main.models.pojo.Student;
import main.services.StudentService;
import main.services.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentHello", "Hello student from servlet!");
        req.setAttribute("studentList", studentService.getAllStudents());
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    private static StudentService studentService = new StudentServiceImpl();
}
