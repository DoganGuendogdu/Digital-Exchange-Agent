package com.digital_exchange_agent.backend.entity;

import com.digital_exchange_agent.backend.entity.common.enums.FileType;
import com.digital_exchange_agent.backend.entity.common.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
public class TaskFileUpload extends Task {
    @Column(name = "FILE", nullable = false)
    @Lob
    private byte[] file;

    @Column(name = "FILE_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Column(name = "CUSTOM_INFO")
    private String customInfo;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "STEP_NUMBER", nullable = false)
    private int stepNumber;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "UPLOADED_AT")
    private LocalDateTime uploadedAt;

    public TaskFileUpload() {
        super();
    }

    public TaskFileUpload(
            byte[] file,
            FileType fileType,
            String customInfo,
            Status status,
            int stepNumber,
            String fileName) {
        super();
        this.file = file;
        this.fileType = fileType;
        this.customInfo = customInfo;
        this.status = status;
        this.stepNumber = stepNumber;
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getCustomInfo() {
        return customInfo;
    }

    public void setCustomInfo(String customInfo) {
        this.customInfo = customInfo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
