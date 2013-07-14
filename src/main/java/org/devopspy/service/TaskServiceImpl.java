package org.devopspy.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.Task;
import org.devopspy.model.User;
import org.devopspy.notificators.NotificationService;
import org.devopspy.repository.TaskRepository;
import org.devopspy.repository.UserRepository;
import org.modelmapper.internal.util.Assert;
import org.resthub.common.service.CrudServiceImpl;
import org.springframework.transaction.annotation.Transactional;

//TaskServiceImpl
@Transactional
@Named("taskService")
public class TaskServiceImpl extends
		CrudServiceImpl<Task, Long, TaskRepository> implements TaskService {

	private UserRepository userRepository;
	private NotificationService notificationService;

	@Override
	@Inject
	public void setRepository(TaskRepository taskRepository) {
		super.setRepository(taskRepository);
	}

	@Inject
	@Named("userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Inject
	@Named("notificationService")
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	public Task findByTitle(String title) {
        return this.repository.findByTitle(title);
    }

	@Transactional(readOnly = false)
	@Override
	public Task affectTaskToUser(Long taskId, Long userId) {

		Assert.notNull(userId, "userId should not be null");
		Assert.notNull(taskId, "taskId should not be null");

		User user = this.userRepository.findOne(userId);
		Assert.notNull(user, "userId should correspond to a valid user");

		Task task = this.repository.findOne(taskId);
		Assert.notNull(task, "taskId should correspond to a valid task");

		if (task.getUser() != null && task.getUser() != user) {
			if (task.getUser().getEmail() != null) {
				this.notificationService.send(task.getUser().getEmail(),
						"The task " + task.getTitle() + " has been reaffected");
			}
		}

		if (user.getEmail() != null) {
			this.notificationService
					.send(user.getEmail(), "The task " + task.getTitle()
							+ " has been affected to you");
		}

		task.setUser(user);

		return task;
	}
}