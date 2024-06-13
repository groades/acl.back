package com.groades.acl.api.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Integer id) {
        super("Task not found with ID: " + id);
    }
}
