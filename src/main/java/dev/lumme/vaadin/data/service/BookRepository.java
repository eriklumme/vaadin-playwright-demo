package dev.lumme.vaadin.data.service;

import dev.lumme.vaadin.data.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.Lob;
import java.time.LocalDate;

public interface BookRepository extends JpaRepository<Book, Integer> {

}