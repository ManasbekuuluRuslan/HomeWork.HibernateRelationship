package org.example.repository;

import org.example.entity.Author;

import java.util.List;

public interface AuthorRepository {
   Author saveAuthor(Author author);
   String updateAuthor(Long id,Author newAuthor);
   Author getAuthorById(Long id);
   List<Author> getAuthorsByPublisherId(Long publisherId);
   String deleteAuthorById(Long id);
   void assignAuthorToPublisher(Long authorId,Long publisherId); //авторду издательствого кошуп коюу(назначить)).
}
