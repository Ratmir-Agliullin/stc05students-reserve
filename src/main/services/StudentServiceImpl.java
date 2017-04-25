package main.services;

import main.models.dao.StudentDao;
import main.models.dao.StudentDaoImpl;
import main.models.pojo.Student;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class StudentServiceImpl implements StudentService {

    public static StudentDao studentDao = new StudentDaoImpl();

    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    public boolean addStudent(int id, String name, int age, int group_id) {
        return studentDao.insert(id, name, age, group_id);
    }
}
