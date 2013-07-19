package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyGrep;
import org.devopspy.repository.DevOpspyGrepRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspygrep")
public class DevOpspyGrepController extends
		RepositoryBasedRestController<DevOpspyGrep, Long, DevOpspyGrepRepository> {

	@Inject
	@Named("devOpspyGrepRepository")
	@Override
	public void setRepository(DevOpspyGrepRepository repository) {
		this.repository = repository;
	}

}
