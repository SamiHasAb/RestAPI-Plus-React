package org.study.pma.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull(message = "project name is required")   // need dependency
	@Column(name = "project_name")
	private String projectName;
	
	@NotNull(message = "project identifier is required")
	@Size(min = 4, max = 5 ,message = "please use 4 to 5 characters")
	@Column (name = "project_identifier" , unique = true , updatable = false )
	private String projectIdentifier;
	
	@NotNull(message = "project description is required")
	@Column(name = "project_description")
	private String projectDescription;
	
	@JsonFormat(pattern = "yyyy-mm-dd hh:mm")
	@Column(name = "start_date")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-mm-dd hh:mm")
	@Column(name = "end_date")
	private Date endDate;
	
	@JsonFormat(pattern = "yyyy-mm-dd hh:mm")
	@Column(name = "created_at")
	private Date createdAt;
	
	@JsonFormat(pattern = "yyyy-mm-dd hh:mm")
	@Column(name = "updated_at")
	private Date updatedAt;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	

}