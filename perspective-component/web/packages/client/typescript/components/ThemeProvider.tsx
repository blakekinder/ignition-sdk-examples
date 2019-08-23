import * as React from 'react';
import { ThemeProvider as MuiThemeProvider } from '@material-ui/styles';
import { createMuiTheme } from '@material-ui/core/styles';
import {
    Component,
    ComponentMeta,
    ComponentProps,
    SizeObject
} from '@inductiveautomation/perspective-client';

import '../../scss/theme-provider.scss';

// the 'key' or 'id' for this component type.  Component must be registered with this EXACT key in the Java side as well
// as on the client side.  In the client, this is done in the index file where we import and register through the
// ComponentRegistry provided by the perspective-client API.
export const COMPONENT_TYPE = 'mui.container.themeprovider';

export class ThemeProvider extends Component<ComponentProps, {}> {
    render() {
        const { def, props } = this.props;
        const flexDirection = props.read('direction', 'row');
        const flexWrap = props.read('wrap', 'nowrap');
        const justify = props.read('justify', 'flex-start');
        const alignItems = props.read('alignItems', 'stretch');
        const alignContent = props.read('alignContent', 'stretch');
        const style = props.read('style', '');
        const theme = createMuiTheme(
            props.read('theme', { palette: { type: 'light' } })
        );

        const classes: Array<string> = ['flex-container'].concat(
            style.classes.split(' ')
        );

        const styles = {
            flexDirection,
            flexWrap,
            justify,
            alignItems,
            alignContent
        };

        const children = def !== undefined ? def.children : null;

        return (
            <div {...this.props.emit({ classes: classes, style: styles })}>
                <MuiThemeProvider theme={theme}>{children}</MuiThemeProvider>
            </div>
        );
    }
}

// this is the actual thing that gets registered with the component registry
export class ThemeProviderMeta implements ComponentMeta {
    getComponentType(): string {
        return COMPONENT_TYPE;
    }

    // the class or React Type that this component provides
    getViewClass(): React.ReactType {
        return ThemeProvider;
    }

    getDefaultSize(): SizeObject {
        return {
            width: 800,
            height: 800
        };
    }
    isContainer: true;
    isDeepSelectable: true;
}
