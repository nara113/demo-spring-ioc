package springapplicationcontext;

public class CoffeeService {

    private CoffeeRepository coffeeRepository;

    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
}
