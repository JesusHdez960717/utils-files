/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.files.utils;

import com.jhw.personalization.services.PersonalizationHandler;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PersonalizationFiles {

    private static final String INIT = init();

    public static final String KEY_TEMP_FOLDER = INIT + "string.temp_folder";
    public static final Object VALUE_TEMP_FOLDER = "temp";

    static {
        PersonalizationHandler.putObjectIfNotContain(KEY_TEMP_FOLDER, VALUE_TEMP_FOLDER);
    }

    private static String init() {
        return "files_personalization.key.";
    }
}
