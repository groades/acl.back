package com.groades.acl.api.controller;

import com.groades.acl.api.reponse.TaskResponse;
import com.groades.acl.service.TaskService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskService taskService;

    @BeforeEach
    public void init(){
        when(taskService.create(any())).thenReturn(
                TaskResponse.builder()
                        .id(1)
                        .isdeleted(false)
                        .created(LocalDateTime.now())
                        .description("Desc")
                        .isvalid(true)
                        .build()
        );
    }

    @Test
    public void createTest() throws Exception {

        String requestBody = "{\"description\": \"My description\"}";

        mockMvc.perform(post("/api/v1/task/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void emptyDescriptionExceptionTest() throws Exception {
        String requestBody = "{\"description\": \"\"}";

        mockMvc.perform(post("/api/v1/task/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof MethodArgumentNotValidException));;
    }
}
