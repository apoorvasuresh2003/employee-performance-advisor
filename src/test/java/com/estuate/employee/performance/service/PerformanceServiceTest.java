package com.estuate.employee.performance.service;

import com.estuate.employee.performance.model.Rating;
import com.estuate.employee.performance.model.RatingValue;
import com.estuate.employee.performance.repository.RatingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class PerformanceServiceTest {
    @InjectMocks
    private PerformanceService performanceService;

    @Mock
    private RatingRepository ratingRepository;
    @Test
    void findActual_test1() {
        System.out.println(performanceService.findActual());
    }

    @Test
    void findActual_test2() {

        Rating rate=new Rating();
        rate.setEmpName("Apoorva");
        rate.setRate(RatingValue.A);

        List<Rating> input=new ArrayList<>();
        input.add(rate);

        System.out.println(performanceService.findActual());
    }

    @Test
    void findActual_test3() {

        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Apoorva");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Sunil");
        rate.setRate(RatingValue.B);
        input.add(rate);

        System.out.println(performanceService.findActual());
    }

    @Test
    void findActual_test4() {

        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.E);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.E);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 13");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 12");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 14");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 15");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 11");
        rate.setRate(RatingValue.E);
        input.add(rate);

        System.out.println(performanceService.findActual());
    }

    @Test
    void findDeviation_test1() {
        System.out.println(performanceService.findDeviation());
    }

    @Test
    void findDeviation_test2() {

        Rating rate=new Rating();
        rate.setEmpName("Apoorva");
        rate.setRate(RatingValue.A);

        List<Rating> input=new ArrayList<>();
        input.add(rate);

        System.out.println(performanceService.findDeviation());
    }

    @Test
    void findDeviation_test3() {

        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Apoorva");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Sunil");
        rate.setRate(RatingValue.B);
        input.add(rate);

        System.out.println(performanceService.findDeviation());
    }

    @Test
    void findDeviation_test4() {

        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.E);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.E);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 13");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 12");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 14");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 15");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 11");
        rate.setRate(RatingValue.E);
        input.add(rate);

        System.out.println(performanceService.findDeviation());
    }

    @Test
    void findDeviation_test5() {

        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.E);
        input.add(rate);

        System.out.println(performanceService.findDeviation());
    }

    @Test
    void advice_test1() {
        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.E);
        input.add(rate);

        System.out.println(performanceService.advice());
    }

    @Test
    void advice_test2() {
        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.E);
        input.add(rate);


        when(ratingRepository.findAll()).thenReturn(input);

        System.out.println(performanceService.advice());
    }

    @Test
    void advice_test3() {
        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.B);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.E);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.E);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.E);
        input.add(rate);

        when(ratingRepository.findAll()).thenReturn(input);

        System.out.println(performanceService.advice());
    }

    @Test
    void advice_test4() {
        List<Rating> input=new ArrayList<>();

        Rating rate=new Rating();
        rate.setEmpName("Harry 1");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 3");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 4");
        rate.setRate(RatingValue.A);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 2");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 5");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 7");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 6");
        rate.setRate(RatingValue.C);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 8");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 9");
        rate.setRate(RatingValue.D);
        input.add(rate);

        rate=new Rating();
        rate.setEmpName("Harry 10");
        rate.setRate(RatingValue.D);
        input.add(rate);

        when(ratingRepository.findAll()).thenReturn(input);

        System.out.println(performanceService.advice());
    }
}