package com.estuate.employee.performance.repository;

import com.estuate.employee.performance.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RatingRepositoryTest {

    @Autowired
    private RatingRepository ratingRepository;

    Rating rating;

    @BeforeEach
    void setUp(){

        rating=new Rating();
        rating.setEmpName("Apoorva");
        //rating.setRate("A");
        rating = ratingRepository.save(rating);
    }

    @Test
    void testAddRating(){
        Optional<Rating> retrievedRating=ratingRepository.findById(rating.getEmpId());

        assertThat(retrievedRating).isPresent();
    }

}