package dev.lumme.vaadin.data.service;

import dev.lumme.vaadin.data.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}