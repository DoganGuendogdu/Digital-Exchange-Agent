package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.TaskFileUpload;
import com.digital_exchange_agent.backend.repository.TaskFileUploadRepository;
import com.digital_exchange_agent.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskFIleUploadService {
    private final TaskFileUploadRepository taskFileUploadRepository;

    public TaskFIleUploadService(TaskFileUploadRepository taskFileUploadRepository) {
        this.taskFileUploadRepository = taskFileUploadRepository;
    }

    public TaskFileUpload createTaskFileUpload(TaskFileUpload taskFileUpload) {
        return taskFileUploadRepository.save(taskFileUpload);
    }

    public TaskFileUpload getDefaultTaskFileUploadForMVP() {
        final Integer taskFileUploadID = 1;

        return taskFileUploadRepository.findById(taskFileUploadID)
                .orElseThrow(() -> new IllegalArgumentException("Default Task File Upload not found"));
    }
}
