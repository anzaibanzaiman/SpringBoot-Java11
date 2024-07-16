package com.example.todo.controller.task;

import lombok.Value;

import java.util.List;
import java.util.Optional;

@Value
public class TaskSearchDTO {

    String summary;
    List<String> statusList;

    public boolean isChecked(String status) {
        return Optional.ofNullable(statusList)
            .map(l -> l.contains(status))
            .orElse(false);
    }
}
