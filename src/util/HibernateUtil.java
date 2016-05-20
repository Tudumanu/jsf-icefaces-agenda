package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Util class to get a sessionFactory on Hibernate 5
 *
 * Usage:
 * SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 *
 * Session session = sessionFactory.openSession();
 * session.beginTransaction();
 * session.save(myObject);
 *
 *
 */
public class HibernateUtil {

    /** Creates and sets a Session factory to perform queries with. */
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /** Creates a new session factory based on the hibernate config (xml) file.
     * @return The factory.
     */
    private static SessionFactory buildSessionFactory() {
        System.out.println("\n Iniciando sessionFactory do Hibernate... \n");
        try {
            SessionFactory sf =  new Configuration().configure().buildSessionFactory();
            System.out.println("\n ...fim criacao sessionFactory do Hibernate \n");
            return sf;

        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /** @return The session factory. */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
