package com.library.management.system.library_management_systelm.service;

import com.library.management.system.library_management_systelm.Converter.BookConverter;
import com.library.management.system.library_management_systelm.dto.BookDto;
import com.library.management.system.library_management_systelm.entity.Book;
import com.library.management.system.library_management_systelm.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    BookConverter bookConverter = new BookConverter();

    public BookDto add(BookDto bookDto) {
        return bookConverter.convert(bookRepository.save(bookConverter.convert(bookDto)));
    }

    public void delete(BookDto bookDto) {
        bookRepository.delete(bookConverter.convert(bookDto));
    }
    public BookDto update(BookDto bookDto) {
        return bookConverter.convert(bookRepository.save(bookConverter.convert(bookDto)));
    }
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        books.forEach(item->{
            booksDto.add(bookConverter.convert(item));
        });
        return booksDto;
    }

}
