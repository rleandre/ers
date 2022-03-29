package com.ers.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.ers.exceptions.NewUserHasNonZeroIdException;
import com.ers.exceptions.RegistrationUnsuccessfulException;
import com.ers.repositories.UserDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ers.exceptions.UsernameNotUniqueException;
import com.ers.models.Role;
import com.ers.models.User;

public class AuthServiceTest {
	
	private static AuthService authService;
	private static UserService userService;
	private static UserDAO userDAO;

	private User EMPLOYEE_TO_REGISTER;
	private User GENERIC_EMPLOYEE_1;
	private User GENERIC_FINANCE_MANAGER_1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		authService = new AuthService();
		userService = mock(UserService.class);
		userDAO = mock(UserDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {
		EMPLOYEE_TO_REGISTER = new User(0, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
		GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
		GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
	}

	@Test
	public void testRegisterFailsWhenUsernameIsTaken() {
		when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
		
		assertThrows(UsernameNotUniqueException.class,
			() -> authService.register2(EMPLOYEE_TO_REGISTER)
		);

		//verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
		//verify(userDAO, never()).create(EMPLOYEE_TO_REGISTER);
	}

	@Test
	public void testRegisterPassesWhenUsernameIsNotTaken() {
		when(userService.getByUsername(anyString())).thenReturn(Optional.empty());
		when(userDAO.create(GENERIC_EMPLOYEE_1)).thenReturn(GENERIC_EMPLOYEE_1);
		
		assertEquals(GENERIC_EMPLOYEE_1, authService.register(EMPLOYEE_TO_REGISTER));

		//verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
		//verify(userDAO).create(EMPLOYEE_TO_REGISTER);
	}

	@Test
	public void testRegisterFailsWhenRegistrationIsUnsuccessful() {
		when(userDAO.create1(GENERIC_EMPLOYEE_1)).thenThrow(new RegistrationUnsuccessfulException());

		assertThrows(RegistrationUnsuccessfulException.class,
				() -> authService.register3(EMPLOYEE_TO_REGISTER)
		);
	}

	@Test
	public void testRegisterFailsWhenIdIsNonZero() {
		EMPLOYEE_TO_REGISTER.setId(1000);

		assertThrows(NewUserHasNonZeroIdException.class,
				() -> authService.register1(EMPLOYEE_TO_REGISTER)
		);
	}

	@Test
	public void testLoginPassesWhenUsernameDoesExistAndPasswordMatches() {
		when(userService.getByUsername("genericEmployee1")).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

		assertEquals(GENERIC_EMPLOYEE_1, authService.login1(GENERIC_EMPLOYEE_1.getUsername(), GENERIC_EMPLOYEE_1.getPassword()));

		//verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
	}
}