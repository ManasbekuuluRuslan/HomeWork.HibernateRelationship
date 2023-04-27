package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;

import java.util.Map;

public interface BookService {
    Book saveBook(Book book);
    String updateBookAuthor(Long id, Author author);
    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId);
    void deleteBookByAuthorId(Long authorId);
}
