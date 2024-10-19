package com.bookIt.demo.service;

import com.bookIt.demo.model.Role;
import com.bookIt.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepo;

    Role findById(int id) {
        return roleRepo.findById(id);
    }

    public Role save(Role role) {
        return roleRepo.save(role);
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public List<Role> deleteById(int id) {
        roleRepo.deleteById(id);
        return roleRepo.findAll();
    }
}
