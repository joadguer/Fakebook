import { useForm } from "react-hook-form"
import { FormInput2 } from "./FormInput"
import type { Formulario2Props } from "./Formulario2"
import { Button } from "react-bootstrap"
import { Typography } from "@mui/material"

export const Formulario3 = (props: Formulario2Props) => {
    const { handleSubmit } = useForm()

    return (
        <form style={{ display: 'flex', flexDirection: 'column', gap: 10 }}
        onSubmit={handleSubmit(props.onSubmit ?? (() => {}))}>
            <FormInput2 label="Ingresa tu nombre" {...props.nombreProps}/>
            <FormInput2 label="Ingresa tu apellido" {...props.apellidoProps}/>
            <FormInput2 label="Ingresa tu edad" {...props.edadProps}/>
            <Button type='submit'>Listo</Button>
            <Typography>{props.mensaje}</Typography>
        </form>
    )
}