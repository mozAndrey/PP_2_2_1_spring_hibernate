package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDAOImp implements CarDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findByCar(String model, int series) {
        User user;
        Car car = new Car(model, series);
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        List <User> listOfUsers = query.getResultList();
        for (User users : listOfUsers) {
            if (users.getCar().getModel().equals(car.getModel()) &
            users.getCar().getSeries() == car.getSeries()) {
                user = users;
                return user;
            }
        }
        return null;
    }
}
