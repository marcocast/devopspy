package org.devopspy.controller;

import org.devopspy.model.Task;
import org.devopspy.model.User;
import org.fest.assertions.api.Assertions;
import org.resthub.test.AbstractWebTest;
import org.testng.annotations.Test;

public class TaskControllerTest extends AbstractWebTest {
	public TaskControllerTest() {
		// Activate resthub-web-server and resthub-jpa Spring profiles
		super("resthub-web-server,resthub-jpa");
	}



	@Test
	public void testCreateResource() {
		this.request("api/task").xmlPost(new Task("task1"));
		this.request("api/task").xmlPost(new Task("task2"));
		String responseBody = this.request("api/task")
				.setQueryParameter("page", "no").jsonGet().getBody();
		Assertions.assertThat(responseBody).isNotEmpty();
		Assertions.assertThat(responseBody).doesNotContain("\"content\":2");
		Assertions.assertThat(responseBody).contains("task1");
		Assertions.assertThat(responseBody).contains("task2");
	}

	@Test
	public void testAffectTaskToUser() {
		Task task = this.request("api/task").xmlPost(new Task("task1"))
				.resource(Task.class);
		User user = this.request("api/user")
				.xmlPost(new User("user1", "user1@test.org"))
				.resource(User.class);
		String responseBody = this
				.request("api/task/" + task.getId() + "/user/" + user.getId())
				.put("").getBody();
		Assertions.assertThat(responseBody).isNotEmpty();
		Assertions.assertThat(responseBody).contains("task1");
		Assertions.assertThat(responseBody).contains("user1");
	}
}
