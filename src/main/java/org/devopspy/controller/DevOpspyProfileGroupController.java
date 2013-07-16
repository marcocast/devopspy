package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyProfileGroup;
import org.devopspy.repository.DevOpspyProfileGroupRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspyprofilegroup")
public class DevOpspyProfileGroupController extends
		RepositoryBasedRestController<DevOpspyProfileGroup, Long, DevOpspyProfileGroupRepository> {

	@Inject
	@Named("devOpspyProfileGroupRepository")
	@Override
	public void setRepository(DevOpspyProfileGroupRepository repository) {
		this.repository = repository;
	}

}
