package com.library.management.system.library_management_system.controller;

import com.google.zxing.WriterException;
import com.library.management.system.library_management_system.dto.BookDto;
import com.library.management.system.library_management_system.model.LMSException;
import com.library.management.system.library_management_system.repository.BookRepository;
import com.library.management.system.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/book")
public class BookController {


    @Autowired
    BookService bookService;

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @Autowired
    BookRepository bookRepository;



    @GetMapping("/first")
    public BookDto findFirst() {
        BookDto bookDto = bookService.findFirst();
        if (bookDto != null)
            return bookDto;
        else
            return new BookDto();
    }


    @GetMapping("/{codeBook}")
    public BookDto findBookByCode(@PathVariable String codeBook) {
        return bookService.findByCodeBook(codeBook);
    }


    @GetMapping("barCode/{codeBook}")
    public void barCode(@PathVariable String codeBook) {
        messagingTemplate.convertAndSend("/topic/progress", "UploadBook");
    }


    @PostMapping()
    public BookDto add(@RequestBody BookDto bookDto) throws LMSException, IOException, WriterException {
        return bookService.add(bookDto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws LMSException, IOException {
        bookService.delete(id);
    }


    @PutMapping()
    public BookDto update(@RequestBody BookDto bookDto) throws IOException, LMSException, WriterException {
        return bookService.update(bookDto);
    }

    @GetMapping()
    public List<BookDto> findByAll() {
        return bookService.findAll();
    }


}
