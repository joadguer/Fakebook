import React from 'react';
import '../styles/button.css';

interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {}

export function Button({ children, ...props }: ButtonProps) {
  return (
    <button className="btn" {...props}>
      {children}
    </button>
  );
}
