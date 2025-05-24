import { useForm } from "react-hook-form"
import { FormInput, type FormInputProps } from "./FormInput"
import { Button } from "react-bootstrap"
import { Typography } from "@mui/material"

export interface Formulario2Props {
    nombreProps: FormInputProps
    apellidoProps: FormInputProps
    edadProps: FormInputProps
    mensaje?: string
    onSubmit?: () => void
    error?: string
}

export const Formulario2 = (props: Formulario2Props) => {
    const { handleSubmit } = useForm()

    return (
        <form style={{ display: 'flex', flexDirection: 'column' }}
        onSubmit={handleSubmit(props.onSubmit ?? (() => {}))}>
            <FormInput label="Ingresa tu nombre" {...props.nombreProps}/>
            <FormInput label="Ingresa tu apellido" {...props.apellidoProps}/>
            <FormInput label="Ingresa tu edad" {...props.edadProps}/>
            <Button type='submit'>Listo</Button>
            <Typography>{props.mensaje}</Typography>
        </form>
    )
}