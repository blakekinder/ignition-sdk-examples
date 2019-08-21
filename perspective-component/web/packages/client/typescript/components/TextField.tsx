import * as React from 'react';
import { action, observable } from 'mobx';
import { observer } from 'mobx-react';
import {
    Component,
    ComponentMeta,
    ComponentProps,
    SizeObject
} from '@inductiveautomation/perspective-client';
import { TextField as MuiTextField } from '@material-ui/core';

import '../../scss/textfield.scss';

// the 'key' or 'id' for this component type.  Component must be registered with this EXACT key in the Java side as well
// as on the client side.  In the client, this is done in the index file where we import and register through the
// ComponentRegistry provided by the perspective-client API.
export const COMPONENT_TYPE = 'mui.input.textfield';

@observer
export class TextField extends Component<ComponentProps, {}> {
    @observable autoComplete: string = '';
    @observable autoFocus: boolean = false;
    @observable disabled: boolean = false;
    @observable error: boolean = false;
    @observable fullWidth: boolean = false;
    @observable label: string = 'Label';
    @observable margin: string = 'normal';
    @observable multiline: boolean = false;
    @observable placeholder: string = '';
    @observable required: boolean = false;
    @observable rows: number = 1;
    @observable rowsMax: number = 1;
    @observable type: string = 'text';
    @observable value: string = '';
    @observable variant: string = 'outlined';

    @action
    handleChange = () => (event: React.ChangeEvent<HTMLInputElement>) => {
        this.value = event.target.value;
    }

    render() {
        // the props we're interested in
        const {
            autoComplete,
            autoFocus,
            disabled,
            error,
            fullWidth,
            label,
            margin,
            multiline,
            placeholder,
            required,
            rows,
            rowsMax,
            type,
            value,
            variant
        } = this.props;

        return (
            <div {...this.props.emit()}>
                <MuiTextField
                    autoComplete={autoComplete}
                    autoFocus={autoFocus}
                    disabled={disabled}
                    error={error}
                    fullWidth={fullWidth}
                    label={label}
                    margin={margin}
                    multiline={multiline}
                    onChange={this.handleChange()}
                    placeholder={placeholder}
                    required={required}
                    rows={rows}
                    rowsMax={rowsMax}
                    type={type}
                    value={value}
                    variant={variant}
                />
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
