package org.example.service;

import org.example.entity.Author;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    String updateAuthor(Long id,Author newAuthor);
    Author getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherId);
    String deleteAuthorById(Long id);
    void assignAuthorToPublisher(Long authorId,Long publisherId);
}
