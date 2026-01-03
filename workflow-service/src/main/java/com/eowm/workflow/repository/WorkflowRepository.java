package com.eowm.workflow.repository;

import com.eowm.workflow.model.WorkflowAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkflowRepository extends JpaRepository<WorkflowAction, Long> {

    List<WorkflowAction> findByOrderId(Long orderId);
}
