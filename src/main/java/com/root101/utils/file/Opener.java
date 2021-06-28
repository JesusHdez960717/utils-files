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
import java.io.File;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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

    public void open() throws RuntimeException {
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
