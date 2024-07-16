package com.leaf.thyme.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.leaf.thyme.Entity.Student;
import com.leaf.thyme.Service.StudentService;
//dont use rest controller
@Controller
public class  StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "Students";
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("students", student);
		return "Create_newstudent";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("students") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable ("id") Long id,Model model) {
		model.addAttribute("student",studentService.getStudentByid(id));
		return "update_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable("id")Long id,
			@ModelAttribute("student") Student student , Model model) {
		Student updatedStudent = studentService.getStudentByid(id);
		updatedStudent.setId(id);
		updatedStudent.setEmail(student.getEmail());
		updatedStudent.setFirstName(student.getFirstName());
		updatedStudent.setLastName(student.getLastName());
		
		studentService.saveStudent(updatedStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteById(id);
		return "redirect:/students";
	}
	
	
	
}