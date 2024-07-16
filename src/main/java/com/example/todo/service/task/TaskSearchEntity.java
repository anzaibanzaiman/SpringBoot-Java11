package com.example.todo.service.task;

import lombok.Value;

import java.util.List;

@Value
public class TaskSearchEntity{
    String summary;
    List<TaskStatus> status;
}
