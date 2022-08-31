package com.example.lesson_pp_313.dao;

import com.example.lesson_pp_313.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<UserRole, Long> {
}
