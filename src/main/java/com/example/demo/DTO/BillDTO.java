package com.example.demo.DTO;

import lombok.Data;

@Data
public class BillDTO {
    private int id;
    private String name;
    private String phone;
    private String time;
    private String status;
    private int patientId; // Foreign key
}
