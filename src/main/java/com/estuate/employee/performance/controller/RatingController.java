package com.estuate.employee.performance.controller;

import com.estuate.employee.performance.model.Rating;
import com.estuate.employee.performance.model.RatingValue;
import com.estuate.employee.performance.repository.RatingRepository;
import com.estuate.employee.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;
    private final PerformanceService performanceService;
    public RatingController(RatingRepository ratingRepository, PerformanceService performanceService) {
        this.ratingRepository = ratingRepository;
        this.performanceService = performanceService;
    }


    // ✅ Get all ratings
    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // ✅ Get a rating by ID
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        Optional<Rating> rating = ratingRepository.findById(id);
        return rating.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Add a new rating
    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        rating.setEmpId(null);
        Rating savedRating = ratingRepository.save(rating);
        return ResponseEntity.ok(savedRating);
    }

    // ✅ Update a rating
    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @RequestBody Rating updatedRating) {
        return ratingRepository.findById(id)
                .map(existingRating -> {
                    existingRating.setEmpName(updatedRating.getEmpName());
                    existingRating.setRate(updatedRating.getRate());
                    Rating saved = ratingRepository.save(existingRating);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Delete a rating
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Rating>> addMultipleRatings(@RequestBody List<Rating> ratings) {
        List<Rating> savedRatings = ratingRepository.saveAll(ratings);
        return ResponseEntity.ok(savedRatings);
    }

    @GetMapping("/actuals")
    public Map<RatingValue, Double> getActuals() {
        return performanceService.findActual();
    }

    @GetMapping("/deviation")
    public Map<RatingValue, Double> getDeviation() {
        return performanceService.findDeviation();
    }

    @GetMapping("/advice")
    public Map<String, Double> getAdvice() {
        return performanceService.advice();
    }



}
