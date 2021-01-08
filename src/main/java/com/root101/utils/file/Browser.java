/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.utils.file;

import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
            throw new RuntimeException("Desktop no soportado");
        }
        if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            throw new RuntimeException("Abrir el explorador no soportado");
        }
        try {
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            throw new RuntimeException("Error abriendo el explorador en la dirección: " + uri);
        }
    }
}
