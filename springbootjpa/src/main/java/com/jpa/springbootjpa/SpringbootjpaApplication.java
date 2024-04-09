package com.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.springbootjpa.Dao.UserRepository;
import com.jpa.springbootjpa.Model.User;

@SpringBootApplication
public class SpringbootjpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringbootjpaApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		User user1 = new User();

		user1.setName("harshit gupta");
		user1.setCity("karera");
		user1.setCountry("india");

		// Save single user

		// User savedUser = userRepository.save(user1);
		// System.out.println(savedUser);

		// Save multiple user

		// User user2 = new User();

		// user2.setCity("Bhopal");
		// user2.setName("Ayush");
		// user2.setCountry("India");

		// User user3 = new User();

		// user3.setCity("Bhopal");
		// user3.setName("Kuljeet");
		// user3.setCountry("India");

		// List<User> users = List.of(user2, user3);

		// Iterable<User> savedResult = userRepository.saveAll(users);
		// savedResult.forEach(user -> {
		// System.out.println(user);
		// });

		// Get and Update

		// Optional<User> optional = userRepository.findById(2l);

		// if (optional.isPresent()) {
		// try {
		// User updateUser = optional.get();
		// updateUser.setName("Ayush joshi");
		// System.out.println(userRepository.save(updateUser));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// } else {
		// System.out.println("No record found!");
		// }

		// Get all

		// Iterable<User> allUsers = userRepository.findAll();
		// allUsers.forEach(user -> {
		// System.out.println(user);
		// });

		// Delete

		// System.out.println("Deleting....");
		// userRepository.deleteById(3l);
		// System.out.println("Deleted...");

		// Delete multiple users

		// Iterable<User> allusers = userRepository.findAll();
		// allusers.forEach(user -> {
		// System.out.println(user);
		// });
		// userRepository.deleteAll(allusers);
		// System.out.println("All users deleted");

		// Custom finder methods

		// List<User> users = userRepository.findByCountry("india");
		// users.forEach(user -> {
		// System.out.println(user);
		// });

		List<User> users = userRepository.findByNameAndCity("ayush joshi", "bhopal");
		users.forEach(user -> {
			System.out.println(user);
		});

	}

}
