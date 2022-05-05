package hiber.dao;

import hiber.model.Car;
import hiber.model.User;


public interface CarDAO {
    void add(Car car);

    User findByCar (String model, int series);
}
