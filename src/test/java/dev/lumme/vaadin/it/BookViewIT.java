package dev.lumme.vaadin.it;

import com.microsoft.playwright.ElementHandle;
import dev.lumme.vaadin.it.element.GridElement;
import dev.lumme.vaadin.it.po.BookViewPO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookViewIT extends AbstractPlaywrightIT {

    private BookViewPO bookView;

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        bookView = getLoginPage().logIn("user", "password");
    }

    @Test
    void createNewBook_bookIsDisplayedInGrid() throws URISyntaxException {
        String name = "my-name", author = "my-name", isbn = "my-isbn", image = "/test-image.png";
        LocalDate date = LocalDate.of(2020, 1, 1);
        int pages = 123;

        bookView.fillBook(name, author, date, pages, isbn);
        bookView.setImage(image);
        bookView.save();

        GridElement grid = bookView.getGrid();
        grid.scrollToIndex(999);

        grid.getCellByTextContent(name);
        grid.getCellByTextContent(author);
        grid.getCellByTextContent(date.toString());
        grid.getCellByTextContent(isbn);
        grid.getCellByTextContent(String.valueOf(pages));

        List<ElementHandle> images = getPage().querySelectorAll("vaadin-grid-cell-content img[src]");
        ElementHandle ourImage = images.get(images.size() - 1);
        int width = (int) ourImage.evaluate("elem => elem.naturalWidth");
        assertEquals(200, width);
    }
}
