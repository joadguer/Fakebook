import React from 'react';
// import { Link } from 'react-router-dom';
import "../styles/login.css";

interface AuthMessageProps {
  message?: string;
  linkText?: string;
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
