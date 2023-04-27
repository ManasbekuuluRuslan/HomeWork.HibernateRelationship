package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;

import java.util.Map;

public interface BookRepository {
    Book saveBook(Book book);
    String updateBookAuthor(Long id, Author author);
    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId);
    void deleteBookByAuthorId(Long authorId);
}
