package com.jx.springboot.controller;

import com.jx.springboot.entity.Student;
import com.jx.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/find/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentRepository.findById(id);
    }

    @GetMapping("/findall")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.save(student);
    }

}
