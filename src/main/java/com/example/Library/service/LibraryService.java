package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    BookRepository repository;

    @Autowired
    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> addBook(BookDto bookDto) {
        Book book=Book.builder()
                .name(bookDto.getName())
                .edition(bookDto.getEdition())
                .taken(false)
                .volume(bookDto.getVolume())
                .build();
        repository.save(book);
        return getBooks();
    }

    public List<Book> deleteBook(Integer id) {
        Book book=repository.findById(id).orElseThrow();
        repository.delete(book);
        return getBooks();
    }
    private List<Book> getBooks(){
        return repository.findAll();
    };
}
