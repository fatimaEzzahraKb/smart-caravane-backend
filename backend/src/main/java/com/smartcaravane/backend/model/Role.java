package com.smartcaravane.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smartcaravane.backend.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleEnum nom;
    private String description;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<User> users;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public RoleEnum getNom(){
        return nom;
    }
    public void setNom(RoleEnum nom){
        this.nom = nom;
    }
    public String getDescription(String description){
        return description;
    }
    public void setDescription(String description){
        this.description =description;
    }
    public  List<User> getUsers(){
        return users;
    }
    public void setUsers( List<User> users){
        this.users= users;
    }
    public void addUser(User user){
        users.add(user);
        user.setRole(this);
    }

}
