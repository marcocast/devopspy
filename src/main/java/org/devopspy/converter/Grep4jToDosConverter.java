package org.devopspy.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.devopspy.model.DosResult;
import org.grep4j.core.result.GrepResult;
import org.springframework.stereotype.Component;

@Component
public class Grep4jToDosConverter {

	public List<DosResult> convertToDosResults(Collection<GrepResult> grep4jResults) {
		List<DosResult> dosResults = new ArrayList<DosResult>();
		for (GrepResult grepResult : grep4jResults) {
			DosResult dosResult = new DosResult();
			dosResult.setResult(grepResult.toString());
			dosResult.setProfileName(grepResult.getProfileName());
			dosResult.setExecutionDate(new Date());
			dosResult.setTotOccourences(grepResult.totalLines());
			dosResults.add(dosResult);
		}
		return dosResults;
	}
}
