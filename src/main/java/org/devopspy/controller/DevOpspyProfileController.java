package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyProfile;
import org.devopspy.repository.DevOpspyProfileRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspyprofile")
public class DevOpspyProfileController extends
		RepositoryBasedRestController<DevOpspyProfile, Long, DevOpspyProfileRepository> {

	@Inject
	@Named("devOpspyProfileRepository")
	@Override
	public void setRepository(DevOpspyProfileRepository repository) {
		this.repository = repository;
	}

}
