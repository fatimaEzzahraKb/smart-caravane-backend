package com.smartcaravane.backend.repository;

import com.smartcaravane.backend.model.LouerCaravane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LouerCaravaneRepository extends JpaRepository<LouerCaravane,Long> {
    @Query("SELECT l FROM LouerCaravane l WHERE l.caravane.id = :caravaneId AND " +
    "(:startDate <= l.end_date AND :endDate >= l.start_date)")
    List<LouerCaravane> findReservationConflicts(@Param("caravaneId") Long caravaneId,
                                                 @Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate);

}
