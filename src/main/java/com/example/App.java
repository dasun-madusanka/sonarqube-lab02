package main.java.com.example;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Logger.getLogger(App.class.getName()).info("Addition: " + calc.calculate(10, 5, "add-again"));
        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin"); // NEW dangerous call
    }
}
