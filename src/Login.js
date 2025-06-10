import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap

import "./App.css";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(""); 

    const handleSubmit = (e) => {
        e.preventDefault();
        
        if (username === "" || password === "") {
            setError("Username and password are required.");
        } else {
            setError(""); // Clear error if valid
            console.log("Logging in with:", { username, password });
        }
    };

    return (
        <div style={{
            backgroundSize: "cover",
            backgroundRepeat: "no-repeat",
            backgroundPosition: "center",
            backgroundColor: "#252526",
            minHeight: "100vh",
            display: "flex",
            justifyContent: "center",
            alignItems: "center"
        }}>
            <div className="login-container">
                <h2 className="text-center mb-4">Welcome</h2>

                {error && <div className="error-message">{error}</div>}

                <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="username">Username</label>
                        <input 
                            type="text" 
                            className="form-control" 
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required 
                        />
                    </div>
                    <div className="mb-4">
                        <label className="form-label" htmlFor="password">Password</label>
                        <input 
                            type="password" 
                            className="form-control" 
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required 
                        />
                    </div>
                    <button type="submit" className="login-button">Login</button>
                </form>
            </div>
        </div>
    );
}

export default Login;