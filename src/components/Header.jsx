import "./Header.css"
import { Link } from "react-router-dom";

function Header() {
  return (
    <header className="header">
      <nav className="header__nav">
        <div className="header__section header__section--left">
          <a className="header__link">Hombre</a>
          <a className="header__link">Mujer</a>
        </div>

        <div className="header__section header__section--center">
          <h1 className="header__logo">VALNOR</h1>
        </div>

        <div className="header__section header__section--right">
          <input className="header__search" type="text" placeholder="Buscar..." />
          <Link to="/admin-login">
            <button className="header__button">Iniciar Sesión</button>
          </Link>
        </div>
      </nav>
    </header>
  );
}

export default Header;
