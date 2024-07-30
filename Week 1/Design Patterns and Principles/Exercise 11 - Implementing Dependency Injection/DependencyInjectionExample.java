package dependencyinjection;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        
        CustomerRepository repository = new CustomerRepositoryImpl();

        
        CustomerService service = new CustomerService(repository);

       
        service.printCustomer(1);
    }
}
