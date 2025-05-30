package com.smartcaravane.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String password;
    private String ville;
    private String pays;
    @OneToMany(mappedBy = "user")
    private List<LouerCaravane> locations;
    @ManyToOne
    @JsonManagedReference
    private Role role;

    public Long getId(){ return id;}
    public void setId(Long id){ if(id!=null){this.id = id ;}}

    public String getNom(){ return nom;}
    public void setNom(String nom){if(nom!=null){ this.nom = nom ;}}

    public String getPrenom(){ return prenom;}
    public void setPrenom(String prenom){if(prenom!=null){this.prenom = prenom ;}}

    public String getEmail(){ return email;}
    public void setEmail(String email){if(email!=null){this.email = email ;}}

    public String getPassword(){ return password;}
    public void setPassword(String password){if(password!=null){this.password = password ;}}

    public String getVille(){ return ville;}
    public void setVille(String ville){if(ville!=null) {
        this.ville = ville;
    }}

    public String getPays(){ return pays;}
    public void setPays(String pays){if(pays!=null) {
        this.pays = pays;
    }}

    public Role getRole(){ return role;}
    public void setRole(Role role){if(role!=null) {
        this.role = role;
    }}

    public List<LouerCaravane> getLocations(){ return locations;}
}
