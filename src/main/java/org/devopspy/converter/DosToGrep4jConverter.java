package org.devopspy.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.devopspy.model.DosProfile;
import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ProfileBuilder;
import org.springframework.stereotype.Component;

@Component
public class DosToGrep4jConverter {

	private static final String LOCALHOST = "localhost";

	public List<Profile> convertToGrep4jProfiles(Collection<DosProfile> devOpspyProfiles) {
		List<Profile> profiles = new ArrayList<Profile>();
		for (DosProfile devOpspyProfile : devOpspyProfiles) {
			profiles.add(convertToGrep4jProfile(devOpspyProfile));
		}
		return profiles;
	}

	public Profile convertToGrep4jProfile(DosProfile devOpspyProfile) {
		Profile profile = null;
		if (devOpspyProfile.getHost().equalsIgnoreCase(LOCALHOST)) {
			profile = ProfileBuilder.newBuilder().name(devOpspyProfile.getName()).filePath(devOpspyProfile.getFilePath()).onLocalhost().build();
		} else {
			profile = ProfileBuilder.newBuilder().name(devOpspyProfile.getName()).filePath(devOpspyProfile.getFilePath())
					.onRemotehost(devOpspyProfile.getHost()).credentials(devOpspyProfile.getUser(), devOpspyProfile.getPassword()).build();
		}
		return profile;
	}
}
