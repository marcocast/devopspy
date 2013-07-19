package org.devopspy.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyGrep;
import org.devopspy.model.DevOpspyProfile;
import org.devopspy.repository.DevOpspyProfileRepository;
import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ProfileBuilder;
import org.springframework.stereotype.Service;

@Service
@Named("profileService")
public class ProfileService {

	@Inject
	@Named("devOpspyProfileRepository")
	private DevOpspyProfileRepository devOpspyProfileRepository;

	public List<Profile> generateProfiles(DevOpspyGrep devOpspyGrep) {
		List<Profile> profiles = null;
		
		DevOpspyProfile devOpspyProfile = devOpspyProfileRepository.findOne(devOpspyGrep.getDevOpspyProfile().getId());
		if (devOpspyProfile.getHost().equalsIgnoreCase("localhost")) {
			Profile profileNew = ProfileBuilder.newBuilder().name(devOpspyProfile.getName()).filePath(devOpspyProfile.getFilePath()).onLocalhost()
					.build();
			profiles = new ArrayList<Profile>();
			profiles.add(profileNew);
		}
		return profiles;

	}
}
