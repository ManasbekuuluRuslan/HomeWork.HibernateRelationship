package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Author saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public String updateAuthor(Long id, Author newAuthor) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        author.setFirstName(newAuthor.getFirstName());
        author.setLastName(newAuthor.getLastName());
        author.setEmail(newAuthor.getEmail());
        author.setCountry(newAuthor.getCountry());
        author.setGender(newAuthor.getGender());
        author.setDateOfBirth(newAuthor.getDateOfBirth());
        entityManager.merge(newAuthor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newAuthor.getFirstName() +" is updated!";
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        List<Author> authorList = new ArrayList<>(publisher.getAuthorList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return authorList;
    }

    @Override
    public String deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        for (int i = 0; i < author.getPublisherList().size(); i++) {
         author.getPublisherList().get(i).getAuthorList().remove(author);
        }
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author with id: "+id+" deleted!";
    }

    @Override
    public void assignAuthorToPublisher(Long authorId, Long publisherId) {
           entityManager.getTransaction().commit();
        Author author = entityManager.find(Author.class, authorId);
      Publisher publisher = entityManager.find(Publisher.class,publisherId);
           author.getPublisherList().add(publisher);
           publisher.getAuthorList().add(author);
           entityManager.getTransaction().commit();
           entityManager.close();
        System.out.println(author.getFirstName() +" assigned to "+ publisher.getName());
    }
}
