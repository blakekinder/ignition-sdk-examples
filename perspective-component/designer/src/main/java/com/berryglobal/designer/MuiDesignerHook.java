package com.berryglobal.designer;

import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.perspective.designer.DesignerComponentRegistry;
import com.inductiveautomation.perspective.designer.api.PerspectiveDesignerInterface;
import com.berryglobal.common.component.input.TextField;

/**
 * The 'hook' class for the designer scope of the module. Registered in the
 * ignitionModule configuration of the root build.gradle file.
 */
public class MuiDesignerHook extends AbstractDesignerModuleHook {

    private static final LoggerEx logger = LoggerEx.newBuilder().build("MuiComponents");

    static {
        BundleUtil.get().addBundle("muicomponents", MuiDesignerHook.class.getClassLoader(), "muicomponents");
    }

    public MuiDesignerHook() {
        logger.info("Registering MUI Components in Designer!");
    }

    private DesignerContext context;
    private DesignerComponentRegistry registry;

    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        this.context = context;
        init();
    }

    private void init() {
        logger.debug("Initializing registry entrants...");

        PerspectiveDesignerInterface pdi = PerspectiveDesignerInterface.get(context);

        registry = pdi.getDesignerComponentRegistry();

        // register components to get them on the palette
        registry.registerComponent(TextField.DESCRIPTOR);
    }

    @Override
    public void shutdown() {
        removeComponents();
    }

    private void removeComponents() {
        registry.removeComponent(TextField.COMPONENT_ID);
    }
}