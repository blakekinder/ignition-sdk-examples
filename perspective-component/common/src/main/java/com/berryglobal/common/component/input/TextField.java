package com.berryglobal.common.component.input;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.berryglobal.common.MuiComponents;

/**
 * Common meta information about the TextField component. See {@link Image} for
 * docs on each field.
 */
public class TextField {

        public static String COMPONENT_ID = "mui.input.textfield";

        public static JsonSchema SCHEMA = JsonSchema
                        .parse(MuiComponents.class.getResourceAsStream("/textfield.props.json"));

        public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
                        .withPaletteCategory(MuiComponents.COMPONENT_CATEGORY).withPaletteDescription("Text Field")
                        .withId(COMPONENT_ID).withModuleId(MuiComponents.MODULE_ID).withSchema(SCHEMA)
                        .withPaletteName("Text Field").withDefaultMetaName("textField").shouldAddToPalette(true)
                        .withResources(MuiComponents.BROWSER_RESOURCES).build();
}
