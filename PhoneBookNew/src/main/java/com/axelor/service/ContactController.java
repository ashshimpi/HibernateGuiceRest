package com.axelor.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.net.URI;
import java.net.URISyntaxException;
import com.axelor.pojo.Contact;
import com.google.inject.Guice;
import com.google.inject.Injector;

import com.google.inject.persist.jpa.JpaPersistModule;
import javax.ws.rs.core.Response;
	
@Path("phone")
public class ContactController {
	
	Injector inject = Guice.createInjector(new JpaPersistModule("Persist"));

	Persist ps = new Persist(inject);
	@Path("add")
	@POST
	public Response add(@FormParam("cname") String cname,@FormParam("cnumber") int cnumber) {
		ContactServiceImpl cs = inject.getInstance(ContactServiceImpl.class);
		
		//System.out.println("hello");
		Contact c=new Contact();
		c.setCname(cname);
		c.setCnumber(cnumber);
		cs.add(c);
		URI location = null;
		try {
			location = new URI("http://localhost:8080/PhoneBookNew/done.jsp");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location).build();

	}
	 
	
}
