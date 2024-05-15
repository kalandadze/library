package com.example.Library.service;

import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    BookRepository repository;
    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getBooks(){
        List<Book> books=repository.findAll();
        for (int i=books.size()-1;i>=0;i--){
            if (books.get(i).getTaken()){
                books.remove(i);
            }
        }
        return books;
    };

    public void takeBook(Integer id) {
        Book book=repository.findById(id).orElseThrow();
        book.setTaken(true);
        repository.save(book);
    }

    public void returnBook(Integer id) {
        Book book=repository.findById(id).orElseThrow();
        book.setTaken(false);
        repository.save(book);
    }
}
