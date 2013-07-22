package org.devopspy;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyGrep;
import org.devopspy.model.DevOpspyProfile;
import org.devopspy.model.DevOpspyProfileGroup;
import org.devopspy.repository.DevOpspyGrepRepository;
import org.devopspy.repository.DevOpspyProfileGroupRepository;
import org.devopspy.repository.DevOpspyProfileRepository;
import org.resthub.common.util.PostInitialize;
import org.springframework.transaction.annotation.Transactional;

@Named("devOpspyProfileInitializer")
public class DevOpspyProfileInitializer {

	@Inject
	@Named("devOpspyProfileRepository")
	private DevOpspyProfileRepository devOpspyProfileRepository;
	
	@Inject
	@Named("devOpspyGrepRepository")
	private DevOpspyGrepRepository devOpspyGrepRepository;

	@Inject
	@Named("devOpspyProfileGroupRepository")
	private DevOpspyProfileGroupRepository devOpspyProfileGroupRepository;

	@PostInitialize
	@Transactional(readOnly = false)
	public void init() {

		DevOpspyProfileGroup firstGroup = new DevOpspyProfileGroup("first group");
		devOpspyProfileGroupRepository.save(firstGroup);

		DevOpspyProfile devOpspyProfile1 = createProfile("profile 1", "/opt/somewhere", "host1", "user", "password");
		devOpspyProfile1.addDevOpspyProfileGroup(firstGroup);
		devOpspyProfileRepository.save(devOpspyProfile1);

		DevOpspyProfile devOpspyProfile2 = createProfile("profile 2", "/opt/ops/logs/jboss/ramp-all/server.log", "localhost", "", "");
		devOpspyProfileRepository.save(devOpspyProfile2);

		DevOpspyProfile devOpspyProfile3 = createProfile("profile 3", "/opt/ops/logs/jboss/serv", "host3", "user", null, "/home/user/.ssh/id_dsa");
		devOpspyProfileRepository.save(devOpspyProfile3);
		
		
		DevOpspyGrep devOpspyGrep = new DevOpspyGrep();
		devOpspyGrep.addDevOpspyProfile(devOpspyProfile2);
		devOpspyGrep.setExpression("ERROR");
		devOpspyGrep.setRegex(false);
		devOpspyGrepRepository.save(devOpspyGrep);
	}

	private DevOpspyProfile createProfile(String name, String filePath, String url, String passsword, String user) {
		return createProfile(name, filePath, url, passsword, user, null);
	}

	private DevOpspyProfile createProfile(String name, String filePath, String url, String passsword, String user, String userAuthPrivateKeyLocation) {
		DevOpspyProfile devOpspyProfile2 = new DevOpspyProfile(name);
		devOpspyProfile2.setFilePath(filePath);
		devOpspyProfile2.setHost(url);
		devOpspyProfile2.setPassword(passsword);
		devOpspyProfile2.setUser(user);
		devOpspyProfile2.setUserAuthPrivateKeyLocation(userAuthPrivateKeyLocation);
		return devOpspyProfile2;
	}
}
