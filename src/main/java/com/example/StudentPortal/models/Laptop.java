package com.example.StudentPortal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laptop_table")

public class Laptop {
    @Id
    private String ID;
    private  String name;
    private  String brand;
    private  Integer price;

    @OneToOne(mappedBy = "laptop")
    private Student student;
}
