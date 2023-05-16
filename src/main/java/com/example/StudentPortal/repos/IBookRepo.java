package com.example.StudentPortal.repos;

import com.example.StudentPortal.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,String> {
}
