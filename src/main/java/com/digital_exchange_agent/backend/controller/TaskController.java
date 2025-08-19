package com.digital_exchange_agent.backend.controller;


import com.digital_exchange_agent.backend.dto.TaskDTO;
import com.digital_exchange_agent.backend.entity.Task;
import com.digital_exchange_agent.backend.entity.Transactions;
import com.digital_exchange_agent.backend.service.TaskService;
import com.digital_exchange_agent.backend.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TaskController {
    private final TaskService taskService;
    private final TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(
            TaskService taskService,
            TransactionService transactionService) {
        this.taskService = taskService;
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
}
