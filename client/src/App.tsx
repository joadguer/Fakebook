import { Email } from '@mui/icons-material'
import './App.css'
import { InputText, PasswordInput } from './components/InputText'
import { useInputText } from './hooks/useInputText'
import { GenericForm } from './components/GenericForm'

function App() {
  const inputController = useInputText()

  return (
    <GenericForm onSubmit={() => console.log(inputController.value)}>
      <InputText label={"Nombre"} focusedLabel='Ingresa tu nombre' icon={<Email sx={{color: '#B0C0C0'}}/>} {...inputController.getProps()}/>
      <PasswordInput {...inputController.getProps()}/>
    </GenericForm>
  )
}

export default App
