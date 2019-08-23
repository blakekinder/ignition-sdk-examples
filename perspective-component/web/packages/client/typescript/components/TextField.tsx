import * as React from 'react';
import {
    Component,
    ComponentMeta,
    ComponentProps,
    SizeObject
} from '@inductiveautomation/perspective-client';
import { TextField as MuiTextField } from '@material-ui/core';
import { ThemeProvider as MuiThemeProvider } from '@material-ui/styles';
import { createMuiTheme } from '@material-ui/core/styles';

import '../../scss/text-field.scss';

// the 'key' or 'id' for this component type.  Component must be registered with this EXACT key in the Java side as well
// as on the client side.  In the client, this is done in the index file where we import and register through the
// ComponentRegistry provided by the perspective-client API.
export const COMPONENT_TYPE = 'mui.input.textfield';

export class TextField extends Component<ComponentProps, {}> {
    render() {
        const { props } = this.props;
        const autoComplete = props.read('autoComplete', '');
        const autoFocus = props.read('autoFocus', false);
        const disabled = props.read('disabled', false);
        const error = props.read('error', false);
        const fullWidth = props.read('fullWidth', true);
        const label = props.read('label', 'Label');
        const margin = props.read('margin', 'normal');
        const multiline = props.read('multiline', false);
        const placeholder = props.read('placeholder', '');
        const required = props.read('required', false);
        const rows = props.read('rows', 1);
        const rowsMax = props.read('rowsMax', 1);
        const theme = props.read('theme', 'light');
        const type = props.read('type', 'text');
        const value = props.read('value', '');
        const variant = props.read('variant', 'outlined');

        const handleChange = () => (event: React.ChangeEvent<HTMLInputElement>) => {
            props.write('value', event.target.value);
        };

        return (
            <div {...this.props.emit()}>
                <MuiThemeProvider theme={createMuiTheme({ palette: { type: theme } })}>
                    <MuiTextField
                        autoComplete={autoComplete}
                        autoFocus={autoFocus}
                        disabled={disabled}
                        error={error}
                        fullWidth={fullWidth}
                        label={label}
                        margin={margin}
                        multiline={multiline}
                        onChange={handleChange()}
                        placeholder={placeholder}
                        required={required}
                        rows={rows}
                        rowsMax={rowsMax}
                        type={type}
                        value={value}
                        variant={variant}
                    />
                </MuiThemeProvider>
            </div>
        );
    }
}

// this is the actual thing that gets registered with the component registry
export class TextFieldMeta implements ComponentMeta {
    getComponentType(): string {
        return COMPONENT_TYPE;
    }

    // the class or React Type that this component provides
    getViewClass(): React.ReactType {
        return TextField;
    }

    getDefaultSize(): SizeObject {
        return {
            width: 160,
            height: 64
        };
    }
}
