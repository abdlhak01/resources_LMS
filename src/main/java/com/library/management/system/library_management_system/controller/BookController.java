package com.library.management.system.library_management_system.controller;

import com.library.management.system.library_management_system.dto.BookDto;
import com.library.management.system.library_management_system.service.BookService;
import com.library.management.system.library_management_system.model.LMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto findFirst() {
        return bookService.findFirst();
    }

    @GetMapping(path = "/{codeBook}", produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto findBookByCode(@PathVariable String codeBook) {
        return bookService.findByCodeBook(codeBook);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto add(@RequestBody BookDto bookDto) throws LMSException {
        return bookService.add(bookDto);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void delete(@PathVariable Integer id) throws LMSException {
        bookService.delete(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto update(@RequestBody BookDto bookDto) {
        return bookService.update(bookDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<BookDto> findByAll() {
        return bookService.findAll();
    }


}
