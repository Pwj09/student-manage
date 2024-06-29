package com.pwj.service.impl;

import com.pwj.dao.CourseGradeDao;
import com.pwj.pojo.CourseGrade;
import com.pwj.service.CourseGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseGradeServiceImpl implements CourseGradeService {

    @Autowired
    CourseGradeDao courseGradeDao;

    @Override
    public CourseGrade findScoreByOidAndSid(int oid,int sid) {
        CourseGrade courseGrade = courseGradeDao.selectCourseGradeByOidAndSid(oid,sid);
        return courseGrade;
    }

    @Override
    public int saveCourseGrade(CourseGrade courseGrade) {
        //先判断表里面有没有当前开课和学生id的成绩
        CourseGrade cgTmp = courseGradeDao.selectCourseGradeByOidAndSid(courseGrade.getOid(), courseGrade.getSid());
        int res = 0;
        if(cgTmp == null) res = courseGradeDao.insertCourseGrade(courseGrade);
        else res = courseGradeDao.updateCourseGradeByOidAndSid(courseGrade);
        return res;
    }
}
