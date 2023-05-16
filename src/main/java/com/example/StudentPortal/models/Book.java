package com.example.StudentPortal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    private String Id;
    private String bookTitle;
    private String bootAuthor;
    private String bookDescription;
    private String bookPrice;

    @ManyToOne
    private Student student;

}
