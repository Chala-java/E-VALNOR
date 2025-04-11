import "../components/Presentacion.css";

function Presentacion() {
  return (
    <div className="presentacion">
      <img src="public\presentacion-img.jpg" alt="Presentación de colección" />
      <div className="presentacion__texto">
        <h2>ROMPE LAS REGLAS</h2>
        <p>Vístete para dominar tu mundo.</p>
        <button>EXPLORAR AHORA</button>
      </div>
    </div>
  );
}

export default Presentacion;
