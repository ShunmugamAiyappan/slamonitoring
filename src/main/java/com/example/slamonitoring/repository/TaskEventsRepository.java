package com.example.slamonitoring.repository;

import com.example.slamonitoring.model.TaskEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskEventsRepository extends JpaRepository<TaskEvents, Long> {
}
