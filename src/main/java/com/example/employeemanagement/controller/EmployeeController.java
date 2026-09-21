package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO addEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping(params = {"!page", "!size"})
    public List<EmployeeDTO> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping(params = {"page", "size"})
    public Page<EmployeeDTO> getEmployees(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return employeeService.getEmployeesWithPagination(
                PageRequest.of(page, size, sort));
    }

    @GetMapping("/search")
    public List<EmployeeDTO> searchByName(
            @RequestParam String name) {

        return employeeService.searchByName(name);
    }

    @GetMapping("/department")
    public List<EmployeeDTO> findByDepartment(
            @RequestParam String department) {

        return employeeService.findByDepartment(department);
    }

    @GetMapping("/salary")
    public List<EmployeeDTO> findByMinimumSalary(
            @RequestParam(name = "salary") double minSalary) {

        return employeeService.findByMinimumSalary(minSalary);
    }

    @GetMapping("/page")
    public Page<EmployeeDTO> getEmployeesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return employeeService.getEmployeesWithPagination(pageable);
    }

    @GetMapping("/sort/salary")
    public List<EmployeeDTO> sortEmployeesBySalary(
            @RequestParam(defaultValue = "desc") String direction) {

        Sort sort;

        if (direction.equalsIgnoreCase("desc")) {
            sort = Sort.by("salary").descending();
        } else {
            sort = Sort.by("salary").ascending();
        }

        Pageable pageable = PageRequest.of(0, 100, sort);

        return employeeService.getEmployeesWithPagination(pageable)
                .getContent();
    }

    @GetMapping("/id/{id}")
    public EmployeeDTO getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/id/{id}")
    public EmployeeDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/id/{id}")
    public String deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return "Employee deleted successfully";
    }
}