package com.spring.jdbc.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Entity.Student;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // insert data
        String query = "insert into student(id, name, city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
    }

    @Override
    public int modify(Student student) {
        // update data
        String query = "update student set name=? , city=? where id=?";
        int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return result;
    }

    @Override
    public int remove(Student student) {
        // delete data
        String query = "delete from student where id=?";
        int result = this.jdbcTemplate.update(query, student.getId());
        return result;
    }

    @Override
    public Student getStudent(int studentId) {
        // get single student data
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student st = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return st;
    }
    
}
