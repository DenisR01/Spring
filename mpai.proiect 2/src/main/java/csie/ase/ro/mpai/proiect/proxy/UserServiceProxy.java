package csie.ase.ro.mpai.proiect.proxy;

import csie.ase.ro.mpai.proiect.response.UserResponse;
import csie.ase.ro.mpai.proiect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceProxy {
    private final UserService userService;
    private int attemptCount = 0;

    @Autowired
    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<Object> findByCnp(String cnp) {
        int MAX_ATTEMPTS = 3;
        if (attemptCount < MAX_ATTEMPTS) {
            try {
                UserResponse userResponse = userService.findByCnp(cnp);
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            } catch (RuntimeException e) {
                attemptCount++;
                return new ResponseEntity<>("CNP invalid", HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("Numarul maxim de incercari permise a fost atins.", HttpStatus.FORBIDDEN);
        }
    }
}