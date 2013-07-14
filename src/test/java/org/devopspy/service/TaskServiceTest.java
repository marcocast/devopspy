package org.devopspy.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.Task;
import org.devopspy.model.User;
import org.devopspy.notificators.NotificationService;
import org.devopspy.repository.TaskRepository;
import org.devopspy.repository.UserRepository;
import org.fest.assertions.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaskServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private TaskRepository taskRepository = mock(TaskRepository.class);
    private NotificationService notificationService = mock(NotificationService.class);

    private TaskServiceImpl taskService;

    private User user;
    private Task task;

    @BeforeClass
    public void setup() {
        this.task = new Task("task1");
        this.task.setId(1L);
        this.user = new User("user1");
        this.user.setId(1L);

        when(this.userRepository.findOne(1L)).thenReturn(user);
        when(this.taskRepository.findOne(1L)).thenReturn(task);

        this.taskService = new TaskServiceImpl();
        this.taskService.setRepository(this.taskRepository);
        this.taskService.setUserRepository(this.userRepository);
        this.taskService.setNotificationService(this.notificationService);
    }

    @Inject
    @Named("notificationService")
    private NotificationService mockedNotificationService;

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testAffectTaskNullTaskId() {
        this.taskService.affectTaskToUser(null, this.user.getId());
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testAffectTaskNullUserId() {
        this.taskService.affectTaskToUser(this.task.getId(), null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testAffectUserInvalidTaskId() {
        this.taskService.affectTaskToUser(2L, this.user.getId());
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testAffectTaskInvalidUserId() {
        this.taskService.affectTaskToUser(this.task.getId(), 2L);
    }

    @Test
    public void testAffectTask() {
        Task returnedTask = this.taskService.affectTaskToUser(this.task.getId(), this.user.getId());

        Assertions.assertThat(returnedTask).isNotNull();
        Assertions.assertThat(returnedTask).isEqualTo(this.task);
        Assertions.assertThat(returnedTask.getUser()).isNotNull();
        Assertions.assertThat(returnedTask.getUser()).isEqualTo(this.user);
    }
}

