package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.PublisherService;
import org.example.service.ReaderService;
import org.example.service.serviceImpl.AuthorServiceImpl;
import org.example.service.serviceImpl.BookServiceImpl;
import org.example.service.serviceImpl.PublisherServiceImpl;
import org.example.service.serviceImpl.ReaderServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */

public class App {
    public static void main( String[] args ) {
          PublisherService publisherService = new PublisherServiceImpl();
          AuthorService authorService = new AuthorServiceImpl();
          BookService bookService = new BookServiceImpl();
          ReaderService readerService = new ReaderServiceImpl();
//        System.out.println(HibernateConfig.getEntityManager());
//        Publisher publisher = new Publisher("Azimbek","Gagarina21/3");
//        Publisher publisher1 = new Publisher("Liya Raden","Belovodskiy");
//        publisherService.savePublisher(publisher);
//        publisherService.savePublisher(publisher1);
//        System.out.println(publisherService.getPublisherById(1L));
//        System.out.println(publisherService.deletePublisherByName("Liya Raden"));
//        authorService.saveAuthor(new Author("Chyngyz","Aitmatov","chyngyz@gmail.com",
//        LocalDate.of(1957,11,23),"Kyrgyzstan", Gender.MALE));
//        authorService.saveAuthor(new Author("Alykul","Osmonov","alykul@gmail.com",
//        LocalDate.of(1974,7,12),"Kyrgyzstan", Gender.MALE));
//        System.out.println(bookService.saveBook(new Book("Titanik", "USA",
//        LocalDate.of(2002, 12, 22), 1200, Genre.ROMANTIC)));
//        System.out.println(readerService.saveReader(new Reader("Ruslan", 21, "rusi@gmail.com")));
//        System.out.println(publisherService.updatePublisher(1L, new Publisher("Erbol", "Chuyskiy")));
//        System.out.println(publisherService.getPublisherById(2L));
//        System.out.println(publisherService.getAllPublishers("desc"));
//        System.out.println(authorService.deleteAuthorById(1L));
//        System.out.println(authorService.getAuthorById(2L));
//        authorService.assignAuthorToPublisher(2L,3L);
//        System.out.println(authorService.getAuthorsByPublisherId(2L));
//        System.out.println(bookService.getBookAndPublisherByBookId(3L));
//        bookService.deleteBookByAuthorId(2L);
//        System.out.println(bookService.updateBookAuthor(3L, new Author("Matmusa", "Aabduvohob uulu", "musa@gmail.com",
//        LocalDate.of(2001, 2, 11), "Kyrgyzstan", Gender.MALE)));
//        readerService.deleteReaderById(3L);
//        System.out.println(readerService.getReaderByBookId(3L));
//        System.out.println(readerService.getReadersByAuthorId(2L));
//        System.out.println(readerService.updateReader(1L, new Reader("Adilet", 21, "adi@gmail.com")));
    }
}
