package com.groades.acl.service;

import com.groades.acl.api.exception.TaskNotFoundException;
import com.groades.acl.api.reponse.TaskResponse;
import com.groades.acl.api.request.TaskCreateRequest;
import com.groades.acl.api.request.TaskUpdateRequest;
import com.groades.acl.persistence.entity.TaskEntity;
import com.groades.acl.persistence.repository.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {

    @Mock
    private ITaskRepository repository;

    @InjectMocks
    private TaskService taskService;

    private static final String DESC = "desc";
    private static final String DESCUP = "descUpdated";

    TaskCreateRequest createReq = TaskCreateRequest.builder()
            .description(DESC)
            .build();

    TaskUpdateRequest updateReq = TaskUpdateRequest.builder()
            .id(1)
            .description(DESC)
            .isvalid(true)
            .build();

    TaskEntity task = TaskEntity.builder()
            .id(1)
            .description(DESC)
            .isdeleted(false)
            .isvalid(true)
            .created(LocalDateTime.of(2024,01,01,01,01))
            .build();

    TaskEntity taskUpdated = TaskEntity.builder()
            .id(1)
            .description(DESCUP)
            .isdeleted(false)
            .isvalid(true)
            .created(LocalDateTime.of(2024,01,01,01,01))
            .build();

    TaskResponse taskResponse = TaskResponse.builder()
            .id(1)
            .description(DESC)
            .isdeleted(false)
            .isvalid(true)
            .created(LocalDateTime.of(2024,01,01,01,01))
            .build();


    @Test
    public void createOkTest(){
        when(repository.save(any())).thenReturn(task);
        assertEquals(taskResponse,taskService.create(createReq));
    }
    @Test
    public void updateOkTest(){
        when(repository.findById(any())).thenReturn(Optional.ofNullable(task));
        when(repository.save(any())).thenReturn(taskUpdated);
        taskResponse.setDescription(DESCUP);
        assertEquals(taskResponse,taskService.update(updateReq));
    }
    @Test
    public void updateNonExistingTaskExceptionTest(){
        when(repository.findById(any())).thenReturn(Optional.empty());
        assertThrows(TaskNotFoundException.class,() -> taskService.update(updateReq));
    }

}
