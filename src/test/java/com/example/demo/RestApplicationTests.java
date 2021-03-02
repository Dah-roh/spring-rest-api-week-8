package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RestApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

//	@Before
//	private Employee employee = new Employee();

	@Test
	public void addEmployeesTest() {
		Employee employee = new Employee();
		employee.setName("Zlatan Burna");
		employee.setId(32l);
		employee.setLevel("GOAT");
		employee.setSalary(500000.00);
//		given(employeeRepository.save(ArgumentMatchers.any(Employee.class))).willReturn(employee);
		when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
		Employee added = employeeService.addEmployees(employee);
		assertEquals(added.getName(), employee.getName());
		verify(employeeRepository).save(employee);

	}

	@Test
	public void listEmployeesTest() {
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setName("Zlatan Burna");
		employee.setId(32l);
		employee.setLevel("GOAT");
		employee.setSalary(500000.00);
		Employee employee1 = new Employee();
		employee1.setName("Ronaldo");
		employee1.setId(4l);
		employee1.setLevel("GOAT");
		employee1.setSalary(5000000.00);
		employeeList.add(employee);
		employeeList.add(employee1);
		when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
		when(employeeRepository.save(employee1)).thenReturn(employee);
		Employee added = employeeService.addEmployees(employee);
		Employee added1 = employeeService.addEmployees(employee1);
		given(employeeRepository.findAll()).willReturn(employeeList);
		List<Employee> listEmployees = employeeService.listEmployees();
		assertEquals(listEmployees.size(), employeeList.size());
		verify(employeeRepository).findAll();
	}
//Jar
	//war



}
