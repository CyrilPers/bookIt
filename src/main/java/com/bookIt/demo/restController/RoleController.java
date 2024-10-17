package com.bookIt.demo.restController;

import com.bookIt.demo.model.Role;
import com.bookIt.demo.repository.RoleRepository;
import com.bookIt.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleSvc;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role) {
        return roleSvc.save(role);
    }

    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleSvc.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public List<Role> deleteRole(@PathVariable int id) {
        return roleSvc.deleteById(id);
    }
}
