package com.leaf.thyme.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaf.thyme.Entity.Student;
import com.leaf.thyme.Repository.StudentRepository;


@Service
public class StudentService {
@Autowired
	private StudentRepository emprepository;

public  List<Student> getAllStudents() {
	return emprepository.findAll();
}

public Student saveStudent(Student student) {
	return emprepository.save(student);
}

public Student getStudentByid(Long id) {
	return emprepository.findById(id).get();
}

public void deleteById(Long id) {
	  emprepository.deleteById(id);
}


}