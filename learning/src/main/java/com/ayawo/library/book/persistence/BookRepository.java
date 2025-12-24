package com.ayawo.library.book.persistence;

import com.ayawo.library.book.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    public List<BookEntity> findByNameAndPages(String bookName, int bookPages);
}
