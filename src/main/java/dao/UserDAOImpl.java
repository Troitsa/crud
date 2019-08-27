package dao;

import dao.connection.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.User;
import java.util.List;

public class UserDAOImpl implements UserDao {

    public User getById(int id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from User user where user.id = :id");
            query.setParameter("id", id);
            return (User) query.uniqueResult();
        }
    }

    public List<User> getAll() {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from User");
            return query.list();
        }
   }

    public void add(User user){
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void update(User user) {
        add(user);
    }

    public void deleteById(int id) {
        User user = getById(id);
        if (user != null) {
            try (Session session = HibernateConnection.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
                session.close();
            }
        }
    }
}
