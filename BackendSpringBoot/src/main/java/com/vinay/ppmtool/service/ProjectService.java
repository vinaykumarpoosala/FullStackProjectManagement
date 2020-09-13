package com.vinay.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.ppmtool.domain.Project;
import com.vinay.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public Project saveOrUpdate(Project project) {
		
		return projectRepository.save(project);
	}
}
