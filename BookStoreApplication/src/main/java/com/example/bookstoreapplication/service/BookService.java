package com.example.bookstoreapplication.service;

import com.example.bookstoreapplication.model.Book;
import com.example.bookstoreapplication.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        Book book1 = new Book();
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setGenre(book.getGenre());
        book1.setPrice(book.getPrice());

        return bookRepository.save(book1);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setPrice(bookDetails.getPrice());
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

