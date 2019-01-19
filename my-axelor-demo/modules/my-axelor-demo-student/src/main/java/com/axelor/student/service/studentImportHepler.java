package com.axelor.student.service;

import java.time.LocalDate;
import java.util.Map;
import com.axelor.student.db.Student;

public class studentImportHepler {

  public void createStudent(Map<String, Object> context) {
    Student stud = new Student();
    stud.setDateOfBirth(LocalDate.now().minusYears(20));
  }

  public Object updateStudent() {

    return null;

  }

}
