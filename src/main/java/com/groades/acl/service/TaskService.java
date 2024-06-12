package com.groades.acl.service;

import com.groades.acl.entity.TaskEntity;
import com.groades.acl.reponse.TaskResponse;
import com.groades.acl.repository.ITaskRepository;
import com.groades.acl.request.TaskCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ITaskRepository taskRepository;

    public TaskResponse create(TaskCreationRequest request){
        var task = TaskEntity.builder()
                .description(request.getDescription())
                .isvalid(true)
                .build();
        var savedTask = taskRepository.save(task);
        return TaskResponse
                .builder()
                .id(savedTask.getId())
                .description(savedTask.getDescription())
                .isvalid(savedTask.getIsvalid())
                .created(savedTask.getCreated())
                .build();
    }

    public List<TaskEntity> getAll() {
        List<TaskEntity> taskList = new ArrayList<>();
        taskRepository.findAll().forEach(taskList::add);
        return taskList;

    }
}
