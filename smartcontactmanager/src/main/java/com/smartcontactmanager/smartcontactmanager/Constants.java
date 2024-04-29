package com.smartcontactmanager.smartcontactmanager;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class Constants {

    public static String getFiledirectory() throws IOException {
        final String fileDirectory = new ClassPathResource("static/img").getFile().getAbsolutePath();
        return fileDirectory;
    }

}
