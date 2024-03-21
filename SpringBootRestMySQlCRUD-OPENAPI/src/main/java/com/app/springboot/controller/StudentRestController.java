package com.app.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.Exception.StudentNotFoundException;
import com.app.springboot.entity.Student;
import com.app.springboot.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody @Valid Student Student){
		Integer id=service.saveStudent(Student);
		return new ResponseEntity<String>("Student '"+id+"' Created",HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
//	@ApiOperation("FETCH ALL STUDENT FROM APPLICATION")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> list=service.getAllStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchOneStudent(@PathVariable Integer id){
		ResponseEntity<?> response=null;
		try {
			Student student=service.getOneStudent(id);
			response=new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		catch(StudentNotFoundException snfe) {
			//response=new ResponseEntity<String>(snfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); //500
			snfe.printStackTrace();
			throw snfe;
		}
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
//	@ApiIgnore  // please dont show this at swagger
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		ResponseEntity<String> response=null;
		try {
			service.deleteStudent(id);
			response=new ResponseEntity<String>("Student '"+id+"'Deleted",HttpStatus.OK);
		}
		catch(StudentNotFoundException snfe) {
			snfe.printStackTrace();
			//response=new ResponseEntity<String>(snfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); //500
			throw snfe;  //Exception rethrowing
		}
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		ResponseEntity<String> response=null;
		try {
			service.updateStudent(student);
			response=new ResponseEntity<String>("Student '"+student.getStdId()+"'Updated",HttpStatus.OK);
		}
		catch(StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
		}
		return response;
	}
}
