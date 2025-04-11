import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./AdminLogin.css"; // tu estilo si tienes uno

function AdminLogin() {
  const [usuario, setUsuario] = useState("");
  const [contrasena, setContrasena] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    if (usuario === "admin" && contrasena === "1234") {
      navigate("/admin"); // 💥 Redirección al panel
    } else {
      alert("Credenciales incorrectas");
    }
  };

  return (
    <div className="admin-login">
      <h2>Login Administrador</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Usuario"
          value={usuario}
          onChange={(e) => setUsuario(e.target.value)}
        />
        <input
          type="password"
          placeholder="Contraseña"
          value={contrasena}
          onChange={(e) => setContrasena(e.target.value)}
        />
        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
}

export default AdminLogin;
