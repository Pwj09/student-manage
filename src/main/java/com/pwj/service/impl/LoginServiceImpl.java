package com.pwj.service.impl;

import com.pwj.dao.ClazzDao;
import com.pwj.dao.StudentDao;
import com.pwj.dao.TeacherDao;
import com.pwj.dao.ManagerDao;
import com.pwj.pojo.Clazz;
import com.pwj.pojo.Student;
import com.pwj.pojo.Teacher;
import com.pwj.pojo.Manager;
import com.pwj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ManagerDao managerDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ClazzDao clazzDao;

    @Override
    public Manager managerLogin(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return managerDao.checkByUsernameAndPassword(map);
    }

    @Override
    public Teacher teacherLogin(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return teacherDao.checkByUsernameAndPassword(map);
    }

    @Override
    public Student studentLogin(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        Student student = studentDao.checkByUsernameAndPassword(map);

        //添加班级名信息
        if(student != null) {
            Integer cid = student.getCid();
            if (cid != null) {
                Clazz clazz = clazzDao.selectClazz(cid);
                if (clazz != null) {
                    student.setCname(clazz.getCname());
                }
            }
        }
        return student;
    }

    @Override
    public void setManagerPassword(Manager manager, String password) {
        manager.setPassword(password);
        managerDao.updateManager(manager);
    }

    @Override
    public void setTeacherPassword(Teacher teacher, String password) {
        teacher.setPswd(password);
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void setStudentPassword(Student student, String password) {
        student.setPswd(password);
        studentDao.updateStudent(student);
    }
}
