package com.learnspringboot.ppmtool.services;

import com.learnspringboot.ppmtool.domain.Project;
import com.learnspringboot.ppmtool.exceptions.ProjectIdExcepionResponse;
import com.learnspringboot.ppmtool.exceptions.ProjectIdException;
import com.learnspringboot.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase() );
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "'already exist");
        }
    }

    public Project findProjectById(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project ID: '"+projectId+"' does not exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProject(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if (project == null){
            throw new ProjectIdException("Can not delete project with ID : '"+projectId+"'. This project does not exists");
        }

        projectRepository.delete(project);
    }
}
