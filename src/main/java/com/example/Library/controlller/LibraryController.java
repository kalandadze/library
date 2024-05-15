package com.example.Library.controlller;

import com.example.Library.dto.BookDto;
import com.example.Library.model.Book;
import com.example.Library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    LibraryService service;

    @Autowired
    public LibraryController(LibraryService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseBody
    public List<Book> addBook(@RequestBody BookDto book){
        return service.addBook(book);
    }
    @DeleteMapping("/{bookId}")
    @ResponseBody
    public List<Book> deleteBook(@PathVariable("bookId")Integer id){
        return service.deleteBook(id);
    }
}
