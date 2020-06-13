package com.library.management.system.library_management_system.controller;

import com.google.zxing.WriterException;
import com.library.management.system.library_management_system.dto.BookDto;
import com.library.management.system.library_management_system.model.LMSException;
import com.library.management.system.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@CrossOrigin(origins = "http://localhost:4200")
@SuppressWarnings("unchecked")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto findFirst() {
        BookDto bookDto = bookService.findFirst();
        if (bookDto != null)
            return bookDto;
        else
            return new BookDto();
    }

    @GetMapping(path = "/{codeBook}", produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto findBookByCode(@PathVariable String codeBook) {
        return bookService.findByCodeBook(codeBook);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto add(@RequestBody BookDto bookDto) throws LMSException, IOException, WriterException {
        return bookService.add(bookDto);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void delete(@PathVariable Integer id) throws LMSException, IOException {
        bookService.delete(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto update(@RequestBody BookDto bookDto) throws IOException, LMSException, WriterException {
        return bookService.update(bookDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<BookDto> findByAll() {
        return bookService.findAll();
    }


}
