package dev.lumme.vaadin.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;

import dev.lumme.vaadin.data.service.BookRepository;
import dev.lumme.vaadin.data.entity.Book;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(BookRepository bookRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (bookRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Book entities...");
            ExampleDataGenerator<Book> bookRepositoryGenerator = new ExampleDataGenerator<>(Book.class,
                    LocalDateTime.of(2021, 1, 23, 0, 0, 0));
            bookRepositoryGenerator.setData(Book::setId, DataType.ID);
            bookRepositoryGenerator.setData(Book::setImage, DataType.BOOK_IMAGE_URL);
            bookRepositoryGenerator.setData(Book::setName, DataType.BOOK_TITLE);
            bookRepositoryGenerator.setData(Book::setAuthor, DataType.FULL_NAME);
            bookRepositoryGenerator.setData(Book::setPublicationDate, DataType.DATE_OF_BIRTH);
            bookRepositoryGenerator.setData(Book::setPages, DataType.NUMBER_UP_TO_1000);
            bookRepositoryGenerator.setData(Book::setIsbn, DataType.EAN13);
            bookRepository.saveAll(bookRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}