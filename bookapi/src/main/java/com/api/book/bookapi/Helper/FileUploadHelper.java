package com.api.book.bookapi.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR =
    // "/Users/harshit/Documents/Projects/spring/bookapi/src/main/resources/static/images";
    // Handel dynamic paths for uploading paths
    public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getPath();

    public boolean status = false;

    public FileUploadHelper() throws Exception {

    }

    public boolean uploadFile(MultipartFile file) {

        try {
            System.out.println("path " + UPLOAD_DIR);
            Files.copy(
                    file.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            status = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return status;
    }
}
