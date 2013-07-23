package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosGrep;
import org.devopspy.repository.DosGrepRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspygrep")
public class GrepDAOController extends
		RepositoryBasedRestController<DosGrep, Long, DosGrepRepository> {

	@Inject
	@Named("dosGrepRepository")
	@Override
	public void setRepository(DosGrepRepository repository) {
		this.repository = repository;
	}

}
