package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String time;
    private String status;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctor;
    @OneToMany(mappedBy = "patient")
    private  List<Bill> bill;


}
