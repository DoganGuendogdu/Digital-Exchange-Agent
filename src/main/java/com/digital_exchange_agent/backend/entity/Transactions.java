package com.digital_exchange_agent.backend.entity;

import com.digital_exchange_agent.backend.entity.common.enums.PriorityLevel;
import com.digital_exchange_agent.backend.entity.common.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<Task> task;

    @JoinColumn(name = "RECIPIENT_ID", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Recipient recipient;

    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Account account;

    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @Column(name = "RESPONSE")
    private String response;

    @Column(name = "CUSTOM_INFO")
    private String custom_info;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "PRIORITY_LEVEL", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityLevel priorityLevel;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

        /*
        TODO: Add time fields:
        - EXPIRED_AT,
        - RESPONDED_AT,
        - CREATED_AT,
     */

    public Transactions(
            Recipient recipient,
            Account account,
            String topic,
            String response,
            String custom_info,
            String tags,
            PriorityLevel priorityLevel,
            Status status,
            LocalDateTime createdAt) {
        this.recipient = recipient;
        this.account = account;
        this.topic = topic;
        this.response = response;
        this.custom_info = custom_info;
        this.tags = tags;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCustomInfo() {
        return custom_info;
    }

    public void setCustomInfo(String custom_info) {
        this.custom_info = custom_info;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
