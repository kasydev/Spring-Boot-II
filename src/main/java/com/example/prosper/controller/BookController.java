package com.example.prosper.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.prosper.Service.BookService;
import com.example.prosper.Service.MyBookListService;
import com.example.prosper.entity.Book;
import com.example.prosper.entity.MyBookList;


@Controller
public class BookController {


    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookListService;


    @GetMapping("/")
    public String home(){

        return "home";
    }
    
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook(){

       List<Book> list = service.getAllBooks();
       ModelAndView  view = new ModelAndView();
       view.setViewName("bookList");
       return view.addObject("book", list);

    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        service.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model)
{
    
     List<MyBookList> list = myBookListService.getAllMyBook();
     model.addAttribute("book", list);
     return "myBooks";
}



@RequestMapping("/myList/{id}")
public String getMyList(@PathVariable("id") int id){

    Book book = service.getBookById(id);
    MyBookList mb = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
    myBookListService.savedMyBooks(mb);
    return "redirect:/my_books";
}

@RequestMapping("/editBook/{id}")
public String editBook(@PathVariable("id") int id, Model model){

    Book book = service.getBookById(id);
    model.addAttribute("book", book);
    return "bookEdit";
}

@RequestMapping("/deleteBook/{id}")
public String deleteBook(@PathVariable("id") int id){
    service.deleteById(id);
    return "redirect:/available_books";
}



    

 
    
}
