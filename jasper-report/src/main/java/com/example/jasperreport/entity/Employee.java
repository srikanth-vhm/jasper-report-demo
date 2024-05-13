package com.example.jasperreport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Deque;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

@Id
    private Integer id;

    private String name;
    private String designation;
    private String doj;

}
