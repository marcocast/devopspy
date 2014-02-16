package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosResult;
import org.devopspy.repository.DosResultRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/result")
public class ResultDAOController extends RepositoryBasedRestController<DosResult, Long, DosResultRepository> {

	@Inject
	@Named("dosResultRepository")
	@Override
	public void setRepository(DosResultRepository repository) {
		this.repository = repository;
	}

}
