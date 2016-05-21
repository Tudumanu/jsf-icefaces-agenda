package dao;

import model.Contato;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

public class ContatoDAO {
    private Session session;
    
    public ContatoDAO () {}

    public boolean insert(Contato p) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    public boolean delete(Contato p) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    public boolean update(Contato p) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    public Contato show(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Contato p = (Contato) session.get(Contato.class, new Integer(id));
        session.close();

        return p;
    }

    public List<Contato> search(String text) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Contato> list = (List<Contato>) session.createCriteria(Contato.class)
                .add(
                        Restrictions.or(
                                Restrictions.ilike("nome", "%" + text + "%"),
                                Restrictions.ilike("email", "%" + text + "%")
                        )
                ).addOrder(Order.asc("nome")).list();
        session.close();

        return list;
    }
}
