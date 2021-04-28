package org.study.pma.services;


import org.study.pma.models.Project;

public interface ProjectService {
	
	public Project saveOrUpdate(Project project);
	
	public Project findProjectByIdentifier(String projectIdent);
	
	public void deletProjectByIdentifier(String projectIdent);
	
	Iterable<Project> getAllprojects();


}
