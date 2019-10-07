package br.com.waterclock.api.resource;

import br.com.waterclock.api.entity.User;
import br.com.waterclock.api.entity.UserDto;
import br.com.waterclock.api.exception.EmailExistsException;
import br.com.waterclock.api.exception.PasswordException;
import br.com.waterclock.api.repository.UserRepository;
import br.com.waterclock.api.repository.UserRepository;
import br.com.waterclock.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @GetMapping
    public List<User> index() {
        return repository.findAll();
    }

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @GetMapping("{id}")
    @PostAuthorize("!hasAuthority('USER') || (returnObject != null && returnObject.email == authentication.principal)")
    public User show(@PathVariable int id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(EmailExistsException.class)
    public Map<String, String> handleEmailExistsException(
            EmailExistsException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error_description", ex.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordException.class)
    public Map<String, String> handlePasswordException(
            PasswordException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error_description", ex.getMessage());
        return errors;
    }

    @PreAuthorize("isAnonymous()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Valid @RequestBody UserDto user) throws EmailExistsException, PasswordException {
        return service.registerNewUserAccount(user);
    }

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @PutMapping("{id}")
    public User update(@RequestBody User user, @PathVariable int id) {
        user.setId(id);
        return repository.save(user);
    }

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @DeleteMapping("{id}")
    public void remove(@PathVariable int id) {
        repository.deleteById(id);
    }
}
