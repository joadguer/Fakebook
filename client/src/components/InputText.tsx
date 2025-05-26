import { IconButton, TextField } from "@mui/material"
import { type TextFieldProps } from "@mui/material"
import "../styles/input.css"
import { useState, type JSX } from "react";
import { Visibility, VisibilityOff } from "@mui/icons-material";

export type InputTextProps = TextFieldProps & {
    focusedLabel?: string;
    icon?: JSX.Element;
    errorMessage?: string;
}

export const InputText = (props: InputTextProps) => {
    const [focused, setFocused] = useState(false);
    const [hasValue, setHasValue] = useState(false);
    const isShrink = focused || hasValue;

    return (
        <TextField
            variant="outlined"
            fullWidth
            className="input-text"
            {...props}
            onFocus={() => setFocused(true)}
            onBlur={() => setFocused(false)}
            onChange={(e) => {props.onChange?.(e); setHasValue(e.target.value !== "")}}
            label={isShrink ? props.label : props.focusedLabel ?? props.label}
            slotProps={{
                input: {
                    endAdornment: props.icon,
                }
            }}
            error={!!props.errorMessage}
            helperText={props.errorMessage}
        />
    )
}

export const PasswordInput = (props: InputTextProps) => {
    const [visibility, setVisibility] = useState(false);

    const visibilityIcon = (
        <IconButton
            onClick={() => setVisibility(false)}
            sx={{ color: '#B0C0C0' }}>
            <Visibility />
        </IconButton>
    )
    const visibilityOffIcon = (
        <IconButton
            onClick={() => setVisibility(true)}
            sx={{ color: '#B0C0C0' }}>
            <VisibilityOff />
        </IconButton>
    )

    return (
        <InputText
            type={visibility ? "text" : "password"}
            label={props.label ?? "Contraseña"}
            focusedLabel={props.focusedLabel ?? "Ingresa tu contraseña"}
            {...props}
            icon={visibility ? visibilityIcon : visibilityOffIcon}
        />
    )
}