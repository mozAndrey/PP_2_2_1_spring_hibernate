package hiber.service;

import hiber.dao.CarDAOImp;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDAOImp carDAOImp;

    @Transactional
    @Override
    public void add(Car car) {
        carDAOImp.add(car);
    }


    @Transactional
    @Override
    public User findByCar(String model, int series) {
        return carDAOImp.findByCar(model, series);
    }
}
