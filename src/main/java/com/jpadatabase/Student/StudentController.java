package com.jpadatabase.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping
    public void create(@RequestBody Student student){
        studentService.create(student);

    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getById(id);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
    return   studentService.update(id,student);
    }
    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Long id){
        return studentService.delete(id);
    }
}
