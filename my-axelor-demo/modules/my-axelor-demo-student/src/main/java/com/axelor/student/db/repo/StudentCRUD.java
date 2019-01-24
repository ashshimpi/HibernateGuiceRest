package com.axelor.student.db.repo;

import java.util.Map;
import com.axelor.student.db.Student;
import com.google.inject.Inject;

public class gradle extends StudentRepository {

  @Inject
  AddressRepository addressRep;
  @Inject
  PhoneRepository phoneRep;

  @Override
  public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
    if (!context.containsKey("json-enhance")) {
      return json;
    }

    try {
      Long id = (Long) json.get("id");
      Boolean hasImage=false;
      Student s = find(id);
      json.put("address", addressRep.find(s.getAddress().getId()));
      json.put("phones", phoneRep.find(s.getPhones().get(0).getId()));
      if(s.getImage()!=null) {
        hasImage=true;
      }
      json.put("hasImage", hasImage);
    } catch (Exception e) {
    }
    return json;
  }



}
