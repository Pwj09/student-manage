package com.pwj.service;

import com.pwj.pojo.Student;
import com.pwj.pojo.Teacher;
import com.pwj.pojo.Manager;

public interface LoginService {
    Manager managerLogin(String username, String password);

    Teacher teacherLogin(String username, String password);

    Student studentLogin(String username, String password);

    void setManagerPassword(Manager manager, String password);

    void setTeacherPassword(Teacher loginTeacher, String password);

    void setStudentPassword(Student loginStudent, String password);
}
