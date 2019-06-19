package com.example.demo.controller;

import com.example.demo.bean.Department;
import com.example.demo.bean.Employee;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ResourceLoader;


import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class EmpController {

    private final ResourceLoader resourceLoader;
    @Resource
    DepartmentMapper departmentMapper;


    @Resource
    EmployeeMapper employeeMapper;

    public EmpController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }




    @GetMapping("/emplist")
    public String getEmployee(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             Integer last,
                              Model model ){


        //前一页如果为负数
        pn=pn<=1?1:pn;
        //如果超出了后一页
        if(!ObjectUtils.isEmpty(last)) {
            pn = pn > last ? last : pn;

        }

        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询

        List<Employee> employees = employeeMapper.getEmployee();

        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(employees, 5);

        model.addAttribute("pageInfo", page);

        //没有set方法，这样做不对

        /*page.getPageNum()=page.getPageNum()<=0?1:page.getPageNum();*/




        return "list";
    }





    @GetMapping("/emp")
    public String toAdd(Model model){
        List<Department> departments = departmentMapper.getDept();
        model.addAttribute("depts",departments);
        return "add";

    }
    @PostMapping("/add")
    public String insertEmp(Employee employee, MultipartFile file, Model model) throws IOException {
        //首先是先在add里面加入数据，然后调用这个增加方法
        //UUID.randomUUID().toString()  去随机生成一串字符串
        //file.getOriginalFilename()  获取文件本来的名字（huawei.jpg）
        //file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
        //huwei.jsp-->截取字符串-->huawei.jsp的最后一个‘.’,截取出来的就是 ".jpg"
        String newName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //设置文件路径
        File path = new File("D:/File/images/"+newName);
        //将你这个文件保存到path路径下
        file.transferTo(path);

        model.addAttribute("fileName",newName);//employee.getPhoto()
        employee.setPhoto(newName);
        employeeMapper.insertEmp(employee);
        return "redirect:/emplist";
    }
    //显示个人信息的接口 info-->通过用户id去查询数据库
    @GetMapping("/info/{id}")
    public String getone(@PathVariable("id") Integer id,Model model){

       Employee employee = employeeMapper.getOne(id);
        employee.getPhoto();
        model.addAttribute("inf",employee);
        //List<Department> departments = departmentMapper.getDept();
        //model.addAttribute("d", departments);
        return "test";

    }


    @RequestMapping("/show")
    public ResponseEntity test(String fileName){

      org.springframework.core.io.Resource resource = resourceLoader.getResource("file:D:/File/images/" + fileName);
        return ResponseEntity.ok(resource);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeMapper.delete(id);
        return "redirect:/emplist";
    }

    @GetMapping("/upd/{id}")
    public String toUpdate(@PathVariable("id") Integer id,MultipartFile file,Model model) {
        Employee employee = employeeMapper.getOne(id);
        model.addAttribute("emp", employee);

        List<Department> departments = departmentMapper.getDept();
        model.addAttribute("depts", departments);


        return "add";
        }

        @PutMapping("/add")
        public String update (Employee employee,MultipartFile file,Model model){
            String newName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //设置文件路径
            File path = new File("D:/File/images/"+newName);
            //将你这个文件保存到path路径下
            try {
                file.transferTo(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            model.addAttribute("fileName",newName);//employee.getPhoto()
            employee.setPhoto(newName);
            employeeMapper.update(employee);
            return "redirect:/emplist";
        }

        @GetMapping("/see")
        public String nameSelect( String lastName,Model model){
         List<Employee> employee = employeeMapper.nameSelect(lastName);

            PageInfo page = new PageInfo(employee, 5);

            model.addAttribute("pageInfo", page);

            return "list";



        }
    }





