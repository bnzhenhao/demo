package com.example.demo.mapper;


import com.example.demo.bean.Department;

import java.util.List;


//指定这是一个操作数据库的mapper
// @Mapper
public interface DepartmentMapper {
    List<Department> getDept();
   /* @Select("select * from department")
    public List<Department> getDeptList();

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);*/
}
