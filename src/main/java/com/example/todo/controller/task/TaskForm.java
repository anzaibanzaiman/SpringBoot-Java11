package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import lombok.SneakyThrows;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Value
public class TaskForm {

    @NotBlank
    @Size(max = 256, message = "256文字以内で入力してください")
    String summary;
    String description;
    @NotBlank
    @Pattern(regexp = "TODO|DOING|DONE", message = "Todo, Doing, Done のいずれかを選択してください")
    String status;
    @Pattern(regexp="\\d{4}/\\d{2}/\\d{2}", message = "yyyy/MM/ddの形式で入力してください")
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
