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
public class OpenerBrowser {

    private final URI uri;

    public static OpenerBrowser from(URI uri) {
        return new OpenerBrowser(uri);
    }

    public static OpenerBrowser from(String f) throws Exception {
        return new OpenerBrowser(new URI(f));
    }

    public OpenerBrowser(URI uri) {
        this.uri = uri;
    }

    public URI getUri() {
        return uri;
    }

    public void browser() throws Exception {
        if (!Desktop.isDesktopSupported()) {
            throw new NullPointerException("Desktop no soportado");
        }
        if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            throw new NullPointerException("Abrir el explorador no soportado");
        }
        Desktop.getDesktop().browse(uri);
    }
}
