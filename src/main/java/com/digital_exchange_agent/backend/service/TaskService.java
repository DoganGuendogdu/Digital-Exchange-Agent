package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.Task;
import com.digital_exchange_agent.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) throws Exception {
        return taskRepository.save(task);
    }

    public Optional<Task> getDefaultTaskForMVP() {
        final Integer taskID = 1;

        return taskRepository.findById(taskID);
    }
}
