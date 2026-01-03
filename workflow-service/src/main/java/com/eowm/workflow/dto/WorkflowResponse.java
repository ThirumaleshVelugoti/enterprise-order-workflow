package com.eowm.workflow.dto;

import com.eowm.workflow.model.WorkflowActionType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class WorkflowResponse {

    private Long id;
    private Long orderId;
    private String actionBy;
    private WorkflowActionType action;
    private String comments;
    private LocalDateTime actionTime;
}
