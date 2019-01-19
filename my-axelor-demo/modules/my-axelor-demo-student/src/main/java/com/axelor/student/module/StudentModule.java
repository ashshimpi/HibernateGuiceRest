package com.axelor.student.module;

import com.axelor.app.AxelorModule;
import com.axelor.student.db.repo.StudentCRUD;
import com.axelor.student.db.repo.StudentRepository;
import com.axelor.student.service.StudentService;
import com.axelor.student.service.StudentServiceImp;

public class StudentModule extends AxelorModule {

  @Override
  protected void configure() {
    bind(StudentRepository.class).to(StudentCRUD.class);
    bind(StudentService.class).to(StudentServiceImp.class);
  }

}
