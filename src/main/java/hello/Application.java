package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Jordan on 6/21/2016.
 */


@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // runs test methods
        MyRestController.Tests();

        SpringApplication.run(Application.class, args);


    }
}
