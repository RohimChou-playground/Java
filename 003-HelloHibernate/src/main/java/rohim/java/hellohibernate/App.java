package rohim.java.hellohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		// create connection config from file
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);
		
		// use the config object to create a session factory
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		// initialize session
		Session session = sessionFactory.openSession();
		
		System.out.printf("session open state = %s%n", session.isOpen());
		
		Song song = new Song();
		song.setId(1);
		song.setSongName("Despacito");
		song.setArtist("Luis Fonsi");
		
		session.beginTransaction();
		session.save(song);
		session.getTransaction().commit();
	}

}
