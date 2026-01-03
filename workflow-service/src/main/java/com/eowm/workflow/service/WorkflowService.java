package com.eowm.workflow.service;

import com.eowm.workflow.dto.WorkflowActionRequest;
import com.eowm.workflow.dto.WorkflowResponse;
import com.eowm.workflow.model.WorkflowAction;
import com.eowm.workflow.model.WorkflowActionType;
import com.eowm.workflow.repository.WorkflowRepository;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkflowService {

    private final WorkflowRepository workflowRepository;

    public WorkflowService(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public WorkflowResponse approve(WorkflowActionRequest request, Authentication auth) {
        return saveAction(request, auth, WorkflowActionType.APPROVED);
    }

    public WorkflowResponse reject(WorkflowActionRequest request, Authentication auth) {
        return saveAction(request, auth, WorkflowActionType.REJECTED);
    }

    public List<WorkflowResponse> getWorkflowHistory(Long orderId) {
        return workflowRepository.findByOrderId(orderId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private WorkflowResponse saveAction(WorkflowActionRequest request,
                                        Authentication auth,
                                        WorkflowActionType actionType) {

        WorkflowAction action = WorkflowAction.builder()
                .orderId(request.getOrderId())
                .actionBy(auth.getName())
                .action(actionType)
                .comments(request.getComments())
                .build();

        return mapToResponse(workflowRepository.save(action));
    }

    private WorkflowResponse mapToResponse(WorkflowAction action) {
        return WorkflowResponse.builder()
                .id(action.getId())
                .orderId(action.getOrderId())
                .actionBy(action.getActionBy())
                .action(action.getAction())
                .comments(action.getComments())
                .actionTime(action.getActionTime())
                .build();
    }
}
