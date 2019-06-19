package com.example.demo.mapper;


import com.example.demo.bean.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface EmployeeMapper {

    public List<Employee> getEmployee();


    public void insertEmp(Employee employee);
    public int delete(int id);
    public void update(Employee employee);
    public Employee getOne(int id);
    public String UploadPic(MultipartFile picFile);

    public List<Employee> nameSelect(String lastName);


   /*
   @Select("select * from employee e left join department d on e.d_id=d.id")
    public List<Employee> getEmployee();

    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Delete("delete from employee where id=#{id}")
    public int deleteEmpById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into employee(lastName) values(#{lastName})")
    public int insertEmp(Employee employee);

    @Update("update employee set latName=#{latName} where id=#{id}")
    public int updateEmp(Employee employee);*/
}
