package com.smartcaravane.backend.repository;

import com.smartcaravane.backend.model.Caravane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaravaneRepository extends JpaRepository<Caravane,Long> {

}
