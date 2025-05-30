package com.smartcaravane.backend.service;

import com.smartcaravane.backend.model.Role;
import com.smartcaravane.backend.model.User;
import com.smartcaravane.backend.repository.RoleRepository;
import com.smartcaravane.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private RoleRepository roleRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User createUser(User user, Long role_id){
        Optional<Role> role = roleRepository.findById(role_id);
        if(role.isPresent()){
            role.get().addUser(user);
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return  userRepository.save(user);
    }

    public void updatePassword(User user, String password){
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public List<User> getUsersByRole(Long roleId){
        Optional<Role> role = roleRepository.findById(roleId);
        if(role.isPresent()){
            List<User> users = userRepository.findByRole(role.get());
            return users;
        }
        else{
            return null;
        }
    }
}
