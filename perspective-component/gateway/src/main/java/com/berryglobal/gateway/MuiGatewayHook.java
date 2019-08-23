package com.berryglobal.gateway;

import java.util.Optional;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.gateway.dataroutes.RouteGroup;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.inductiveautomation.perspective.common.api.ComponentRegistry;
import com.inductiveautomation.perspective.gateway.api.ComponentModelDelegateRegistry;
import com.inductiveautomation.perspective.gateway.api.PerspectiveContext;
import com.berryglobal.common.MuiComponents;
import com.berryglobal.common.component.input.TextField;
import com.berryglobal.common.component.container.ThemeProvider;

public class MuiGatewayHook extends AbstractGatewayModuleHook {

    private static final LoggerEx log = LoggerEx.newBuilder().build("mui.gateway.MuiGatewayHook");

    private GatewayContext gatewayContext;
    private PerspectiveContext perspectiveContext;
    private ComponentRegistry componentRegistry;
    private ComponentModelDelegateRegistry modelDelegateRegistry;

    @Override
    public void setup(GatewayContext context) {
        this.gatewayContext = context;
        log.info("Setting up MuiComponents module.");
    }

    @Override
    public void startup(LicenseState activationState) {
        log.info("Starting up MuiGatewayHook!");

        this.perspectiveContext = PerspectiveContext.get(this.gatewayContext);
        this.componentRegistry = this.perspectiveContext.getComponentRegistry();
        this.modelDelegateRegistry = this.perspectiveContext.getComponentModelDelegateRegistry();

        if (this.componentRegistry != null) {
            log.info("Registering Mui components.");
            this.componentRegistry.registerComponent(TextField.DESCRIPTOR);
            this.componentRegistry.registerComponent(ThemeProvider.DESCRIPTOR);
        } else {
            log.error("Reference to component registry not found, Mui Components will fail to function!");
        }

        if (this.modelDelegateRegistry != null) {
            log.info("Registering model delegates.");
        } else {
            log.error("ModelDelegateRegistry was not found!");
        }

    }

    @Override
    public void shutdown() {
        log.info("Shutting down MuiComponent module and removing registered components.");
        if (this.componentRegistry != null) {
            this.componentRegistry.removeComponent(TextField.COMPONENT_ID);
        } else {
            log.warn("Component registry was null, could not unregister Mui Components.");
        }
        if (this.modelDelegateRegistry != null) {
        }

    }

    @Override
    public Optional<String> getMountedResourceFolder() {
        return Optional.of("mounted");
    }

    @Override
    public void mountRouteHandlers(RouteGroup routeGroup) {
        // where you may choose to implement web server endpoints accessible via
        // `host:port/system/data/
        // routes = new DataEndpoints(this.perspectiveContext, routeGroup);
    }

    // Lets us use the route http://<gateway>/res/Muicomponents/*
    @Override
    public Optional<String> getMountPathAlias() {
        return Optional.of(MuiComponents.URL_ALIAS);
    }

    @Override
    public boolean isFreeModule() {
        return true;
    }
}
