package org.example.service.serviceImpl;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.repositoryImpl.AuthorRepositoryImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository = new AuthorRepositoryImpl();
    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author newAuthor) {
        return authorRepository.updateAuthor(id, newAuthor);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        return authorRepository.getAuthorsByPublisherId(publisherId);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id);
    }

    @Override
    public void assignAuthorToPublisher(Long authorId, Long publisherId) {
       authorRepository.assignAuthorToPublisher(authorId, publisherId);
    }
}
