package com.example.demo.controller;


import com.example.demo.bean.Department;
import com.example.demo.bean.Employee;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/*


@Controller
public class DeptController {
*/
/*

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;



    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {

        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/deptlist")
    public String getDepartment(Model model){
        model.addAttribute("depts",departmentMapper.getDeptList());
        return "list";
    }

    *//*

*/
/*@GetMapping("addpage")
    public String addPage(Model model){
        model.addAttribute("add",departmentMapper.insertDept());
    }*//*
*/
/*



    @PostMapping("/insert")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }
   *//*

*/
/* @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }*//*
*/
/*



}
*/
