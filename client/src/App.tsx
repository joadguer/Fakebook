import './App.css'
import { Formulario3 } from './Formulario3'
import { useMyForm } from './useMyForm'

function App() {
  const formController = useMyForm()
  
  return (
    <Formulario3 {...formController.getProps2()}/>
  )
}

export default App
