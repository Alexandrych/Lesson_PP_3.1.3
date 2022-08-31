package com.example.lesson_pp_313.configs;

import com.example.lesson_pp_313.dao.RoleDao;
import com.example.lesson_pp_313.dao.UserDao;
import com.example.lesson_pp_313.model.User;
import com.example.lesson_pp_313.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminConfig {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminConfig(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Autowired
    protected void addAdminIfNotExist() {
        if (userDao.findByUsername("admin") == null) {
            createAdmin();
        }
    }

    protected void createAdmin() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        roleDao.save(new UserRole(1L, "ROLE_ADMIN"));
        roleDao.save(new UserRole (2L, "ROLE_USER"));
        user.addRole(new UserRole (1L, "ROLE_ADMIN"));
        user.addRole(new UserRole(2L, "ROLE_USER"));
        userDao.save(user);
    }
}
