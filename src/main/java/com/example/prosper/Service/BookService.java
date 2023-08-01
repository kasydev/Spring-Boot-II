package com.example.prosper.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prosper.entity.Book;
import com.example.prosper.respository.BookRespository;

@Service
public class BookService {

    @Autowired
    private BookRespository repository;

    public void save(Book book){
            repository.save(book);
        
    }

    public List<Book> getAllBooks(){

        return repository.findAll();
    }


    public Book getBookById(int id){

        return repository.findById(id).get();

    }

     public void deleteById(int id){

      repository.deleteById(id);
     }
    
    
}
