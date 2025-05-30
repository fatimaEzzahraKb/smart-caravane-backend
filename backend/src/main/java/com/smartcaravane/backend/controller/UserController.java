package com.smartcaravane.backend.controller;

import com.smartcaravane.backend.model.Role;
import com.smartcaravane.backend.model.User;
import com.smartcaravane.backend.repository.RoleRepository;
import com.smartcaravane.backend.repository.UserRepository;
import com.smartcaravane.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/public/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/role/{roleId}")
    public List<User> getUsersByRole(@PathVariable Long roleId){
        return userService.getUsersByRole(roleId);
    }

    public static  class RequestBodyWrapper{
        public User user;
        public Long role_id;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody RequestBodyWrapper request){
        User user = request.user;
        Long role_id = request.role_id;
        User newUser = userService.createUser(user,role_id);


        /*Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully.");
        response.put("user", user);
        response.put("roleId", role);*/


       return ResponseEntity.ok(newUser);

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        Optional<User> user = userRepository.findById(id);
        updatedUser.setId(user.get().getId());
        return userRepository.save(updatedUser);
    }
    @PutMapping("/password/{id}")
    public ResponseEntity<String> updateUserPassword(@PathVariable Long id, @RequestBody String password){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userService.updatePassword(userOptional.get(),password);
        return ResponseEntity.ok("Response updated Sccessfully.");
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok("User Deleted Successfully.");
    }
}
