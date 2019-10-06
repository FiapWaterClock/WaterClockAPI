package br.com.waterclock.api.service;

import br.com.waterclock.api.entity.User;
import br.com.waterclock.api.entity.UserDto;
import br.com.waterclock.api.exception.EmailExistsException;
import br.com.waterclock.api.exception.PasswordException;
import br.com.waterclock.api.repository.RoleRepository;
import br.com.waterclock.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository repository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException, PasswordException {

        if (emailExists(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "
                    + accountDto.getEmail());
        }

        if (!accountDto.getPassword().equals(accountDto.getMatchingPassword())) {
            throw new PasswordException("The passwords do not match");
        }

        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setEnabled(true);
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return repository.save(user);
    }
    private boolean emailExists(String email) {
        User user = repository.findByEmail(email);
        return (user != null);
    }
}