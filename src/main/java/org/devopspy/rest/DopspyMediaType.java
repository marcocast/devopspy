package org.devopspy.rest;

import javax.ws.rs.core.MediaType;

public class DopspyMediaType extends MediaType {

	public static final String APPLICATION_GREP = "application/vnd.org.devopspy.model.DevOpspyGrep+json+v1";

	public static final String APPLICATION_JSON_SCHEMA = "application/schema+json";

	public static final MediaType APPLICATION_BSON_TYPE = new MediaType("application", "bson");
}
