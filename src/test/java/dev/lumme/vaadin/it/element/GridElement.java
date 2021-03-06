package dev.lumme.vaadin.it.element;

import com.microsoft.playwright.ElementHandle;

public class GridElement {

    private final ElementHandle elementHandle;

    public GridElement(ElementHandle elementHandle) {
        this.elementHandle = elementHandle;
    }

    public void scrollToIndex(int index) {
        elementHandle.evaluate("(grid, index) => grid.scrollToIndex(index)", index);
    }

    public ElementHandle getCellByTextContent(String textContent) {
        return elementHandle.waitForSelector(String.format("vaadin-grid-cell-content >> '%s'", textContent));
    }
}
