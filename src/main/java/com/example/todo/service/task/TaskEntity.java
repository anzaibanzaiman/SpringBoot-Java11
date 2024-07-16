package com.example.todo.service.task;

import lombok.Value;

import java.util.Date;

@Value
public class TaskEntity{

    Long id;
    String summary;
    String description;
    TaskStatus status;
    Date dayLimit;

}
