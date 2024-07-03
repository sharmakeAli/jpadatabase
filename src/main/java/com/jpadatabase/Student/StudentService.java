package com.jpadatabase.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public void create (Student student){
        studentRepository.save(student);
    }
//    public void update(Long id, Student student){
//
//    }
    public Student getById(Long id){
//        return studentRepository.findById(id).orElseThrow(()->   new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        return  studentRepository.findById(id).orElseThrow(()->
                new
                        ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student id NOT FOUND"));
    }
    public Student update(Long id ,Student student){
Student std=
        studentRepository.findById(id).orElseThrow(()->
                new
        ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student id NOT FOUND"));
std.setAge(student.getAge());
std.setPhone(student.getPhone());
std.setFullName(student.getFullName());
studentRepository.save(std);
return std;
    }
    public Student delete(Long id){
 var std=studentRepository.findById(id).orElseThrow(()->new
         ResponseStatusException(HttpStatus.NOT_FOUND,
         "NOT_FOUND"));
 studentRepository.deleteById(id);
 return std;


    }
}
