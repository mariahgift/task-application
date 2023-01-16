package com.mdi.taskapp.service;

import com.mdi.taskapp.entity.Task;
import com.mdi.taskapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = null;

        if (optionalTask.isPresent()) {
            task = optionalTask.get();
        } else {
            throw new RuntimeException(" Task not found, id ::" + id);
        }
        return task;
    }

    @Override
    public void deleteTaskById(Integer id) {
        this.taskRepository.deleteById(id);
    }
}
