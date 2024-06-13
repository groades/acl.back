package com.groades.acl.api.controller;


import com.groades.acl.persistence.entity.TaskEntity;
import com.groades.acl.api.reponse.TaskResponse;
import com.groades.acl.api.request.TaskCreationRequest;
import com.groades.acl.service.TaskService;
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
    public ResponseEntity<TaskResponse> create(
            @Validated @RequestBody TaskCreationRequest request
    ){
        return ResponseEntity.ok(taskService.create(request));
    }
    @GetMapping
    public ResponseEntity<List<TaskEntity>> getAllTasks(){

        return ResponseEntity.ok(taskService.getAll());
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<TaskResponse> delete(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.delete(id));
    }


}
