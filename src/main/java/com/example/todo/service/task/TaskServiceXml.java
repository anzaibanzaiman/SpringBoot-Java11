package com.example.todo.service.task;

import com.example.todo.repository.task.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceXml {

    private final TaskMapper taskMapper;

    public List<TaskEntity> find(TaskSearchEntity searchEntity){
        return taskMapper.select(searchEntity);
    }

    public Optional<TaskEntity> findById(long taskId) {
        return taskMapper.selectById(taskId);
    }

    @Transactional
    public void create(TaskEntity newEntity) {
    	taskMapper.insert(newEntity);
    }

    @Transactional
    public void update(TaskEntity entity) {
    	taskMapper.update(entity);
    }

    @Transactional
    public void delete(long id) {
        taskMapper.delete(id);
    }

}
