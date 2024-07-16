package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import lombok.SneakyThrows;
import lombok.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Value
public class TaskForm {

    String summary;
    String description;
    String status;
    String dayLimit;

    public static TaskForm formEntity(TaskEntity taskEntity) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return new TaskForm(
            taskEntity.getSummary(),
            taskEntity.getDescription(),
            taskEntity.getStatus().name(),
            date.format(taskEntity.getDayLimit())
        );
    }

    @SneakyThrows
    public TaskEntity toEntity() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(getDayLimit());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new TaskEntity(null, getSummary(), getDescription(), TaskStatus.valueOf(getStatus()), date);
    }

    @SneakyThrows
    public TaskEntity toEntity(long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(getDayLimit());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new TaskEntity(id, getSummary(), getDescription(), TaskStatus.valueOf(getStatus()), date);
    }
}
