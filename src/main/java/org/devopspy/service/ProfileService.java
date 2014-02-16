package org.devopspy.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.devopspy.model.DosSearchData;
import org.devopspy.model.DosProfile;
import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ProfileBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Named("profileService")
public class ProfileService {

	public List<Profile> generateProfiles(DosSearchData devOpspyGrep) {
		List<Profile> profiles = new ArrayList<Profile>();

		for (DosProfile devOpspyProfile : devOpspyGrep.getDosProfiles()) {
			profiles.add(createProfile(devOpspyProfile));
		}
		return profiles;
	}

	private Profile createProfile(DosProfile devOpspyProfile) {
		Profile profile = null;
		if (devOpspyProfile.getHost().equalsIgnoreCase("localhost")) {
			profile = ProfileBuilder.newBuilder().name(devOpspyProfile.getName()).filePath(devOpspyProfile.getFilePath()).onLocalhost().build();

		} else {
			profile = ProfileBuilder.newBuilder().name(devOpspyProfile.getName()).filePath(devOpspyProfile.getFilePath())
					.onRemotehost(devOpspyProfile.getHost()).credentials(devOpspyProfile.getUser(), devOpspyProfile.getPassword()).build();
		}
		return profile;
	}
}
