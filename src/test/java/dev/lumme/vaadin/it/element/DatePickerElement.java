package dev.lumme.vaadin.it.element;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.time.LocalDate;

public class DatePickerElement {

    private final ElementHandle elementHandle;
    private final Page page;

    public DatePickerElement(ElementHandle elementHandle, Page page) {
        this.elementHandle = elementHandle;
        this.page = page;
    }

    public void setValue(LocalDate date) {
        String formattedDate = (String) elementHandle.evaluate(
                "(elem, date) => { return new Date(date[0], date[1], date[2]).toLocaleDateString(); }",
                new Integer[]{ date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth() });

        elementHandle.type(formattedDate);
        // Without pressing Enter, the date picker stays open, and might block other elements
        elementHandle.press("Enter");

        page.waitForSelector("vaadin-date-picker-overlay",
                new Page.WaitForSelectorOptions().withState(Page.WaitForSelectorOptions.State.HIDDEN));
    }
}
