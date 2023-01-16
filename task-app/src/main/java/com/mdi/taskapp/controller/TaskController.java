package com.mdi.taskapp.controller;

import com.mdi.taskapp.entity.Task;
import com.mdi.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/index")
    public String viewIndexPage(Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/createTaskForm")
    public String createTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "new-task";
    }

    @PostMapping(path = "/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/index";
    }

    @GetMapping(path = "/updateTaskForm/{id}")
    public String updateTaskForm(@PathVariable(value = "id") Integer id, Model model)  {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @GetMapping(path = "/deleteTask/{id}")
    public String deleteTask(@PathVariable(value = "id") Integer id) {
        this.taskService.deleteTaskById(id);
        return "redirect:/index";
    }

}
