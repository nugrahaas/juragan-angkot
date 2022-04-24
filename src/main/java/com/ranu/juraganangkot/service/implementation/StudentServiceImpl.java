package com.ranu.juraganangkot.service.implementation;

import com.ranu.juraganangkot.entity.Student;
import com.ranu.juraganangkot.repository.StudentRepository;
import com.ranu.juraganangkot.service.framework.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student save(Student std) {
        return studentRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}