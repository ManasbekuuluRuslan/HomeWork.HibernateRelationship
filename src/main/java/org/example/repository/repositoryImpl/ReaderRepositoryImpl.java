package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Reader;
import org.example.repository.ReaderRepository;
import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Reader saveReader(Reader reader) {
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public String updateReader(Long id, Reader newReader) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, id);
        reader.setName(newReader.getName());
        reader.setAge(newReader.getAge());
        reader.setEmail(newReader.getEmail());
        entityManager.merge(newReader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newReader.getName()+" is updated!";
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, bookId);
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public void deleteReaderById(Long id) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, id);
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Author with id: "+id+" deleted!");
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long authorId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select r from Reader r join r.book b " +
                "join b.author a where a.id = :authorId");
        query.setParameter("authorId", authorId);
        List<Reader> readers = query.getResultList();
        return readers;
    }
}
