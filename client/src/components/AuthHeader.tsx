// src/components/AuthHeader.tsx
import React from 'react';
import "../styles/login.css";

interface AuthHeaderProps {
  /** Texto a mostrar; por defecto invita a crear cuenta */
  text?: string;
}

const AuthHeader: React.FC<AuthHeaderProps> = ({
  text = '¡Crea tu cuenta en Fakebook!',
}) => {
  return <h1 className="auth-header">{text}</h1>;
};

export default AuthHeader;
