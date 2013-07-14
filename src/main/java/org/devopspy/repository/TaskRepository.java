package org.devopspy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.devopspy.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Task findByTitle(String title); 

}
