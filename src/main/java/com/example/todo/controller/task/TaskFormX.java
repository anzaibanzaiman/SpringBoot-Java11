package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import lombok.SneakyThrows;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Value
public class TaskFormX {

    @NotEmpty
    List<String> summary;
    List<String> description;
    @NotEmpty
    List<String> status;
    @NotEmpty
    List<String> dayLimit;

    public List<TaskForm> toTaskFormList(){

        List<TaskForm> toTaskFormList = new ArrayList<>();

        for (int i=0; i < getSummary().size(); i++){
            if (!(getSummary().get(i).isEmpty() || !(getStatus().get(i).equals("TODO") || getStatus().get(i).equals("DOING") || getStatus().get(i).equals("DONE")) || getDayLimit().get(i).isEmpty())) {
                String newDescription = getDescription().isEmpty() ? "" : getDescription().get(i);
                TaskForm taskForm = new TaskForm(getSummary().get(i), newDescription, getStatus().get(i), getDayLimit().get(i));
                toTaskFormList.add(taskForm);
            }
        }
        return toTaskFormList;
    }
}
