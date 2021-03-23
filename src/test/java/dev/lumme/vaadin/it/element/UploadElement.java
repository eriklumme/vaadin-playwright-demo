package dev.lumme.vaadin.it.element;

import com.microsoft.playwright.ElementHandle;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadElement {

    private final ElementHandle elementHandle;

    public UploadElement(ElementHandle elementHandle) {
        this.elementHandle = elementHandle;
    }

    public void setInputFiles(String... files) throws URISyntaxException {
        Path[] paths = new Path[files.length];
        for (int i = 0; i < files.length; i++) {
            paths[i] = Paths.get(getClass().getResource(files[i]).toURI());
        }
        elementHandle.setInputFiles(paths);
    }
}
