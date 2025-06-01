import React, { useState } from 'react';
import { Input } from './Input';
import { Button } from './Button';
//  import { Mail, Eye, EyeOff } from 'lucide-react';
import '../styles/SignupForm.css';
import AuthMessage from './AuthMessage';

export function SignupForm() {
  const [data, setData] = useState({ email: '', password: '' });
  const [showPwd, setShowPwd] = useState(false);

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) =>
    setData({ ...data, [e.target.name]: e.target.value });

  const onSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('Enviando formulario:', data);
  };

  return (
    <div className="login-form">
        <form onSubmit={onSubmit}>
          <Input
            name="email"
            type="email"
            placeholder="Ingresa tu email"
            value={data.email}
            onChange={onChange}
          />
        <AuthMessage
                    message="No tienes cuenta? Regístrate"
                    // linkText="Inicia sesión"
                    // linkTo="/auth/login"
        />  
          <Input
            name="password"
            type={showPwd ? 'text' : 'password'}
            placeholder="Ingresa tu contraseña"
            value={data.password}
            onChange={onChange}
            // icon={showPwd ? EyeOff : Eye}
            onIconClick={() => setShowPwd(!showPwd)}
          />
         <AuthMessage
                    message="Olvisdaste tu contraseña?"
                    // linkText="Inicia sesión"
                    // linkTo="/auth/login"
        /> 
          <div className="btn-container"> 
            
            <Button type="submit">Iniciar sesión</Button>
          </div>
        </form>
       
    </div>
  );
}

export default SignupForm;