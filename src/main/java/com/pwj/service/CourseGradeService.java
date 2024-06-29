package com.pwj.service;

import com.pwj.pojo.CourseGrade;

public interface CourseGradeService {

    CourseGrade findScoreByOidAndSid(int oid, int sid);

    int saveCourseGrade(CourseGrade courseGrade);
}
