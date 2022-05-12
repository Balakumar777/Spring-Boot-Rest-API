package com.bootSample.bootSample.student;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class studentController {
	
	private final studentService studentService;
	
	@Autowired
	public studentController(studentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public List<student>  getStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/select/{id}")
	public Optional<student>  getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	
	@PostMapping("/insert")
	public student  insertStudent(@RequestBody student stu) {
		return studentService.insertStudent(stu);
	}
	
	@PostMapping("/update/{id}")
	public student  updateStudent(@RequestBody student stu,@PathVariable int id) {
		return studentService.updateOrInsertStudent(stu,id);
	}
	
	@GetMapping("/delete")
	public String  removeAllStudent() {
		return studentService.removeAllStudent();
	}
	
	@GetMapping("/delete/{id}")
	public String  removeStudent(@PathVariable int id ) {
		return studentService.removeStudent(id);
	}
}
