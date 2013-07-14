package org.devopspy;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.Task;
import org.devopspy.model.User;
import org.devopspy.repository.TaskRepository;
import org.devopspy.repository.UserRepository;
import org.resthub.common.util.PostInitialize;
import org.springframework.transaction.annotation.Transactional;

@Named("taskInitializer")
public class TaskInitializer {

	@Inject
    @Named("taskRepository")
    private TaskRepository taskRepository;

    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    @PostInitialize
    @Transactional(readOnly = false)
    public void init() {
        User user1 = new User("testUser1", "user1@test.org");
        user1 = userRepository.save(user1);
        User user2 = userRepository.save(new User("testUser2", "user2@test.org"));
        taskRepository.save(new Task("testTask1", user1));
        taskRepository.save(new Task("testTask2", user1));
        taskRepository.save(new Task("testTask3", user2));
        taskRepository.save(new Task("testTask4"));
    }
}
