package br.com.waterclock.api.resource;

import br.com.waterclock.api.entity.Clock;
import br.com.waterclock.api.entity.User;
import br.com.waterclock.api.entity.UserDto;
import br.com.waterclock.api.exception.EmailExistsException;
import br.com.waterclock.api.exception.PasswordException;
import br.com.waterclock.api.model.ClockModel;
import br.com.waterclock.api.repository.ClockRepository;
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

    @Autowired
    private ClockRepository clockRepository;

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @GetMapping
    public List<User> index() {
        return repository.findAll();
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

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @GetMapping("email/{email}")
    //@PostAuthorize("!hasAuthority('READ_PRIVILEGE') || (returnObject != null && returnObject.email == authentication.principal)")
    public User show(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @PreAuthorize("isAnonymous()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Valid @RequestBody UserDto user) throws EmailExistsException, PasswordException {
        return service.registerNewUserAccount(user);
    }

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
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

    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("clock_to_user")
    public User createClockUser(@RequestBody ClockModel clockModel) {
        Clock clock = clockRepository.findById(clockModel.getClockId());
        User user = repository.findById(clockModel.getUserId());
        clock.setUser(user);
        clockRepository.save(clock);
        return user;
    }
}
