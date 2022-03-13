package com.jx.springboot.repository.impl;

import com.jx.springboot.entity.Student;
import com.jx.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public void save(Student student){
        List<Student> students=jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
        long num=0;
        for(int i=0;i<students.size();i++){
            num=Math.max(num,students.get(i).getId());
        }
        num++;
        jdbcTemplate.update("insert into student(id,name,age) values(?,?,?)",num,student.getName(),student.getAge());
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void deleteById(long id) {

    }
}
