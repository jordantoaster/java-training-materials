package demos.completable.future.http.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingService {
    @RequestMapping(value = "/ping/{timeout}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> ping(@PathVariable("timeout") int timeout) throws Exception {
        System.out.println("Ping service called with timeout of " + timeout);
        if (timeout > 10) {
            String json = "Error - timeout too high!";
            return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        Thread.sleep(timeout * 1000);
        String json = "Pingback after " + timeout;
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
}
