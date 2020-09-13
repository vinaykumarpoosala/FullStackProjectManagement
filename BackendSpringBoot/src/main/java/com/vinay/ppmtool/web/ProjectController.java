package com.vinay.ppmtool.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.ppmtool.domain.Project;
import com.vinay.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project , BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			result.getFieldErrors()
					.stream()
					.forEach(err -> {	
				errorMap.put(err.getField(), err.getDefaultMessage());
			});
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		
		Project project1 = service.saveOrUpdate(project);
		return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
	}
}
