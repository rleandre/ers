package com.ers.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ers.models.Employee;
import com.ers.repositories.EmployeeDAO;

public class UserServiceTest {

    private static EmployeeService employeeService;
    private static EmployeeDAO employeeDAO;

    private Employee GENERIC_EMPLOYEE_1;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        employeeService = new EmployeeService();
        employeeDAO = mock(EmployeeDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        GENERIC_EMPLOYEE_1 = new Employee(1, "genericUsername", "genericPassword", 1);
    }

    @Test
    public void testGetByUsernamePassesWhenUsernameExists() throws Exception {
        when(employeeDAO.getByUsername("genericUsername")).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

        assertEquals(Optional.of(GENERIC_EMPLOYEE_1), employeeService.getByUsername(GENERIC_EMPLOYEE_1.getEmployee_username()));

       // verify(employeeDAO).getByUsername(GENERIC_EMPLOYEE_1.getEmployee_username());
    }
}