package com.groades.acl.controller;


import com.groades.acl.entity.TaskEntity;
import com.groades.acl.reponse.TaskResponse;
import com.groades.acl.request.TaskCreationRequest;
import com.groades.acl.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

}
