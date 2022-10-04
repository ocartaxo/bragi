package br.globo.desafio.ocartaxo.model;


import br.globo.desafio.ocartaxo.dto.NotificationType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class EventHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private NotificationType type;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_id",nullable = false)
    private Subscription subscription;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Deprecated
    public EventHistory(){
    }


    public EventHistory(@NotNull NotificationType type, @NotNull @NotBlank Subscription subscription) {
        this.type = type;
        this.subscription = subscription;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
