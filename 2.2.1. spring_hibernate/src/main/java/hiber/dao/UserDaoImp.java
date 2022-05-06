package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findByCar(String model, int series) {
        User user;
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        List<User> listOfUsers = query.getResultList();
        for (User users : listOfUsers) {
            if (users.getCar().getModel().equals(model) &
                    users.getCar().getSeries() == series) {
                user = users;
                return user;
            }
        }
        return null;
    }
}
