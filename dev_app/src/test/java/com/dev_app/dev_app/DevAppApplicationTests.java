package com.dev_app.dev_app;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dev_app.dev_app.controller.AuthService;
import com.dev_app.dev_app.model.LoginForm;
import com.dev_app.dev_app.model.User;
import com.dev_app.dev_app.repository.InMemoryUserRepository;

@SpringBootTest
class DevAppApplicationTests {

	@Mock
	private InMemoryUserRepository userRepository;
	private AuthService authService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		authService = new AuthService(userRepository);
	}

	@Test
	void testSuccessfulLogin() {

		LoginForm loginForm = new LoginForm("testuser", "testpassword");
		User user = new User(1, "testuser", "testpassword", "ROLE_USER");
		when(userRepository.existsByUsername(loginForm.getUsername())).thenReturn(true);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

		ResponseEntity<?> response = authService.login(loginForm);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void testUnsuccessfulLoginIncorrectPassword() {

		LoginForm loginForm = new LoginForm("testuser", "incorrectPassword");
		User user = new User(1, "testuser", "testpassword", "ROLE_USER");
		when(userRepository.existsByUsername(loginForm.getUsername())).thenReturn(true);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

		ResponseEntity<?> response = authService.login(loginForm);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

	}

	@Test
	void testUnsuccessfulLoginIncorrectLogin() {
		LoginForm loginForm = new LoginForm("incorrectTestuser", "testpassword");
		User user = new User(1, "testuser", "testpassword", "ROLE_USER");
		when(userRepository.existsByUsername(loginForm.getUsername())).thenReturn(false);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

		ResponseEntity<?> response = authService.login(loginForm);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}

	@Test
	void testUnsuccessfulLoginBlankFields() {
		LoginForm loginForm = new LoginForm("", "");
		User user = new User(1, "testuser", "testpassword", "ROLE_USER");
		when(userRepository.existsByUsername(loginForm.getUsername())).thenReturn(false);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

		ResponseEntity<?> response = authService.login(loginForm);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}

}