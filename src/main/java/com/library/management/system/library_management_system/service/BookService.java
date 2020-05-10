package com.library.management.system.library_management_system.service;

import com.google.zxing.WriterException;
import com.library.management.system.library_management_system.converter.BookConverter;
import com.library.management.system.library_management_system.dto.BookDto;
import com.library.management.system.library_management_system.entity.Book;
import com.library.management.system.library_management_system.model.QRCodeGenerator;
import com.library.management.system.library_management_system.repository.BookRepository;
import com.library.management.system.library_management_system.model.LMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookConverter bookConverter;

    @Autowired
    QRCodeGenerator qrCodeGenerator;

    public BookDto findFirst() {
        Book book = bookRepository.findFirstByOrderByBookId();
        if (book == null) {
            return null;
        } else {
            return bookConverter.convert(book);
        }
    }

    public BookDto findByCodeBook(String Code) {
        Book book = bookRepository.findByCodeBook(Code);
        if (book == null) {
            return null;
        } else {
            return bookConverter.convert(book);
        }
    }

    public BookDto getNewCode(Book book) {
        if (book != null) {
            BookDto bookDto = new BookDto();
            bookDto.setCodeBook("LIVRE" + (book.getBookId() + 1));
            return bookDto;
        } else {
            BookDto bookDto = new BookDto();
            bookDto.setCodeBook("LIVRE1");
            return bookDto;
        }
    }


    public BookDto generateCode() {
        Book book = bookRepository.findFirstByOrderByBookId();
        return getNewCode(book);
    }

    public BookDto add(BookDto bookDto) throws LMSException, IOException, WriterException {
        if (bookRepository.existsByCodeBook(bookDto.getCodeBook())) {
            throw new LMSException("Ce code \"code Livre\" existe déjà");
        }
        BookDto bookDto1 = bookConverter.convert(bookRepository.save(bookConverter.convert(bookDto)));
        qrCodeGenerator.generateQRCodeImage(bookDto1.getCodeBook(),350,350);
        return bookDto1;
    }

    public void delete(Integer id) throws LMSException {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new LMSException("Ce livre ne plus existé");
        }
    }

    public BookDto update(BookDto bookDto) {
        return bookConverter.convert(bookRepository.save(bookConverter.convert(bookDto)));
    }

    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        books.forEach(item -> {
            booksDto.add(bookConverter.convert(item));
        });
        return booksDto;
    }

}
