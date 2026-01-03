package com.eowm.workflow.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkflowActionRequest {

    @NotNull
    private Long orderId;

    private String comments;
}
