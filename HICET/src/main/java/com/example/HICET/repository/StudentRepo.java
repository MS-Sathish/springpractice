package com.example.HICET.repository;

import com.example.HICET.model.Student;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
    List<Student> findByEmail(String email);
    Page<Student> findAll(Pageable pageable);
   
    
}
