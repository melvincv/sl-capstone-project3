// Java Program to Illustrate DepartmentController File

// Importing package module to this code
package com.melvincv.springbootcrudapp.controller;

import com.melvincv.springbootcrudapp.entity.Department;
import com.melvincv.springbootcrudapp.service.DepartmentService;
import java.util.List;
// import javax.validation.Valid;
// Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController

// Class
public class DepartmentController {

	// Annotation
	@Autowired private DepartmentService departmentService;

	// Save operation
	@PostMapping("/departments")
	public Department saveDepartment(
		@Valid @RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
	}

	// Read operation
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList()
	{
		return departmentService.fetchDepartmentList();
	}

	// Update operation
	@PutMapping("/departments/{id}")
	public Department
	updateDepartment(@RequestBody Department department,
					@PathVariable("id") Long departmentId)
	{
		return departmentService.updateDepartment(
			department, departmentId);
	}

	// Delete operation
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")
									Long departmentId)
	{
		departmentService.deleteDepartmentById(
			departmentId);
		return "Deleted Successfully";
	}
}
