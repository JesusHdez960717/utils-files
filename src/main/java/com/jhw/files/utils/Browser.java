/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.files.utils;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Browser {

    private final URI uri;

    public static Browser from(URI uri) {
        return new Browser(uri);
    }

    public static Browser from(String f) throws Exception {
        return new Browser(new URI(f));
    }

    public Browser(URI uri) {
        this.uri = uri;
    }

    public URI getUri() {
        return uri;
    }

    public void browse() throws Exception {
        if (!Desktop.isDesktopSupported()) {
            throw new NullPointerException("Desktop no soportado");
        }
        if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            throw new NullPointerException("Abrir el explorador no soportado");
        }
        Desktop.getDesktop().browse(uri);
    }
}
