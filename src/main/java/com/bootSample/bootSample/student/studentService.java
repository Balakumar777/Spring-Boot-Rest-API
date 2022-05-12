package com.bootSample.bootSample.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
	private final studentRepository repository;
	
	@Autowired
	public studentService(studentRepository repository) {
		this.repository = repository;
	}
	
    public List<student> getStudents() {
        return repository.findAll();
    }
    
    public Optional<student> getStudent(int id) {
        return repository.findById(id);
    }
    
    public student insertStudent(student stu) {
        return repository.save(stu);
    }
    
    public student updateOrInsertStudent(student stu,int id) {
    	System.out.println("ID"+id);
    	if(repository.existsById(id)) {
    		student student = new student();
        	student.setId(id);
        	student.setName(stu.getName());
        	student.setRole(stu.getRole());
        	return repository.save(student);
    	}
    	return repository.save(stu);
    }
    
    public String removeStudent(int id) {
    	if(repository.existsById(id)) {
    		repository.deleteById(id);
    		return "Successfully removed";
    	}
    	else {
    		return "No users found with id " +id;
    	} 
    }
    
    public String removeAllStudent() {
    	repository.deleteAll();
    	return "All records are deleted";
    }
    
    
}
