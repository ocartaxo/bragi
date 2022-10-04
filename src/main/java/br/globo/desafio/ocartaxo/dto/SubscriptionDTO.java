package br.globo.desafio.ocartaxo.dto;

import br.globo.desafio.ocartaxo.model.Status;

import java.time.LocalDateTime;

public class SubscriptionDTO {

    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime uploadAt;

    public SubscriptionDTO(Status status, LocalDateTime createdAt, LocalDateTime uploadAt) {
        this.status = status;
        this.createdAt = createdAt;
        this.uploadAt = uploadAt;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUploadAt() {
        return uploadAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
