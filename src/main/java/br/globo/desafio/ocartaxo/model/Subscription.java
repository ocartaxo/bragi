package br.globo.desafio.ocartaxo.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuiid", strategy = "uuid2")
    private String id;


    @Enumerated(EnumType.STRING)
    private Status status;


    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "upload_at")
    private LocalDateTime uploadAt;

    @Deprecated
    public Subscription() {
    }

    public Subscription(Status status) {
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.uploadAt = LocalDateTime.from(this.createdAt);
    }


    public void updateStatus(Status status) {
        this.status = status;
        this.uploadAt = LocalDateTime.now();
    }

    public Status getStatus() {
        return status;
    }

    public String getId() {
        return this.id;
    }

    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }
}
