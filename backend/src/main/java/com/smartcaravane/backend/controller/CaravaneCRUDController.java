package com.smartcaravane.backend.controller;

import com.smartcaravane.backend.repository.LouerCaravaneRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/caraven")
public class CaravaneCRUDController {

     public  CaravaneCRUDController(LouerCaravaneRepository louerCaravaneRepository){

     }

}
