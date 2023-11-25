package com.qpassessment.demo;

import com.qpassessment.demo.entity.Role;
import com.qpassessment.demo.entity.User;
import com.qpassessment.demo.repository.RoleRepository;
import com.qpassessment.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setName("admin");
		roleRepository.save(role);

		Role role1 = new Role();
		role1.setName("user");
		roleRepository.save(role1);

		User user = new User();
		user.setEmail("akshay@gmail.com");
		user.setName("akshay");
		user.setPassword( new BCryptPasswordEncoder().encode("pass"));
		user.setRole(role);
		userRepository.save(user);

		User user1 = new User();
		user1.setEmail("akshay1@gmail.com");
		user1.setName("akshay");
		user1.setPassword( new BCryptPasswordEncoder().encode("pass"));
		user1.setRole(role1);
		userRepository.save(user1);
	}
}
