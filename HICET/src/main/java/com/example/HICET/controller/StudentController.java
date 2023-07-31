package com.example.HICET.controller;


import com.example.HICET.model.Student;
import com.example.HICET.services.StudentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<?> getStudents()throws Exception{
        List<Student> list = studentService.getStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/students/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        List<Student> list = studentService.findByName(name);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
      @GetMapping("/studentsbyEmail")
    public ResponseEntity<?> getStudentByEmail(@RequestParam String email){
        List<Student> list = studentService.findByEmail(email);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student)throws Exception{
        studentService.add(student);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)throws Exception{
        studentService.delete(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@RequestBody Student student ,@PathVariable Long id)throws Exception{
    studentService.update(student,id);
    return new ResponseEntity<>("Updated", HttpStatus.OK);
   }
 
   

   @GetMapping("/get")
   public ResponseEntity<Page<Student>> gellAll(@RequestParam int page,@RequestParam int size ){
    Page<Student> page2 = studentService.getAll(page,size);
    return new ResponseEntity<>(page2,HttpStatus.OK);
   }
}
