import { useState } from "react"
import type { FormularioProps } from "./Formulario"
import { useFormInput } from "./FormInput"
import type { Formulario2Props } from "./Formulario2"


export const useMyForm = () => {
    const apellidoControler = useFormInput()
    const nombreControler = useFormInput()
    const edadControler = useFormInput()
    const [mensaje, setMensaje] = useState<string>("")


    const getApellido = () => {
        if (apellidoControler.isEmpty()) {
            apellidoControler.setValue("Manuel")
            return "Manuel"
        }

        return apellidoControler.value
    }

    const setValidEdad = (edad: string) => {
        if (edadControler.value.startsWith("-")) return
        edadControler.setValue(edad)
    }

    const handleClick = () => {
        const currentNombre = nombreControler.value
        const currentApellido = apellidoControler.value
        const currentEdad = edadControler.value

        console.log("Nombre: " + currentNombre)
        console.log("Apellido: " + currentApellido)
        console.log("Edad: " + currentEdad)
        setMensaje(`Hola ${currentNombre} ${currentApellido}, tienes ${currentEdad} años`)
    }

    const getProps = (): FormularioProps => {
        return {
            nombre: nombreControler.value,
            apellido: getApellido(),
            edad: edadControler.value,
            mensaje,
            onChangeNombre: nombreControler.setValue,
            onChangeApellido: apellidoControler.setValue,
            onChangeEdad: setValidEdad,
            onSubmit: handleClick
        }
    }

    const getProps2 = (): Formulario2Props => {
        return {
            nombreProps: nombreControler.getProps(),
            apellidoProps: apellidoControler.getProps(),
            edadProps: edadControler.getProps(),
            mensaje,
            onSubmit: handleClick,
        }
    }


    return {
        setApellido: getApellido,
        setEdad: setValidEdad,
        handleClick,
        getProps,
        getProps2,
    }
}