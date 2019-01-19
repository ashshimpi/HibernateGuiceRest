package com.axelor.student.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.axelor.data.ImportException;
import com.axelor.data.ImportTask;
import com.axelor.data.Listener;
import com.axelor.data.csv.CSVImporter;
import com.axelor.db.Model;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.student.db.Department;
import com.axelor.student.db.Student;
import com.axelor.student.db.repo.DepartmentRepository;
import com.axelor.student.service.StudentService;
import com.google.inject.Inject;
import com.opencsv.CSVWriter;

public class StudentController {
  @Inject
  StudentService ss;

  public void report(ActionRequest request, ActionResponse response) {
    System.out.println("+++context+++" + request.getContext().keySet().toString());
    System.out.println("+++context+++" + request.getContext().values().toString());
    System.out.println("+++context+++" + request.getContext().entrySet().toString());

  }

  public Object validateImport(Object bean, Map<String, Object> context) {
    Student student = (Student) bean;

    System.out.println(
        "context" + context.toString() + "\n context.get(student)" + context.get(student));
    System.out.println("---Student---" + student.getPhones().toString() + "\n student :" + student);
    return bean;
  }

  public void update(ActionRequest request, ActionResponse response) {
    Student student = request.getContext().asType(Student.class);
    ss.update(student);
    response.setFlash("Successfully Saved !");

  }

  public void validate(ActionRequest request, ActionResponse response) {
    System.out.println("validate called in controller!!");

    Student student = request.getContext().asType(Student.class);
    System.out.println("Controller-validate()--->Class : " + student.getClass().getName());
    for (int i = 0; i < student.getPhones().size(); i++) {

      if (student.getPhones().get(i).getPhone() == null) {
        response.setError("phone required");
      }

      else if (student.getPhones().get(i).getPhone().length() < 10) {
        response.setError("Invalid phone-no");
      }
    }
  }

  public void CSVExport(ActionRequest request, ActionResponse response) throws IOException {
    try {
      response.setAlert(request.getContext().asType(Student.class).toString());
      String filePath =
          "/home/axelor/jigar/my-axelor-demo/modules/my-axelor-demo-student/Export-data/export-department.csv";
      CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(filePath)));
      csvWriter.writeNext(new String[] {"name", "code"});
      List<Department> list = Beans.get(DepartmentRepository.class).all().fetch();
      for (int i = 0; i < list.size(); i++) {
        csvWriter.writeNext(new String[] {list.get(i).getName(), list.get(i).getCode()});
      }
      csvWriter.close();
      response.setFlash("File exported Succesfully !");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void CSVImport(ActionRequest request, ActionResponse response) throws Exception {
    CSVImporter importer = new CSVImporter("Data/csv-student-config.xml", "Data");
    // Map<String, Object> context=request.getContext();
    // importer.setContext(context);
    importer.addListener(new Listener() {

      @Override
      public void imported(Integer total, Integer success) {
        // TODO Auto-generated method stub
        System.err.println("File Imported\n" + "Record (total): " + total);
        System.err.println("Record (success): " + success);
      }

      @Override
      public void imported(Model bean) {
        // TODO Auto-generated method stub
        System.err.println("Bean saved Class :" + bean.getClass().getSimpleName());
        System.err.println("Bean saved ID:" + bean.getId());
      }

      @Override
      public void handle(Model bean, Exception e) {

        System.err.println("bean :" + bean + "\n" + e);
      }
    });
    importer.run(new ImportTask() {

      @Override
      public boolean handle(ImportException e) {
        return false;
      }

      @Override
      public boolean handle(IOException e) {
        return true;
      }

      @Override
      public void configure() throws IOException {
        // TODO Auto-generated method stub
        input("[students]", new File("Data/student.csv"));
      }
    });


  }
}
