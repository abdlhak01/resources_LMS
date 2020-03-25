package com.library.management.system.library_management_systelm.controller;

import com.library.management.system.library_management_systelm.dto.BookDto;
import com.library.management.system.library_management_systelm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@CrossOrigin(origins = "http://localhost:4200")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto add(@RequestBody BookDto bookDto){
        return bookService.add(bookDto);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private void delete(@RequestBody BookDto bookDto){
        bookService.add(bookDto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private BookDto update(@RequestBody BookDto bookDto){
        return bookService.update(bookDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<BookDto> findByAll(){
        return bookService.findAll();
    }


}
