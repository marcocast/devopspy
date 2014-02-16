package org.devopspy.service;

import static org.grep4j.core.Grep4j.constantExpression;
import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.fluent.Dictionary.on;

import java.util.List;

import javax.inject.Named;

import org.devopspy.converter.DosToGrep4jConverter;
import org.devopspy.converter.Grep4jToDosConverter;
import org.devopspy.model.DosResult;
import org.devopspy.model.DosSearchData;
import org.devopspy.repository.DosResultRepository;
import org.devopspy.repository.DosSearchDataRepository;
import org.grep4j.core.model.Profile;
import org.grep4j.core.result.GrepResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Named("grepService")
public class GrepService {

	@Autowired
	private DosToGrep4jConverter dosToGrep4jConverter;

	@Autowired
	private Grep4jToDosConverter grep4jToDosConverter;

	@Autowired
	private DosSearchDataRepository dosSearchDataRepository;

	@Autowired
	private DosResultRepository dosResultRepository;

	public List<DosResult> runGrep(DosSearchData searchData) {

		List<Profile> profiles = dosToGrep4jConverter.convertToGrep4jProfiles(searchData.getDosProfiles());

		GrepResults results = grep(constantExpression(searchData.getExpression()), on(profiles));

		return dosResultRepository.save(grep4jToDosConverter.convertToDosResults(results));
	}

	public List<DosResult> runGrep(Long grepid) {
		return runGrep(dosSearchDataRepository.findOne(grepid));
	}

}
