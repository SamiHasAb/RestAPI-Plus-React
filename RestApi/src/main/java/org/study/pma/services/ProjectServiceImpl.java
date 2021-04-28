package org.study.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.pma.exceptions.ProjectIdException;
import org.study.pma.models.Project;
import org.study.pma.repositories.ProjectRepository;


@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository proRep;
	
	@Override
	public Project saveOrUpdate(Project project) {
		
		project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
		
		 try{
	            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
	            return proRep.save(project);
	        }catch (Exception e){
	            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
	        }

		
	}

	@Override
	public Project findProjectByIdentifier(String projectIdent) {

		Project project = proRep.findByProjectIdentifier(projectIdent.toUpperCase());
		
		if (project == null) 
			throw new ProjectIdException("Can not find project with ID : "+projectIdent+".This project does not exist");
		return project;
	}

	@Override
	public void deletProjectByIdentifier(String projectIdent) {

		Project project = proRep.findByProjectIdentifier(projectIdent.toUpperCase());
		if(project == null)
			throw new ProjectIdException("Can not find project with ID : "+projectIdent+".This project does not exist");
		proRep.delete(project);
		
	}

	@Override
	public Iterable<Project> getAllprojects() {
		return proRep.findAll();
	}

}
