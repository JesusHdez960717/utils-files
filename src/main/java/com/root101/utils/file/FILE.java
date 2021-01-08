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

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class FILE {

    public static void copy(String desde, String hasta) throws IOException {
        File fFrom = new File(desde);
        File fTo = new File(hasta);
        if (fFrom.isDirectory()) {//voy a copiar un directorio
            if (fTo.isFile()) {
                throw new IOException("Can't copy a directory inside a file");
            } else {//directory inside directory
                fTo.mkdirs();
                FileUtils.copyDirectoryToDirectory(fFrom, fTo);//ok
            }
        } else if (fFrom.isFile()) {
            if (fTo.isDirectory()) {//file into directory
                FileUtils.copyFileToDirectory(fFrom, fTo);
            } else {//file to file
                FileUtils.copyFile(fFrom, fTo);//ok
            }
        } else {
            throw new IOException(fFrom.getAbsolutePath() + " don't found.");
        }
    }

    public static boolean delete(String path) throws IOException {
        File f = new File(path);
        if (f.isDirectory()) {
            FileUtils.deleteDirectory(f);
        } else if (f.isFile()) {
            f.delete();
        } else {
            return false;
        }
        return true;
    }
}
