package com.example.searchrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.searchrest.domains.Task;
import com.example.searchrest.mappers.TaskMapper;

@RestController
public class TaskController {

	private final TaskMapper taskMapper;

	@Autowired
	public TaskController(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}

	@GetMapping("/")
	public List<Task> index(Model model) {
		List<Task> tasks = taskMapper.all();
		model.addAttribute("tasks", tasks);
		return tasks;
	}

	@PostMapping("/add")
	public void create(@RequestBody Task task) {
		taskMapper.add(task);
	}

	@PutMapping("/complete")
	public void put(@RequestBody Task task) {

		Task t = new Task(task.getId());

		taskMapper.complete(t);
	}

}
