import { Routes, Route, useLocation } from "react-router-dom";
import Home from "../pages/Home";
import Admin from "../pages/Admin";
import Header from "../components/Header";

function AppRouter() {
  const location = useLocation();
  const esRutaAdmin = location.pathname.startsWith("/admin");

  return (
    <>
      {!esRutaAdmin && <Header /> }
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/admin" element={<Admin />} />
        {/* Más rutas si tenés */}
      </Routes>
    </>
  );
}

export default AppRouter;
