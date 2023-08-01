package com.example.prosper.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prosper.entity.Book;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {
    
}
