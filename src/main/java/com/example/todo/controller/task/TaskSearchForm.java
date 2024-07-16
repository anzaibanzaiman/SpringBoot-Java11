package com.example.todo.controller.task;

import com.example.todo.service.task.TaskSearchEntity;
import com.example.todo.service.task.TaskStatus;
import lombok.Value;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Value
public class TaskSearchForm{

    String summary;
    List<String> status;

    public TaskSearchEntity toEntity() {
        var statusEntityList = Optional.ofNullable(status)
            .map(statusList -> statusList.stream().map(TaskStatus::valueOf).collect(Collectors.toList()))
            .orElse(List.of());

        return new TaskSearchEntity(summary, statusEntityList);
    }

    public TaskSearchDTO toDTO() {
        return new TaskSearchDTO(summary, status);
    }
}
