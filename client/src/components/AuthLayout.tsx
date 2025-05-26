import { Outlet } from "react-router-dom";
import icon from "../assets/facebook.webp";
import "../styles/login.css";
import AuthMessage from "./AuthMessage";
import AuthHeader from "./AuthHeader";

export const AuthLayout = () => {
    return (
        
        <div className="container">      
            <div className="left-panel"/>
                    
            <div className="right-panel">
           
                <div className="logo">
                    <img src={icon} alt="Logo Fakebook" />
                </div>
                <AuthHeader
                  text="¡Crea tu cuenta en Fakebook!"
                />


              <AuthMessage
                    message="¿Ya tienes cuenta? Inicia sesión"
                    // linkText="Inicia sesión"
                    // linkTo="/auth/login"
                    />
                  
                
                <Outlet />
            </div>
        </div>
    );
};
