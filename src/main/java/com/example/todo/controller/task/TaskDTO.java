package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import lombok.Value;

import java.text.SimpleDateFormat;

@Value
public class TaskDTO{
    long id;
    String summary;
    String description;
    String status;
    String dayLimit;

    public static TaskDTO toDTO(TaskEntity entity) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return new TaskDTO(
                entity.getId(),
                entity.getSummary(),
                entity.getDescription(),
                entity.getStatus().name(),
                date.format(entity.getDayLimit())
        );
    }
}
