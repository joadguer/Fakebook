  import React from 'react'
  import type { LucideIcon } from 'lucide-react'
  import '../styles/input.css'

  interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
    icon?: LucideIcon
    onIconClick?: () => void
  }

  export function Input({ onIconClick, ...props }: InputProps) {
    return (
      <div className="input-container">
        <input className="input-field" {...props} />
        {props.icon && (
          <button type="button" className="input-icon" onClick={onIconClick}>
            <props.icon />
          </button>
        )}
      </div>
    )
  }
