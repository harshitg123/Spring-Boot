package com.api.book.bookapi.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "/Users/harshit/Documents/Projects/spring/bookapi/src/main/resources/static/images";
    public boolean status = false;

    public boolean uploadFile(MultipartFile file) {

        try {
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
