package com.axelor.student.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.axelor.student.db.Address;
import com.axelor.student.db.Country;
import com.axelor.student.db.Department;
import com.axelor.student.db.Phone;
import com.axelor.student.db.Student;
import com.axelor.student.db.Subject;
import com.axelor.student.db.repo.AddressRepository;
import com.axelor.student.db.repo.CountryRepository;
import com.axelor.student.db.repo.DepartmentRepository;
import com.axelor.student.db.repo.PhoneRepository;
import com.axelor.student.db.repo.StudentRepository;
import com.axelor.student.db.repo.SubjectRepository;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class StudentServiceImp implements StudentService {

  @Inject
  StudentRepository studentRep;
  @Inject
  PhoneRepository phoneRep;
  @Inject
  SubjectRepository subjectRep;
  @Inject
  DepartmentRepository depRep;
  @Inject
  CountryRepository countryRep;
  @Inject
  AddressRepository addressRep;

  @Transactional
  @Override
  public void update(Student student) {

    Student studentFromRepo = studentRep.find(student.getId());
    studentFromRepo.setName(student.getName());

    updatePhone(student.getPhones(), studentFromRepo);
    // updateSubject(student.getSubjects(), studentFromRepo);
    // updateAddress(student.getAddress(), studentFromRepo);
    // updateDepartment(student.getDepartment(), studentFromRepo);

    studentRep.save(studentFromRepo);
    System.out.println("studentRep.save: " + studentRep.save(studentFromRepo));
  }

  @Transactional
  @Override
  public void updatePhone(List<Phone> list, Student studentFromRepo) {
    if (list.isEmpty()) {
      studentFromRepo.getPhones().clear();
      return;
    }
    if (!studentFromRepo.getPhones().isEmpty()) {
      studentFromRepo.getPhones().clear();
      System.out.println("Phone removed-->" + studentFromRepo);
      if (!list.isEmpty()) {
        for (Phone phone : list) {
          studentFromRepo.addPhone(phone);
        }
      }
    }
  }

  @Transactional
  @Override
  public void updateSubject(Set<Subject> set, Student studentFromRepo) {
    Subject em = null;
    if (set.isEmpty()) {
      if (!studentFromRepo.getSubjects().isEmpty())
        for (Subject subject : studentFromRepo.getSubjects()) {
          subjectRep.remove(subject);
          System.out.println("Subject removed--->" + subject);
        }
    }
    Set<Subject> subjectsFromRep = studentFromRepo.getSubjects();
    Iterator<Subject> iterate = subjectsFromRep.iterator();
    for (Subject subject : set) {
      while (iterate.hasNext()) {
        Subject subjectfromRep = subjectRep.find(subjectsFromRep.iterator().next().getId());
        subjectfromRep.setSubjectName(subject.getSubjectName());
        subjectfromRep.setCode(subject.getCode());
        em = subjectRep.save(subjectfromRep);
        System.out.println("Subject removed--->" + em);
      }
      Subject newSubject = new Subject();
      newSubject.setSubjectName(subject.getSubjectName());
      newSubject.setCode(subject.getCode());
      studentFromRepo.addSubject(newSubject);
    }
  }

  @Transactional
  @Override
  public void updateDepartment(Department department, Student studentFromRepo) {

    Department dept = depRep.find(studentFromRepo.getDepartment().getId());
    dept.setName(department.getName());
    dept.setCode(department.getCode());
    Department em = depRep.save(dept);
    System.out.println("updateDepartment --->" + em);
  }

  @Transactional
  @Override
  public void updateAddress(Address address, Student studentFromRepo) {
    Long addressId = studentFromRepo.getAddress().getId();
    if (addressId != null) {
      Address addressFromRep = addressRep.find(addressId);
      addressFromRep.setStreet(address.getStreet());
      addressFromRep.setArea(address.getArea());
      addressFromRep.setCity(address.getCity());
      addressFromRep.setState(address.getState());
      addressFromRep.setZip(address.getZip());
      Address em = addressRep.save(addressFromRep);
      updateCountry(address.getCountry(), studentFromRepo);
      System.out.println("updateAddress --->" + em);
    } else {
      Address newAddress = new Address();
      newAddress.setStreet(address.getStreet());
      newAddress.setArea(address.getArea());
      newAddress.setCity(address.getCity());
      newAddress.setState(address.getState());
      newAddress.setZip(address.getZip());
      updateCountry(address.getCountry(), studentFromRepo);
    }
  }

  @Transactional
  @Override
  public void updateCountry(Country country, Student studentFromRepo) {

    Country countryFromRep;
    String name = studentFromRepo.getAddress().getCountry().getName();
    if (name == null) { // No-country in studentFromRepo record
      countryFromRep = countryRep.findByName(country.getName()); // search for existing country name
      if (countryFromRep == null) {
        countryFromRep = new Country();
        countryFromRep.setCode(country.getCode());
        countryFromRep.setName(country.getName());
        countryRep.save(countryFromRep);
        studentFromRepo.getAddress().setCountry(countryFromRep);
      } else {
        studentFromRepo.getAddress().setCountry(countryFromRep);
      }
    } else if (name != country.getName()) {

      // studentFromRepo.getAddress().setCountry();
    }
  }
}
