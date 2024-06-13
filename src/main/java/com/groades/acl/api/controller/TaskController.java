package com.groades.acl.api.controller;


import com.groades.acl.api.request.TaskUpdateRequest;
import com.groades.acl.persistence.entity.TaskEntity;
import com.groades.acl.api.reponse.TaskResponse;
import com.groades.acl.api.request.TaskCreateRequest;
import com.groades.acl.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    @Operation(summary = "Create a task")
    public ResponseEntity<TaskResponse> create(
            @Validated @RequestBody TaskCreateRequest request
    ){
        return ResponseEntity.ok(taskService.create(request));
    }
    @GetMapping
    @Operation(summary = "Get undeleted tasks")
    public ResponseEntity<List<TaskEntity>> getAllTasks(){

        return ResponseEntity.ok(taskService.getAll());
    }
    @PutMapping("/delete/{id}")
    @Operation(summary = "Delete a task")
    public ResponseEntity<TaskResponse> delete(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.delete(id));
    }
    @PutMapping
    @Operation(summary = "Update a task")
    public ResponseEntity<TaskResponse> update(
            @Validated @RequestBody TaskUpdateRequest request){
        return ResponseEntity.ok(taskService.update(request));
    }


}
