package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosGrep;
import org.devopspy.model.DosResult;
import org.devopspy.service.GrepService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class GrepServiceController {

	@Inject
	@Named("grepService")
	private GrepService grepService;

	@RequestMapping(value = "grep", method = RequestMethod.POST)
	@ResponseBody
	public DosResult executeGrepSearch(@RequestBody DosGrep devOpspyGrep) {
		return grepService.runGrep(devOpspyGrep);
	}

	@RequestMapping(value = "grep/{grepid}", method = RequestMethod.GET)
	@ResponseBody
	public DosResult executeGrepSearch(@PathVariable Long grepid) {
		return grepService.runGrep(grepid);
	}

}
