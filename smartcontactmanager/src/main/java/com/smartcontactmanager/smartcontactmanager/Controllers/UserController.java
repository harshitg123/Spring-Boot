package com.smartcontactmanager.smartcontactmanager.Controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartcontactmanager.smartcontactmanager.Constants;
import com.smartcontactmanager.smartcontactmanager.Dao.ContactRepository;
import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.Contact;
import com.smartcontactmanager.smartcontactmanager.Entites.User;
import com.smartcontactmanager.smartcontactmanager.Helper.Message;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @ModelAttribute
    public void commonData(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByEmail(username);
        model.addAttribute("user", user);
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model, Principal principal) {
        model.addAttribute("title", "User dashboard");
        return "normal/user-dashboard";
    }

    @GetMapping("/addContact")
    public String addContactForm(Model model) {
        model.addAttribute("title", "Add contact");
        model.addAttribute("contact", new Contact());
        return "normal/add_contact_form";
    }

    @PostMapping("/addContact")
    public String saveContactData(@Valid @ModelAttribute("contact") Contact contact, BindingResult result,
            @RequestParam("profileImage") MultipartFile file,
            Principal principal, Model model) {

        try {

            final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList("image/jpeg", "image/png");

            if (result.hasErrors()) {
                System.out.println(result);
                model.addAttribute("contact", contact);
                return "normal/add_contact_form";
            }

            if (file.isEmpty()) {
                System.out.println("Empty file!");
                contact.setImageUrl("default.png");
            } else {

                if (ALLOWED_IMAGE_TYPES.contains(file.getContentType())) {
                    Date date = new Date();
                    String uniqueIdentifier = String.valueOf(date.getTime());

                    String fileExtension[] = file.getOriginalFilename().split("\\.");
                    contact.setImageUrl(uniqueIdentifier + "." + fileExtension[fileExtension.length - 1]);

                    String DIR = Constants.getFiledirectory();
                    Path path = Paths
                            .get(DIR + File.separator + uniqueIdentifier + "."
                                    + fileExtension[fileExtension.length - 1]);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("File saved");
                } else {
                    System.out.println("file type not suppported!");
                    model.addAttribute("contact", contact);
                    model.addAttribute("file", "Only .png and .jpeg file type are supported");
                    throw new Exception("File type not supported");
                }

            }

            User user = userRepository.findByEmail(principal.getName());
            contact.setUser(user);
            user.getContacts().add(contact);
            userRepository.save(user);
            System.out.println("Contact saved");
            model.addAttribute("contact", new Contact());
            model.addAttribute("message", new Message("Contact added successfully!", "alert-success"));
            return "normal/add_contact_form";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("contact", contact);
            model.addAttribute("message", new Message("Something went wrong!", "alert-danger"));
            return "normal/add_contact_form";
        }

    }

    @GetMapping("/showContacts/{page}")
    public String getAllContacts(@PathVariable("page") int page, Model model, Principal principal) {
        model.addAttribute("title", "Show user contacts");
        User user = userRepository.findByEmail(principal.getName());

        // pagable is an interface so we will use its implementation class to set page
        // and records
        Pageable pageable = PageRequest.of(page, 10);

        Page<Contact> contacts = contactRepository.findByUser(user, pageable);

        if (!contacts.isEmpty()) {
            model.addAttribute("contacts", contacts);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", contacts.getTotalPages());
            model.addAttribute("isContactAvailable", "Yes");
        } else {
            model.addAttribute("isContactAvailable", "No");
        }

        return "normal/show_contacts";
    }

    @GetMapping("/{contactId}/contact")
    public String getMethodName(@PathVariable("contactId") Long contactId, Model model, Principal principal) {

        Optional<Contact> cOptional = contactRepository.findById(contactId);
        Contact contact = cOptional.get();

        Long loggedInUserId = userRepository.findByEmail(principal.getName()).getId();
        Long contactUserId = contact.getUser().getId();

        if (loggedInUserId == contactUserId) {
            model.addAttribute("title", contact.getName());
            model.addAttribute("contact", contact);
        } else {
            model.addAttribute("title", "Not Authorize");
        }

        return "normal/contact_details";
    }

    @GetMapping("/edit/{contactId}")
    public String showEditForm(@PathVariable("contactId") Long contactId, Model model, Principal principal) {

        Optional<Contact> cOptional = contactRepository.findById(contactId);
        Contact contact = cOptional.get();

        model.addAttribute("title", "Update - " + contact.getName());
        model.addAttribute("contact", contact);
        return "normal/edit_contact_form";
    }

    @GetMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long contactId, Model model, Principal principal) {

        Contact contact = contactRepository.findById(contactId).get();

        Long loggedInUserId = userRepository.findByEmail(principal.getName()).getId();
        Long contactUserId = contact.getUser().getId();

        if (loggedInUserId == contactUserId) {
            contactRepository.deleteById(contactId);
            return "redirect:/user/showContacts/0";
        } else {
            model.addAttribute("title", "Not Authorize");
            model.addAttribute("isAuthorize", "No");
            return "normal/edit_contact_form";
        }

    }

}
