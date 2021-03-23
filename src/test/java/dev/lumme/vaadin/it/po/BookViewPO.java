package dev.lumme.vaadin.it.po;

import com.microsoft.playwright.Page;
import dev.lumme.vaadin.it.element.DatePickerElement;
import dev.lumme.vaadin.it.element.GridElement;
import dev.lumme.vaadin.it.element.UploadElement;

import java.net.URISyntaxException;
import java.time.LocalDate;

public class BookViewPO {

    private final Page page;
    private DatePickerElement datePicker;
    private final GridElement grid;
    private final UploadElement upload;

    public BookViewPO(Page page) {
        this.page = page;
        page.waitForSelector("#books-view");

        datePicker = new DatePickerElement(page.querySelector("vaadin-date-picker"), page);
        grid = new GridElement(page.querySelector("vaadin-grid"));
        upload = new UploadElement(page.querySelector("vaadin-upload input[type='file']"));
    }

    public void fillBook(String name, String author, LocalDate date, int pages, String isbn) {
        page.type("*css=vaadin-text-field >> 'Name'", name);
        page.type("*css=vaadin-text-field >> 'Author'", author);
        page.type("*css=vaadin-text-field >> 'Pages'", String.valueOf(pages));
        page.type("*css=vaadin-text-field >> 'Isbn'", isbn);
        datePicker.setValue(date);
    }

    public void setImage(String image) throws URISyntaxException {
        upload.setInputFiles(image);
    }

    public GridElement getGrid() {
        return grid;
    }

    public void save() {
        page.click("'Save'");
    }
}
