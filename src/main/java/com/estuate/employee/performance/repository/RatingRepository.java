package com.estuate.employee.performance.repository;

import com.estuate.employee.performance.model.Rating;
import com.estuate.employee.performance.model.RatingValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
    long countByRate(RatingValue rate);
    List<Rating> findByRate(RatingValue rate);
}
