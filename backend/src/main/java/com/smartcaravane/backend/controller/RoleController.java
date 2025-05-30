package com.smartcaravane.backend.controller;

import com.smartcaravane.backend.model.Role;
import com.smartcaravane.backend.model.User;
import com.smartcaravane.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/public/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id){

        return roleService.getRoleById(id);
    }
    @GetMapping("/{id}/users")
    public List<User> getRoleUsers(@PathVariable Long id){
        return roleService.getRoleUsers(id);
    }

    @PostMapping()
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable Long id , @RequestBody Role role){
        roleService.updateRole(id,role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id ){
        roleService.deleteRole(id);
    }

}
