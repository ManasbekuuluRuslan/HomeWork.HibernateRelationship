package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Book saveBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public String updateBookAuthor(Long id, Author author) {
        entityManager.getTransaction().commit();
        Book book = entityManager.find(Book.class, id);
        book.setAuthor(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author book for "+author.getFirstName() +" successfully updated!!!";
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        Publisher publisher = book.getPublisher();
        Map<Book,Publisher> result = new HashMap<>();
        result.put(book,publisher);
        return result;
    }

    @Override
    public void deleteBookByAuthorId(Long authorId) {
         entityManager.getTransaction().begin();
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b where b.author.id = :authorId", Book.class);
        query.setParameter("authorId", authorId);
        List<Book> books = query.getResultList();
        for (Book book : books) {
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
