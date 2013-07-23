package org.devopspy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Produces(MediaType.TEXT_PLAIN)
	public List<DosResult> executeGrepSearch(@RequestBody DosGrep devOpspyGrep) {
		return grepService.runGrep(devOpspyGrep);
	}

	@RequestMapping(value = "grep/{grepid}", method = RequestMethod.GET)
	@ResponseBody
	@Produces(MediaType.TEXT_PLAIN)
	public List<DosResult> executeGrepSearch(@PathVariable Long grepid) {
		return grepService.runGrep(grepid);
	}

}
