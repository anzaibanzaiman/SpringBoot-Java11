package com.example.todo.repository.task;

import java.util.List;
import java.util.Optional;
import com.example.todo.service.task.TaskSearchEntity;
import com.example.todo.service.task.TaskEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
	
	List<TaskEntity> select(TaskSearchEntity searchEntity);
	Optional<TaskEntity> selectById(long taskId);
	void insert(TaskEntity newEntity);
	void update(TaskEntity entity);
	void delete(long id);

}
