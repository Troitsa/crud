package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import pojo.User;
import utils.DBHelper;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        Configuration configuration = DBHelper.getInstance().getConfiguration();
        sessionFactory = getSessionFactory(configuration);
    }

    public SessionFactory getSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public User getById(int id) {
        try (Session session = getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User user WHERE user.id = :id");
            query.setParameter("id", id);
            return (User) query.uniqueResult();
        }
    }

    public List<User> getAll() {
        try (Session session = getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User");
            return query.list();
        }
   }

    public void add(User user){
        try (Session session = getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    public void update(User user) {
        add(user);
    }

    public void deleteById(int id) {
        User user = getById(id);
        if (user != null) {
            try (Session session = getSession()) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
            }
        }
    }
}
