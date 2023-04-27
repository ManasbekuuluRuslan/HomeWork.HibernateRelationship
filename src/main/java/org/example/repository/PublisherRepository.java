package org.example.repository;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
   Publisher savePublisher(Publisher publisher);
   Publisher getPublisherById(Long id);
   List<Publisher> getAllPublishers(String ascOrDesc);
   String updatePublisher(Long id,Publisher newPublisher);
   String deletePublisherByName(String name);
}
