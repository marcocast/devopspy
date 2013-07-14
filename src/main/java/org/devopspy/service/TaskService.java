package org.devopspy.service;

import org.devopspy.model.Task;
import org.resthub.common.service.CrudService;

public interface TaskService extends CrudService<Task, Long> {

    Task findByTitle(String title);
    
    Task affectTaskToUser(Long taskId, Long userId);

}