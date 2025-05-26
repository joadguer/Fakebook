import { useState } from "react"
import { type InputTextProps } from "../components/InputText"

export const useInputText = () => {
    const [value, setValue] = useState<string>("")
    const [error, setError] = useState<string>("")

    const getProps = (): InputTextProps => {
        return {
            value,
            onChange: (e) => setValue(e.target.value),
            errorMessage: error, 
        }
    }

    const isEmpty = () => value.trim() === ""
    const clear = () => setValue("")
    const clearError = () => setError("")

    return {
        value,
        setValue,
        error,
        setError,
        isEmpty,
        clear,
        clearError,
        getProps
    }
}