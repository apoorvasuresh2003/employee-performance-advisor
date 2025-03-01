package com.estuate.employee.performance.service;

import com.estuate.employee.performance.model.Rating;
import com.estuate.employee.performance.model.RatingValue;
import com.estuate.employee.performance.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PerformanceService {

    private final RatingRepository ratingRepository;

    public PerformanceService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Map<RatingValue, Double> findActual(){
        List<Rating> ratings = ratingRepository.findAll();
        Map<RatingValue,Long> ratingCounts=ratings.stream().collect(Collectors.groupingBy(Rating::getRate, Collectors.counting()));

        long totalEmployees=ratings.size();
        Map<RatingValue,Double> ratingPercentage=new LinkedHashMap<>();

        if(totalEmployees>0){
            for(Map.Entry<RatingValue,Long> entry : ratingCounts.entrySet()) {
                double percentage=(entry.getValue() * 100.0)/totalEmployees;
                ratingPercentage.put(entry.getKey(),percentage);
            }
        }
        return ratingPercentage;
    }

    public Map<RatingValue, Double> findDeviation() {

        Map<RatingValue,Double> actual=findActual();

        Map<RatingValue,Double> deviation=new LinkedHashMap<>();

        Map<RatingValue, Double> standard = new LinkedHashMap<>();
        standard.put(RatingValue.A, 10.0);
        standard.put(RatingValue.B, 20.0);
        standard.put(RatingValue.C, 40.0);
        standard.put(RatingValue.D, 20.0);
        standard.put(RatingValue.E, 10.0);

        for(RatingValue rating: RatingValue.values()){
            double actualValue=actual.getOrDefault(rating,0.0);
            double standardValue=standard.getOrDefault(rating,0.0);
            double diff=actualValue-standardValue;
            deviation.put(rating,diff);
        }

        return deviation;
    }

    public static boolean allValuesZero(Map<RatingValue, Double> map) {
        return map.values().stream().allMatch(value -> value == 0.0);
    }

    public List<Rating> getEmployeesByRating(List<Rating> ratings, RatingValue ratingValue){
        return ratings.stream()
                .filter(rating -> rating.getRate().equals(ratingValue))
                .collect(Collectors.toList());
    }

    public Map<String, Double> advice(){
        Map<RatingValue,Double> deviation=findDeviation();

        Map<String, Double> movements = new LinkedHashMap<>();
        RatingValue[] values = RatingValue.values();
        boolean adjustmentsMade;

        if(allValuesZero(deviation)){
            return movements;
        }

        do {
            adjustmentsMade = false;

            // Backward pass: Move excess employees up (A → B, B → C, etc.)
            for (int i = 0; i < values.length - 1; i++) {
                RatingValue over = values[i];   // Overallocated rating
                RatingValue under = values[i + 1]; // Underallocated rating

                double overDeviation = deviation.getOrDefault(over, 0.0);
                double underDeviation = deviation.getOrDefault(under, 0.0);

                if (overDeviation > 0 && underDeviation < 0) {
                    double shift = Math.min(overDeviation, -underDeviation);
                    movements.put(over + " → " + under, movements.getOrDefault(over + " → " + under, 0.0) + shift);
                    deviation.put(over, overDeviation - shift);
                    deviation.put(under, underDeviation + shift);
                    adjustmentsMade = true;
                }
            }

            // Second pass: Move excess to neutral categories for indirect balancing
            for (int i = values.length - 1; i > 0; i--) {
                RatingValue over = values[i];
                RatingValue under = values[i - 1];

                double currentDeviation = deviation.getOrDefault(over, 0.0);
                double underDeviation = deviation.getOrDefault(under, 0.0);

                if (currentDeviation > 0 && underDeviation == 0) {
                    System.out.println(String.format("Move %.1f employees from %s to %s as a buffer. ", currentDeviation, over, under));
                    movements.put(over + " → " + under, movements.getOrDefault(over + " → " + under, 0.0) + currentDeviation);
                    deviation.put(under, currentDeviation);
                    deviation.put(over, 0.0);
                }
            }

            // Forward pass: Move excess employees down (E → D, D → C, etc.)
            for (int i = values.length - 1; i > 0; i--) {
                RatingValue over = values[i];   // Overallocated rating
                RatingValue under = values[i - 1]; // Underallocated rating

                double overDeviation = deviation.getOrDefault(over, 0.0);
                double underDeviation = deviation.getOrDefault(under, 0.0);

                if (overDeviation > 0 && underDeviation < 0) {
                    double shift = Math.min(overDeviation, -underDeviation);
                    movements.put(over + " → " + under, movements.getOrDefault(over + " → " + under, 0.0) + shift);
                    deviation.put(over, overDeviation - shift);
                    deviation.put(under, underDeviation + shift);
                    adjustmentsMade = true;
                }
            }
        } while (adjustmentsMade);  // Continue until fully balanced

        return movements;
    }
}
