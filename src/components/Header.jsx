import "../components/Header.css";
import { Link } from "react-router-dom";

function Header() {
  return (
    <header className="encabezado">
      <nav className="encabezado-nav">
        <div className="nav-left">
          <a>Hombre</a>
          <a>Mujer</a>
        </div>

        <div className="nav-center">
          <h1 className="logo">VALNOR</h1>
        </div>

        <div className="nav-right">
          <input type="text" placeholder="Buscar..." />
          <button>Iniciar Sesión</button>
        </div>
      </nav>
    </header>
  );
}
export default Header;
