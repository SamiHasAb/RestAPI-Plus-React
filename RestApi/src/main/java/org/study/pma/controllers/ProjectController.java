package org.study.pma.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.pma.models.Project;
import org.study.pma.services.MapValidationErrorService;
import org.study.pma.services.ProjectService;


@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projSer;
	
	@Autowired
	private MapValidationErrorService mapValErrorSer;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, BindingResult result ){
		
		ResponseEntity<?> errorMap = mapValErrorSer.mapValidationService(result);
		
        if(errorMap!=null) return errorMap;
        
		Project project1 = projSer.saveOrUpdate(project);

		return new ResponseEntity<Project>(project1 , HttpStatus.OK);
	}
	
	
	@GetMapping("/{projectIdent}")
	public ResponseEntity<?>  getProjectById(@PathVariable String projectIdent){
		
		Project project = projSer.findProjectByIdentifier(projectIdent);
		
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	 @GetMapping("/all")
	    public Iterable<Project> getAllProjects(){
		 return projSer.getAllprojects();
		 }
	 
	 @DeleteMapping("/{projectIdent}")
	 public ResponseEntity<?>  deletePrject(@PathVariable String projectIdent){
		
		 projSer.deletProjectByIdentifier(projectIdent);
		 
		 return new ResponseEntity<String>("project with ID:"+projectIdent+" was deleted",HttpStatus.OK);
		 
	 }
	
	
}
