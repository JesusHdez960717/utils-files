/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.file;

import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Opener {

    private final File file;

    public static Opener from(File f) {
        return new Opener(f);
    }

    public static Opener from(String f) {
        return new Opener(new File(f));
    }

    public Opener(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void open() throws Exception {
        if (!Desktop.isDesktopSupported()) {
            throw new RuntimeException("Desktop no soportado");
        }
        if (!Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            throw new RuntimeException("Abrir la carpeta no soportado");
        }
        try {
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            throw new RuntimeException("Error abriendo la carpeta: " + file);
        }
    }
}