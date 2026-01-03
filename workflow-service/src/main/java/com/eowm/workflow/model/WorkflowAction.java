package com.eowm.workflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_actions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderId;   // reference to Order Service (no FK)

    @Column(nullable = false)
    private String actionBy; // username from JWT

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkflowActionType action;

    @Column(length = 500)
    private String comments;

    @Column(name = "action_time", updatable = false)
    private LocalDateTime actionTime;

    @PrePersist
    protected void onCreate() {
        this.actionTime = LocalDateTime.now();
    }
}
