package com.groades.acl.service;

import com.groades.acl.api.request.TaskUpdateRequest;
import com.groades.acl.persistence.entity.TaskEntity;
import com.groades.acl.api.reponse.TaskResponse;
import com.groades.acl.persistence.repository.ITaskRepository;
import com.groades.acl.api.request.TaskCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ITaskRepository taskRepository;

    public TaskResponse create(TaskCreateRequest request){
        var task = TaskEntity.builder()
                .description(request.getDescription())
                .isvalid(true)
                .isdeleted(false)
                .build();
        var savedTask = taskRepository.save(task);
        return TaskResponse
                .builder()
                .id(savedTask.getId())
                .description(savedTask.getDescription())
                .isvalid(savedTask.getIsvalid())
                .isdeleted(savedTask.getIsdeleted())
                .created(savedTask.getCreated())
                .build();
    }

    public List<TaskEntity> getAll() {
        List<TaskEntity> taskList = new ArrayList<>();
        taskRepository.findAll().forEach(taskList::add);
        return taskList;

    }

    public TaskResponse delete(Integer id) {
        Optional<TaskEntity> optTask = taskRepository.findById(id);
        //if(!optTask.isPresent()){
            //System.out.println("The task does not exist");
        //}
        TaskEntity task = optTask.get();
        task.setIsdeleted(true);
        var savedTask = taskRepository.save(task);
        return TaskResponse
                .builder()
                .id(savedTask.getId())
                .description(savedTask.getDescription())
                .isvalid(savedTask.getIsvalid())
                .isdeleted(savedTask.getIsdeleted())
                .created(savedTask.getCreated())
                .build();
    }

    public TaskResponse update(TaskUpdateRequest request) {
        Optional<TaskEntity> optTask = taskRepository.findById(request.getId());
        //if(!optTask.isPresent()){
        //System.out.println("The task does not exist");
        //}
        TaskEntity task = optTask.get();

        task.setDescription(request.getDescription());
        task.setIsvalid(request.getIsvalid());
        var savedTask = taskRepository.save(task);
        return TaskResponse
                .builder()
                .id(savedTask.getId())
                .description(savedTask.getDescription())
                .isvalid(savedTask.getIsvalid())
                .isdeleted(savedTask.getIsdeleted())
                .created(savedTask.getCreated())
                .build();

    }
}
