package isdb.courseback.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
public class ValidationService {

    public String combineBindingResultErrors(BindingResult bindingResult) {
        StringBuilder errors = new StringBuilder();
        for (ObjectError error: bindingResult.getAllErrors()) {
            errors.append(error.getDefaultMessage()).append("\n");
        }
        return errors.toString();
    }

}
