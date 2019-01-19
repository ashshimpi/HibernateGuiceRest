package com.axelor.student.service;

import java.util.List;
import java.util.Set;
import com.axelor.student.db.Address;
import com.axelor.student.db.Country;
import com.axelor.student.db.Department;
import com.axelor.student.db.Phone;
import com.axelor.student.db.Student;
import com.axelor.student.db.Subject;

public interface StudentService {
  public void update(Student student);

  public void updatePhone(List<Phone> phone ,Student student);

  public void updateAddress(Address address ,Student student);

  public void updateDepartment(Department department,Student student);

  public void updateCountry(Country country,Student student);

  public void updateSubject(Set<Subject> subject,Student student);
}
