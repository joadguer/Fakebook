import { Outlet } from "react-router-dom";
import icon from "../assets/facebook.webp";
import "../styles/login.css";

export const AuthLayout = () => {
    return (
        
        <div className="container">      
            <div className="left-panel"/>
                    
            <div className="right-panel">
                <div className="logo">
                    <img src={icon} alt="Logo Fakebook" />
                </div>

                <Outlet />
            </div>
        </div>
    );
};
