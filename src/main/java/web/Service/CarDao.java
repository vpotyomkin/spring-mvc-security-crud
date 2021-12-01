package web.Service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.stream.Collectors;

@Component
public class CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "BMW", "1515155"));
        cars.add(new Car(2, "BMW", "5548574"));
        cars.add(new Car(3, "Audi", "1515155"));
        cars.add(new Car(4, "Skoda", "48298498"));
        cars.add(new Car(5, "Mercedes", "7444585"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
