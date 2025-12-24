package com.ayawo.library.book.controllers;

import com.ayawo.library.book.dto.BookDTO;
import com.ayawo.library.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String get(
            @RequestParam String bookName,
            @RequestParam int bookPages
    ){

        return "OK GET";

    }

    @PostMapping
    public String post(@RequestBody BookDTO.PostInput input){

        String response = bookService.createBook(
                input.getBookName(),
                input.getBookPages()
        );
        return response;

    }
}
