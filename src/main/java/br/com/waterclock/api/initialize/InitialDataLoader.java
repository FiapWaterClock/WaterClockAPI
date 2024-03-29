package br.com.waterclock.api.initialize;

import br.com.waterclock.api.entity.Privilege;
import br.com.waterclock.api.entity.Role;
import br.com.waterclock.api.entity.User;
import br.com.waterclock.api.repository.PrivilegeRepository;
import br.com.waterclock.api.repository.RoleRepository;
import br.com.waterclock.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Value("${waterclock.admin.username}")
    private String adminUsername;

    @Value("${waterclock.admin.password}")
    private String adminPassword;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) return;
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        createAdminUserIfNotFound();
        alreadySetup = true;
    }

    @Transactional
    void createAdminUserIfNotFound() {
        User user = userRepository.findByEmail(adminUsername);
        if (user == null) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setPassword(passwordEncoder.encode(adminPassword));
            user.setEmail(adminUsername);
            user.setRoles(Arrays.asList(adminRole));
            user.setEnabled(true);
            userRepository.save(user);
        }
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}