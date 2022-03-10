package demos.completable.future.http.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlusService {
    @RequestMapping(value = "/plus/{value}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Integer> plus(@PathVariable("value") int value) throws Exception {
        System.out.println("Plus service called with value of " + value);
        Thread.sleep(1000);
        return ResponseEntity.ok(value + 1);
    }
}
