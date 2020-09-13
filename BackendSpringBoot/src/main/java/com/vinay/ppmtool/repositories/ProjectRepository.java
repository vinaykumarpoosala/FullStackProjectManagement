package com.vinay.ppmtool.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

	
}
