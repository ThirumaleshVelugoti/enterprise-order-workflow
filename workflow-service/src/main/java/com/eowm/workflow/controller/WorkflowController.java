package com.eowm.workflow.controller;

import com.eowm.workflow.dto.WorkflowActionRequest;
import com.eowm.workflow.dto.WorkflowResponse;
import com.eowm.workflow.service.WorkflowService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping("/approve")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public WorkflowResponse approve(@Valid @RequestBody WorkflowActionRequest request,
                                    Authentication authentication) {
        return workflowService.approve(request, authentication);
    }

    @PostMapping("/reject")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public WorkflowResponse reject(@Valid @RequestBody WorkflowActionRequest request,
                                   Authentication authentication) {
        return workflowService.reject(request, authentication);
    }

    @GetMapping("/{orderId}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','USER')")
    public List<WorkflowResponse> getWorkflowHistory(@PathVariable Long orderId) {
        return workflowService.getWorkflowHistory(orderId);
    }
}
