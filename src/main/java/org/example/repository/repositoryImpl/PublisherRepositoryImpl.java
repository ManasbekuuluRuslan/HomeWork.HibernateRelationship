package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Publisher;
import org.example.repository.PublisherRepository;
import java.util.List;
public class PublisherRepositoryImpl implements PublisherRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        String sql = "select p from Publisher p";
        if(ascOrDesc.equalsIgnoreCase("asc")){
            sql += "order by p.name asc";
        }else{
            sql+= "order by p.name desc";
        }
        entityManager.getTransaction().begin();
        List<Publisher> publisher = entityManager.createQuery
                (sql, Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public String updatePublisher(Long id, Publisher newPublisher) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, id);
        publisher.setName(newPublisher.getName());
        publisher.setAddress(newPublisher.getAddress());
        entityManager.merge(newPublisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newPublisher.getName() +" updated!";
    }

    @Override
    public String deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, name);
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher.getName() + " is deleted!!!";
    }
}
