package com.alexamy.example.hibernate.naming.domain.repository;

import com.alexamy.example.hibernate.naming.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
