package com.ayawo.library.book.controllers;

import com.ayawo.library.book.dto.BookDTO;
import com.ayawo.library.book.model.BookEntity;
import com.ayawo.library.book.model.exception.BookCreationException;
import com.ayawo.library.book.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO.PostOutput post(@Valid @RequestBody BookDTO.PostInput input) throws BookCreationException {

        BookEntity newBook = bookService.createBook(
                input.getBookName(),
                input.getBookPages()
        );

        BookDTO.PostOutput output = BookDTO.PostOutput.builder()
                .id(newBook.getId())
                .bookName(input.getBookName())
                .bookPages(input.getBookPages())
                .build();
        return output;

    }
}
