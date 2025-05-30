package com.smartcaravane.backend.service;

import com.smartcaravane.backend.model.Role;
import com.smartcaravane.backend.model.User;
import com.smartcaravane.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    private List<Role> roles;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
    public Role getRoleById(Long id){
        Role role = roleRepository.findById(id).orElseThrow(()->new RuntimeException("No Role Found"));
        return role;
    }
    public List<User> getRoleUsers(Long id){
        Role role =getRoleById(id);
        return role.getUsers();
    }
    public Role createRole(Role role){
        return roleRepository.save(role);
    }
    public void updateRole(Long id, Role updatedRole){
        Role role = getRoleById(id);
        if(updatedRole.getNom()!= null) {
            role.setNom(updatedRole.getNom());
        }
        if(updatedRole.getDescription()!= null) {
        role.setDescription(updatedRole.getDescription());
        }
        roleRepository.save(role);
    }
    public void deleteRole(Long id){
        Role role = getRoleById(id);
         roleRepository.delete(role);
    }

}
