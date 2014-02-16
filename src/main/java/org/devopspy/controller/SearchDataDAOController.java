package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosSearchData;
import org.devopspy.repository.DosSearchDataRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/searchdata")
public class SearchDataDAOController extends
		RepositoryBasedRestController<DosSearchData, Long, DosSearchDataRepository> {

	@Inject
	@Named("dosSearchDataRepository")
	@Override
	public void setRepository(DosSearchDataRepository repository) {
		this.repository = repository;
	}

}
