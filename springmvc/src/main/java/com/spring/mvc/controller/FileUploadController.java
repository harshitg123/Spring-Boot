package com.spring.mvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {
    
    @RequestMapping(path = "/uploadFile", method=RequestMethod.GET)
    public String showFileForm() {
        return "uploadFileForm";
    }

    @RequestMapping(path = "/uloadProfilePicture", method=RequestMethod.POST)
    public String uploadFileForm(@RequestParam("profilePicture") MultipartFile file, HttpSession session) {

        System.out.println(file.getSize());
        System.out.println(file.getName());

        String path = session.getServletContext().getRealPath("/") + "WEB-INF" + 
                        File.separator + "resources" + File.separator + "uploadedFiles" +
                        File.separator + file.getOriginalFilename();
        System.out.println(path);

        try {
            byte[] fileData = file.getBytes();
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(fileData);
            fos.close();
            System.out.println("File uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in file uploading.......");
        }


        return "";
    }
    

}
