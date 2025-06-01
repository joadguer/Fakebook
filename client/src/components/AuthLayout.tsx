import { Outlet } from "react-router-dom";
import icon from "../assets/facebook.webp";
import "../styles/login.css";
import AuthHeader from "./AuthHeader";
import LoginForm from "./LoginForm";  
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
                <LoginForm />
                 
                <Outlet />
            </div>
        </div>
    );
};
