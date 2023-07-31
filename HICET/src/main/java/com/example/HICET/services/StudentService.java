package com.example.HICET.services;
import com.example.HICET.Exception.BusinessException;
import com.example.HICET.model.Student;
import com.example.HICET.repository.StudentRepo;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void add(Student student) {
        Student student1 = new Student();
        student1.setEmail(student.getEmail());
        student1.setId(student.getId());
        student1.setName(student.getName());
        student1.setPassword(passwordEncoder.encode(student.getPassword()));
        
        studentRepo.save(student1);

    }
    public List<Student> getStudents() {
        List<Student> list = studentRepo.findAll();
         try {
             if(list.isEmpty()){
                throw new BusinessException("600","This is empty please add some value");
              }
           return list;
         } catch (IllegalArgumentException e) {
           throw new BusinessException("601","This is illegal");
         }
       
    
    }
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
    public void update(Student student, Long id) {
        Student student2 = studentRepo.getReferenceById(id);
        student2.setEmail(student.getEmail());
        student2.setName(student.getName());
       student2.setPassword(passwordEncoder.encode(student.getPassword()));
       studentRepo.save(student2);
    }
    public List<Student> findByName(String name) {
        List<Student> list = studentRepo.findByName(name);
        return list;
    }
    public List<Student> findByEmail(String email) {
        List<Student> llist = studentRepo.findByEmail(email);
        return llist;
    }
    
    public Page<Student> getAll(int page, int size) {
       Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        return studentRepo.findAll(pageable);
    }
	
   
}
