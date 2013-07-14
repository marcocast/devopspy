package org.devopspy;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyProfile;
import org.devopspy.repository.DevOpspyProfileRepository;
import org.resthub.common.util.PostInitialize;
import org.springframework.transaction.annotation.Transactional;

@Named("devOpspyProfileInitializer")
public class DevOpspyProfileInitializer {

	@Inject
	@Named("devOpspyProfileRepository")
	private DevOpspyProfileRepository devOpspyProfileRepository;

	@PostInitialize
	@Transactional(readOnly = false)
	public void init() {
		DevOpspyProfile devOpspyProfile1 = new DevOpspyProfile("a profile");
		devOpspyProfile1.setFilePath("/opt/somewhere");
		devOpspyProfile1.setHost("/opt/somewhere");
		devOpspyProfile1.setPassword("password");
		devOpspyProfile1.setUser("user");

		devOpspyProfile1 = devOpspyProfileRepository.save(devOpspyProfile1);

	}
}
