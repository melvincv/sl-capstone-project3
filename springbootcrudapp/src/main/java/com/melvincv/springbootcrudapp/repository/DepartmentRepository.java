// Java Program to Illustrate DepartmentRepository File

// Importing package module to this code
package com.melvincv.springbootcrudapp.repository;
// Importing required classes
import com.melvincv.springbootcrudapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface
public interface DepartmentRepository
	extends JpaRepository<Department, Long> {
}
