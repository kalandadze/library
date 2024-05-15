package com.example.Library.controlller;

import com.example.Library.model.Book;
import com.example.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseBody
    public List<Book> getBooks(){
        return service.getBooks();
    }
    @PutMapping("/{bookId}/take")
    @ResponseBody
    public List<Book> takeBook(@PathVariable("bookId") Integer id){
        service.takeBook(id);
        return service.getBooks();
    }
    @PutMapping("/{bookId}/return")
    @ResponseBody
    public List<Book> returnBook(@PathVariable("bookId") Integer id){
        service.returnBook(id);
        return service.getBooks();
    }
}
