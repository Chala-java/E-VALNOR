// src/components/PresentacionAccesorios.jsx
import "./PresentacionAccesorios.css";

function PresentacionAccesorios() {
  return (
    <div className="presentacion-accesorios">
      <img src="public\PresentacionAccesorio-img.jpg" alt="Presentación de accesorios" />
      <div className="presentacion-accesorios__texto">
        <h2>LOS DETALLES IMPORTAN</h2>
        <p>Completa tu estilo con el toque perfecto.</p>
        <button>VER ACCESORIOS</button>
      </div>
    </div>
  );
}

export default PresentacionAccesorios;
