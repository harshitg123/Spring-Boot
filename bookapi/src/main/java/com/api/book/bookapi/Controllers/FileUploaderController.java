package com.api.book.bookapi.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bookapi.Helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploaderController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadProfileImage")
    public ResponseEntity<String> saveProfileImage(@RequestParam MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain the file");
            }

            // save file

            if (fileUploadHelper.uploadFile(file)) {
                return ResponseEntity.ok().body("Successfull");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
