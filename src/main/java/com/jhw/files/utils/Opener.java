/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.files.utils;

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
        Desktop.getDesktop().open(file);
    }
}
