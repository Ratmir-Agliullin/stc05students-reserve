package main.controllers;

import main.models.pojo.Student;
import main.services.StudentService;
import main.services.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 20.04.2017.
 */
public class StudentAddServlet extends HttpServlet {

    private static StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("password");
        int age = Integer.valueOf(req.getParameter("age"));
        int group_id = Integer.valueOf(req.getParameter("group_id"));

        boolean is_adding = studentService.addStudent(id, name, age, group_id);
        req.setAttribute("is_adding", is_adding);
        resp.sendRedirect(req.getContextPath() + "/add-student");
    }
}
