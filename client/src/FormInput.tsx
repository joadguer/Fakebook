import { Box, TextField, Typography } from "@mui/material"
import { useState } from "react"

export interface FormInputProps {
    label?: string
    value?: string
    onChange?: (value: string) => void
    error?: string
}

export const FormInput = (props: FormInputProps) => {
    return (
        <Box sx={{ display: 'flex', flexDirection: 'column' }}>
            <Typography>{props.label}</Typography>
            <input type='text' value={props.value} onChange={(e) => props.onChange?.(e.target.value)}></input>
        </Box>
    )
}

export const FormInput2 = (props: FormInputProps) => {
    return (
        <Box sx={{ display: 'flex', flexDirection: 'column'}}>
            <TextField
                variant="outlined"
                label={props.label}
                value={props.value}
                onChange={(e) => props.onChange?.(e.target.value)}
                error={!!props.error}
                helperText={props.error}

            />
        </Box>
    )
}

export const useFormInput = () => {
    const [value, setValue] = useState<string>('')
    const [error, setError] = useState<string>('')

    const getProps = (): FormInputProps => {
        return {
            value,
            onChange: setValue,
        }
    }

    const isEmpty = (): boolean => value === ''


    return {
        value,
        setValue,
        getProps,
        isEmpty,
        error,
        setError,
    }
}