package com.berryglobal.common;

import java.util.Set;

import com.google.common.collect.Sets;
import com.inductiveautomation.perspective.common.api.BrowserResource;

public class MuiComponents {

	public static final String MODULE_ID = "com.berryglobal.muicomponents";
	public static final String URL_ALIAS = "muicomponents";
	public static final String COMPONENT_CATEGORY = "Material-UI";
	public static final Set<BrowserResource> BROWSER_RESOURCES = Sets.newHashSet(
			new BrowserResource("mui-components-js", String.format("/res/%s/MuiComponents.js", URL_ALIAS),
					BrowserResource.ResourceType.JS),
			new BrowserResource("mui-components-css", String.format("/res/%s/MuiComponents.css", URL_ALIAS),
					BrowserResource.ResourceType.CSS));
}
