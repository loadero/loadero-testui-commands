package com.loadero.testui.commands;

import static testUI.elements.TestUI.E;

import org.openqa.selenium.By;

public class FileUpload {

    /**
     * Selects one of Loadero sample files into file input field.
     *
     * @param element  input field element to set file in
     * @param fileName Loadero sample file to set into input field
     */
    public static void setFile(By element, String fileName) {
        if (element == null) {
            throw new Error("[ERROR] Loadero: No input field element provided");
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new Error("[ERROR] Loadero: No filename provided");
        }

        E(element).sendKeys(fileName);
    }
}
