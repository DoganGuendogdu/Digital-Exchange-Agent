package com.digital_exchange_agent.backend.controller;


import com.digital_exchange_agent.backend.dto.TaskDTO;
import com.digital_exchange_agent.backend.dto.TaskFileUploadDTO;
import com.digital_exchange_agent.backend.entity.Task;
import com.digital_exchange_agent.backend.entity.TaskFileUpload;
import com.digital_exchange_agent.backend.entity.Transactions;
import com.digital_exchange_agent.backend.service.TaskFIleUploadService;
import com.digital_exchange_agent.backend.service.TaskService;
import com.digital_exchange_agent.backend.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TaskController {
    private final TaskService taskService;
    private final TaskFIleUploadService taskFIleUploadService;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TransactionService transactionService;

    public TaskController(
            TaskService taskService,
            TaskFIleUploadService taskFIleUploadService,
            TransactionService transactionService) {
        this.taskService = taskService;
        this.taskFIleUploadService = taskFIleUploadService;
        this.transactionService = transactionService;
    }

    @PostMapping("/task")
    public ResponseEntity<Task> createTask(@RequestBody @Validated TaskDTO taskDTO) {
        var transactionOpt = transactionService.getTransactionById(taskDTO.transactionId());
        logger.debug("Extracting transaction {} as Optional from TaskDTO: {}", transactionOpt, taskDTO.transactionId());

        if (transactionOpt.isEmpty()) {
            logger.error("Transaction not found for TaskDTO: {}", taskDTO);
            return ResponseEntity.badRequest().build();
        }

        var transaction = transactionOpt.get();
        logger.debug("Transaction found: {}", transaction);

        var task = new Task(transaction);
        logger.debug("Creating new Task with Transaction: {}", task);

        try {
            taskService.createTask(task);
            logger.debug("Task created successfully: {}", task);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Failed to create task: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/task_upload")
    public ResponseEntity<TaskFileUpload> createTaskFileUpload(@RequestBody @Validated TaskFileUploadDTO taskFileUploadDTO) {
        logger.debug("Received TaskFileUpload request: {}", taskFileUploadDTO);

        var transactionOpt = transactionService.getTransactionById(taskFileUploadDTO.transactionId());

        if (transactionOpt.isEmpty()) {
            logger.error("Transaction does not exist");
            throw new NullPointerException("Transaction is null");
        }
        logger.debug("Retrieving transaction {}", transactionOpt);

;
        var taskFileUpload = new TaskFileUpload(
                transactionOpt.get(),
                taskFileUploadDTO.file(),
                taskFileUploadDTO.fileType(),
                taskFileUploadDTO.customInfo(),
                taskFileUploadDTO.status(),
                taskFileUploadDTO.stepNumber(),
                taskFileUploadDTO.fileName()
        );

        try {
            TaskFileUpload createdTaskFileUpload = taskFIleUploadService.createTaskFileUpload(taskFileUpload);
            logger.debug("TaskFileUpload created successfully: {}", createdTaskFileUpload);
            return new ResponseEntity<>(createdTaskFileUpload, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Failed to create TaskFileUpload: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
