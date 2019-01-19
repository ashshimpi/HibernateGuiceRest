

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ProductData {
	
	public static void main(String[] args) {
	
		ProductData pd=new ProductData();
		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(Product.class);
		cfg.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory factory = cfg.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction(); 
		
			//pd.addObject(session);
			//pd.read(session);
			//pd.deleteObject(session);
			pd.updateObject(session);
			//t.commit();
			System.out.println("successfully saved");
			

	   
	   factory.close();  
	   session.close();    
	

		
	}

	/*private void addObject(Session session) {
		// TODO Auto-generated method stub
		Product p=new Product();
		p.setId(3);
		p.setName("new");
		p.setSku("data");
		p.setDescription("my data");
		session.save(p);
	
		
	}*/

	/*private void read(Session session) {
		// TODO Auto-generated method stub
			System.out.println("Reading Records");
			Product s =(Product) session.get(Product.class,1);
			//session.beginTransaction();
			//session.getTransaction().commit();
			System.out.println(s);
		
		
	}*/

	/*private void deleteObject(Session session) {
		// TODO Auto-generated method stub
		
		System.out.println("Deleting records..");
		Product s = (Product) session.get(Product.class,3);
		//session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
		System.out.println("Deleted Successfully");
		
		
	}*/
	
	

	private void updateObject(Session session) {
		// TODO Auto-generated method stub
		Product j =  (Product) session.get(Product.class,1);
		   j.setName("ashu");
		   
		  // session.beginTransaction();
		   session.saveOrUpdate(j);
		   session.getTransaction().commit();
		System.out.println("Updated successfully"); 
		
		
	}
	

}
