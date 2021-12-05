package com.example.db_project.assignments;

import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository
    extends CrudRepository<Assignment, Integer> {
}
