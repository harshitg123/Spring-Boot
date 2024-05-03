package com.smartcontactmanager.smartcontactmanager.Controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smartcontactmanager.smartcontactmanager.Constants;
import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.User;
import com.smartcontactmanager.smartcontactmanager.Helper.Message;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList("image/jpeg", "image/png");

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("title", "Home - Smart contact manager");
        return "home";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("title", "About - Smart contact manager");
        return "about";
    }

    @GetMapping("/signin")
    public String getloginPage(Model model) {
        model.addAttribute("title", "Login - Smart contact manager");
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute("title", "Register - Smart contact manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/registerUser")
    public String registerUser(
            @Valid @ModelAttribute("user") User user, BindingResult result,
            @RequestParam(value = "tnc", defaultValue = "false") boolean tnc,
            Model model, @RequestParam("profilePicture") MultipartFile file) {

        try {

            System.out.println(user);
            System.out.println(tnc);

            if (!tnc) {
                System.out.println("You are not aggred to terms and conditions.");
                throw new Exception("You are not aggred to terms and conditions.");
            }

            if (result.hasErrors()) {
                System.out.println(result.toString());
                model.addAttribute("user", user);
                return "signup";
            }

            if (file.isEmpty()) {
                user.setImageUrl("default.png");
            } else {

                if (ALLOWED_IMAGE_TYPES.contains(file.getContentType())) {
                    Date date = new Date();
                    String uniqueIdentifier = String.valueOf(date.getTime());

                    String fileExtension[] = file.getOriginalFilename().split("\\.");
                    user.setImageUrl(uniqueIdentifier + "." + fileExtension[fileExtension.length - 1]);

                    String DIR = Constants.getFiledirectory();
                    Path path = Paths
                            .get(DIR + File.separator + uniqueIdentifier + "."
                                    + fileExtension[fileExtension.length - 1]);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("File saved");
                } else {
                    System.out.println("file type not suppported!");
                    model.addAttribute("user", user);
                    model.addAttribute("file", "Only .png and .jpeg file type are supported");
                    throw new Exception("Only .png and .jpeg file type are supported");
                }

            }

            user.setRole("ROLE_USER");
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);

            Message errorMessage = new Message("Successfully registered", "alert-success");
            model.addAttribute("message", errorMessage);
            model.addAttribute("user", new User());
            return "signup";

        } catch (Exception e) {
            e.printStackTrace();

            Message errorMessage = new Message("Something went wrong, " + e.getMessage(), "alert-danger");
            model.addAttribute("message", errorMessage);
            model.addAttribute("user", user);
            return "signup";
        }

    }

}
