package com.example.prosper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.prosper.Service.MyBookListService;

public class MyBookListController {


    @Autowired
    private MyBookListService repository;


    @RequestMapping("/deleteBook/{id}")
    public String deleteMyList(@PathVariable("id") int id){

        repository.deleteById(id);
        return "redirect:/my_books";
    }



    
}
