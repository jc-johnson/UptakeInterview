package hello;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jordan on 6/21/2016.
 */

@RestController
public class MyRestController {

    // private static final String template = "Hello, %s!";
    // private final AtomicLong counter = new AtomicLong();

    private List<String> ids = new ArrayList<>();

    private static int sumOfAmicables;


    /*@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/


    /**
     * parses Json object
     * @return
     */
    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseEntity<String> message(@RequestBody Request request) {

        if(request != null) {

            int seed = request.getSeed();
            int answer = 0;

            // if the missionId is unique continue
            if(!ids.contains(request.getMissionId())) {


                // return answer
                answer = amicablePair(seed);
                System.out.println(answer);

                // return new ResponseEntity.ok(answer);

                // print status code
                return new ResponseEntity<String>(HttpStatus.OK);

            }

            // id has been received before
            else {
                // return 409 status code
                return new ResponseEntity<String>(HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    // checks if a given number is prime
    public static boolean isPrime(int n) {

        if (n > 1) {
            if (n == 2) return true;
            if (n == 3) return true;

            // checking if n is even
            if (n % 2 == 0) return false;

            int squareRoot = (int)Math.sqrt(n); // lazy compute

            // n is odd
            // start with smallest odd square root n might divide into
            for (int i = 3; i <= squareRoot; i++) {
                if (n % i == 0) return false;
            }

            // no divisors found
            return true;
        }
        return false;
    }

    // calculates amicable pairs less than seed
    public static int amicablePair(int n){
        if (n > 0){

            sumOfAmicables = 0;

            for (int i = 1; i < n ; i++) {

                int one = (int) (3 * Math.pow(2,i))-1;
                int two = (int) (3 * Math.pow(2,i+1)) - 1;
                int three = (int) (Math.pow(3,2)* Math.pow(2, 2*i+1)-1);

                if(isPrime(one) && isPrime(two) && isPrime(three)){
                    int amiOne = (int) (Math.pow(2, i+1)*(3*Math.pow(2, i)-1)*(3*Math.pow(2, i+1)-1));
                    int amiTwo = (int) (Math.pow(2, i+1)*(Math.pow(3,2) * Math.pow(2, (2*i+1))-1));

                    System.out.println("Amicable one: " + amiOne);
                    System.out.println("Amicable two: " + amiTwo);
                    sumOfAmicables = sumOfAmicables + amiOne + amiTwo;
                    System.out.println("Total sumOfAmicables: " + sumOfAmicables);
                }
            }
            return sumOfAmicables;
        }

        return 0;
    }

    public static void Tests() {

        // isPrime tests
        /*System.out.println(isPrime(48));
        System.out.println(isPrime(1));
        System.out.println(isPrime(0));
        System.out.println(isPrime(3));
        System.out.println(isPrime(1000));
        System.out.println(isPrime(5));
        System.out.println(isPrime(-1));
        System.out.println(isPrime(7919));
        System.out.println(isPrime(6247));*/

        // test amicables
        // amicablePair(10000);
        // System.out.println(amicablePair(248));
    }
}
