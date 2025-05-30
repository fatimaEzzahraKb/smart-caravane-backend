package com.smartcaravane.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class LouerCaravane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate start_date;
    private LocalDate end_date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Caravane caravane;


}
