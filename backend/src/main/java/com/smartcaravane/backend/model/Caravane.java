package com.smartcaravane.backend.model;

import com.smartcaravane.backend.enums.EtatFenetre;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Caravane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String matricule;
    private boolean located;

    private boolean ventillateur;
    private boolean detected_gaz;
    private boolean intensite_gaz;
    private boolean detected_movement;
    private boolean system_alert;
    private boolean fenetre;
    @Enumerated(EnumType.STRING)
    private EtatFenetre etat_fenetre;
    private boolean porte;
    private boolean eclairage;
    private boolean eclairage_intelligent;
    private boolean mode_securite;
    private boolean direction_mouvement;
    @OneToMany(mappedBy = "caravane")
    private List<LouerCaravane> locations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public boolean isLocated() {
        return located;
    }

    public void setLocated(boolean located) {
        this.located = located;
    }

    public boolean isVentillateur() {
        return ventillateur;
    }

    public void setVentillateur(boolean ventillateur) {
        this.ventillateur = ventillateur;
    }

    public boolean isDetected_gaz() {
        return detected_gaz;
    }

    public void setDetected_gaz(boolean detected_gaz) {
        this.detected_gaz = detected_gaz;
    }

    public boolean isIntensite_gaz() {
        return intensite_gaz;
    }

    public void setIntensite_gaz(boolean intensity_az) {
        this.intensite_gaz = intensity_az;
    }

    public boolean isDetected_movement() {
        return detected_movement;
    }

    public void setDetected_movement(boolean detected_movement) {
        this.detected_movement = detected_movement;
    }

    public boolean isSystem_alert() {
        return system_alert;
    }

    public void setSystem_alert(boolean system_alert) {
        this.system_alert = system_alert;
    }

    public boolean isFenetre() {
        return fenetre;
    }

    public void setFenetre(boolean fenetre) {
        this.fenetre = fenetre;
    }

    public EtatFenetre getEtat_fenetre() {
        return etat_fenetre;
    }

    public void setEtat_fenetre(EtatFenetre etat_fenetre) {
        this.etat_fenetre = etat_fenetre;
    }

    public boolean isPorte() {
        return porte;
    }

    public void setPorte(boolean porte) {
        this.porte = porte;
    }

    public boolean isEclairage() {
        return eclairage;
    }

    public void setEclairage(boolean eclairage) {
        this.eclairage = eclairage;
    }

    public boolean isEclairage_intelligent() {
        return eclairage_intelligent;
    }

    public void setEclairage_intelligent(boolean eclairage_intelligent) {
        this.eclairage_intelligent = eclairage_intelligent;
    }

    public boolean isMode_securite() {
        return mode_securite;
    }

    public void setMode_securite(boolean mode_securite) {
        this.mode_securite = mode_securite;
    }

    public boolean isDirection_mouvement() {
        return direction_mouvement;
    }

    public void setDirection_mouvement(boolean direction_mouvement) {
        this.direction_mouvement = direction_mouvement;
    }

    public List<LouerCaravane> getLocations() {
        return locations;
    }

    public void setLocations(List<LouerCaravane> locations) {
        this.locations = locations;
    }

}
