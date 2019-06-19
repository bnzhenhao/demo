package com.example.demo.controller;


import com.example.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
 public class UploadFileController {
    @Resource
    EmployeeMapper employeeMapper;


           //图片上传用MultipartFile接收文件,其中参数名要表单中的文件名一致
           @RequestMapping("/emplist")
    public String uploadPic(MultipartFile picFile) throws Exception {
                String picUrl = employeeMapper.UploadPic(picFile);
                if (StringUtils.isEmpty(picUrl)){
                       return "redirect:error.html";
                    }
                //重定向预览图片
                return "redirect:"+picUrl;
            }
 }
