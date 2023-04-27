package org.example.service.serviceImpl;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.BookRepository;
import org.example.repository.repositoryImpl.BookRepositoryImpl;
import org.example.service.BookService;

import java.util.Map;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public Book saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public String updateBookAuthor(Long id, Author author) {
        return bookRepository.updateBookAuthor(id,author);
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        return bookRepository.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public void deleteBookByAuthorId(Long authorId) {
      bookRepository.deleteBookByAuthorId(authorId);
    }
}
