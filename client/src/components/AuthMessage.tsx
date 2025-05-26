// src/components/AuthMessage.tsx
import React from 'react';
// import { Link } from 'react-router-dom';
import "../styles/login.css";

interface AuthMessageProps {
  /** Texto principal antes del enlace */
  message?: string;
  /** Texto del enlace */
  linkText?: string;
  /** Ruta hacia la que apunta el enlace */
  linkTo?: string;
}

const AuthMessage: React.FC<AuthMessageProps> = ({
  message = '¿Ya tienes cuenta?',
  // linkText = 'Inicia sesión',
  // linkTo = '/login',
}) => {
  return (
    <p className="auth-message">
      {message}
      {' '}

    </p>
  );
};

export default AuthMessage;
