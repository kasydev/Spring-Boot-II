package com.example.prosper.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prosper.entity.MyBookList;
import com.example.prosper.respository.MyBookRepository;

@Service
public class MyBookListService {

     @Autowired
     private  MyBookRepository repository;

     public void savedMyBooks(MyBookList book){

        repository.save(book);

        
     }

     public List<MyBookList> getAllMyBook(){
        return repository.findAll();
        
     }

     public void deleteById(int id){
                repository.deleteById(id);

     }

    
    
}
