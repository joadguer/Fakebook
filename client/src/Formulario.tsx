import { Button, Typography } from "@mui/material"
import { useForm } from "react-hook-form"

export interface FormularioProps {
    nombre?: string
    apellido?: string
    edad?: string
    mensaje?: string
    onChangeNombre?: (nombre: string) => void
    onChangeApellido?: (apellido: string) => void
    onChangeEdad?: (edad: string) => void
    onSubmit?: () => void
}

export const Formulario = (props: FormularioProps) => {
    const { handleSubmit } = useForm()

    return (
        <form style={{ display: 'flex', flexDirection: 'column' }}
        onSubmit={handleSubmit(props.onSubmit ?? (() => {}))}>
            <Typography>Ingresa tu nombre</Typography>
            <input type='text' value={props.nombre} onChange={(e) => props.onChangeNombre?.(e.target.value)}></input>

            <Typography>Ingrea tu apellido</Typography>
            <input type='text' value={props.apellido}
            onChange={(e) => props.onChangeApellido?.(e.target.value)}></input>

            <Typography>Ingresa tu edad</Typography>
            <input type='number' value={props.edad} onChange={(event) => props.onChangeEdad?.(event.target.value)}></input>

            <Button type='submit'>Listo</Button>

            <Typography>{props.mensaje}</Typography>
        </form>
    )
}