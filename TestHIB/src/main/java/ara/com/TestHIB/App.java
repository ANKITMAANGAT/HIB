package ara.com.TestHIB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Student st = new Student();
		st.setId(101);
		st.setAge(30);
		st.setName("Ankit Kumar");

		Laptop laptop = new Laptop();
		laptop.setlId(1);
		laptop.setlName("Dell");
		st.getLaptop().add(laptop);
		// laptop.setStudent(st);

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// st = session.get(Student.class, "102");
		session.save(laptop);
		session.save(st);
		transaction.commit();
		System.out.println(st);
	}
}
