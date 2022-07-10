// Java Program to Illustrate DepartmentServiceImpl File

// Importing package module to this code
package com.melvincv.springbootcrudapp.service;

import com.melvincv.springbootcrudapp.entity.Department;
import com.melvincv.springbootcrudapp.repository.DepartmentRepository;
// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service

// Class
public class DepartmentServiceImpl
	implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	// Save operation
	@Override
	public Department saveDepartment(Department department)
	{
		return departmentRepository.save(department);
	}

	// Read operation
	@Override public List<Department> fetchDepartmentList()
	{
		return (List<Department>)
			departmentRepository.findAll();
	}

	// Update operation
	@Override
	public Department
	updateDepartment(Department department,
					Long departmentId)
	{
		Department depDB
			= departmentRepository.findById(departmentId)
				.get();

		if (Objects.nonNull(department.getDepartmentName())
			&& !"".equalsIgnoreCase(
				department.getDepartmentName())) {
			depDB.setDepartmentName(
				department.getDepartmentName());
		}

		if (Objects.nonNull(
				department.getDepartmentAddress())
			&& !"".equalsIgnoreCase(
				department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(
				department.getDepartmentAddress());
		}

		if (Objects.nonNull(department.getDepartmentCode())
			&& !"".equalsIgnoreCase(
				department.getDepartmentCode())) {
			depDB.setDepartmentCode(
				department.getDepartmentCode());
		}

		return departmentRepository.save(depDB);
	}

	// Delete operation
	@Override
	public void deleteDepartmentById(Long departmentId)
	{
		departmentRepository.deleteById(departmentId);
	}
}
