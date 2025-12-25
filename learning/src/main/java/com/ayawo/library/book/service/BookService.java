package com.ayawo.library.book.service;

import com.ayawo.library.book.model.BookEntity;
import com.ayawo.library.book.model.exception.BookCreationException;
import com.ayawo.library.book.persistence.BookRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(String bookName, int bookPages) throws BookCreationException {

        if (bookName == null || StringUtils.isEmpty(bookName)) {
            //return "Le nom du livre ne peut pas être nul";
            throw new BookCreationException("Le nom du livre ne peut pas être nul");
        }

        if (bookPages <= 0) {
            throw new BookCreationException ("Le nombre de page ne peut pas être <= 0");
        }

        List<BookEntity> existingBook = bookRepository.findByNameAndPages(bookName, bookPages);

        if (!existingBook.isEmpty()) {

            throw new BookCreationException ("Ce livre existe déjà");

        } else {

            BookEntity newBook = BookEntity.builder()
                    .name(bookName)
                    .pages(bookPages)
                    .build();
            bookRepository.save(newBook);
            return newBook;

        }

    }

}
