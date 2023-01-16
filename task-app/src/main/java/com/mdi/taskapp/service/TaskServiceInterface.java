package com.mdi.taskapp.service;

import com.mdi.taskapp.entity.Task;

import java.util.List;

public interface TaskServiceInterface {
    List<Task> getAllTasks();
    void saveTask(Task taskEntity);
    Task getTaskById(Integer id);
    void deleteTaskById(Integer id);

}
