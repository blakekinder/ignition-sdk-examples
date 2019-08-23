package com.berryglobal.common.component.container;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.berryglobal.common.MuiComponents;

/**
 * Common meta information about the TextField component. See {@link Image} for
 * docs on each field.
 */
public class ThemeProvider {

    public static String COMPONENT_ID = "mui.container.themeprovider";

    public static JsonSchema SCHEMA = JsonSchema
            .parse(MuiComponents.class.getResourceAsStream("/themeprovider.props.json"));

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .withPaletteCategory(MuiComponents.COMPONENT_CATEGORY).withPaletteDescription("Theme Provider")
            .withId(COMPONENT_ID).withModuleId(MuiComponents.MODULE_ID).withSchema(SCHEMA)
            .withPaletteName("Theme Provider").withDefaultMetaName("themeProvider").shouldAddToPalette(true)
            .withResources(MuiComponents.BROWSER_RESOURCES).build();
}
