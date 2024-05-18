package lattice.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoDoctorAvailableException extends RuntimeException {
    public NoDoctorAvailableException(String message) {
        super(message);
    }
}
