package dev.lumme.vaadin.data.service;

import dev.lumme.vaadin.data.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class BookService extends CrudService<Book, Integer> {

    private BookRepository repository;

    public BookService(@Autowired BookRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BookRepository getRepository() {
        return repository;
    }

}
