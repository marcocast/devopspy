package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyResult;
import org.devopspy.repository.DevOpspyResultRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspyresult")
public class DevOpspyResultController extends
		RepositoryBasedRestController<DevOpspyResult, Long, DevOpspyResultRepository> {

	@Inject
	@Named("devOpspyResultRepository")
	@Override
	public void setRepository(DevOpspyResultRepository repository) {
		this.repository = repository;
	}

}
