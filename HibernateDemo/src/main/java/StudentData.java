
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class StudentData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		StudentData sd = new StudentData();
		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();  
//       
//		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  		  
//		   SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//		   Session session = factory.openSession();  
			
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Student.class);
			cfg.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			Transaction t = session.beginTransaction(); 
			
				sd.addObject(session);
				t.commit();
				System.out.println("successfully saved");
				

		   
		   factory.close();  
		   session.close();    
		

	}

	public  void addObject(Session session) {
		// TODO Auto-generated method stub
		
			Student s = new Student();
			s.setSid(104 );
			s.setSname("Ashwini");
			session.save(s);  
			
	
	
	}
}
