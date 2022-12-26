package com.example.schooldepartment.model;

import java.util.List;

public class Data {

    private Department department;

    private List<Teacher> teacherList;

    public Data() {
    }

    public Data(Department department, List<Teacher> teacherList) {
        this.department = department;
        this.teacherList = teacherList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
