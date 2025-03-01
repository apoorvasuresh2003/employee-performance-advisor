package com.estuate.employee.performance.model;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;

    private RatingValue rate;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public RatingValue getRate() {
        return rate;
    }

    public void setRate(RatingValue rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", rate=" + rate +
                '}';
    }
}
