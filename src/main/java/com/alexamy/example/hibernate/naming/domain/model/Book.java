package com.alexamy.example.hibernate.naming.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

// set the schema name to "books"
@Table(name = "books")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private String publisher;

    private LocalDate publishedDate;
}
