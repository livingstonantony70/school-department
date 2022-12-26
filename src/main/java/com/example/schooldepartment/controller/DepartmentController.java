package com.example.schooldepartment.controller;

import com.example.schooldepartment.model.Data;
import com.example.schooldepartment.model.Department;
import com.example.schooldepartment.model.Teacher;
import com.example.schooldepartment.model.TeacherParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    List<Department> list = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

    //http://localhost:8081/all
    @GetMapping("/all")
    public List<Department> getDepartments(){

        list.clear();

        list.add(new Department("B15","BCA"));
        list.add(new Department("B15","BCA"));
        list.add(new Department("B16","BBA"));
        list.add(new Department("B16","BBA"));
        list.add(new Department("B17","B.sc"));
        list.add(new Department("B18","B.com"));


        return list;
    }


    @GetMapping("/{departmentId}")
    public Data getData(@PathVariable("departmentId") String department){

        Data data = new Data();


        Department department1 = new Department();
        for (Department d:list){
            if (d.getId().equalsIgnoreCase(department)){
                department1 = d;
                break;
            }
        }
        TeacherParent teacher = restTemplate.getForObject("http://school-teachers/teachers/"+department, TeacherParent.class);

        return new Data(department1,teacher.getList());
    }

}
