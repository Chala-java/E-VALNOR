import "../components/Presentacion.css";
import { imagenes } from "../services/database";

function Presentacion() {
  return (
    <div className="presentacion">
      <img src={imagenes[0].img} alt="Presentación de colección" />
      <div className="presentacion__texto">
        <h2>ROMPE LAS REGLAS</h2>
        <p>Vístete para dominar tu mundo.</p>
        <button>EXPLORAR AHORA</button>
      </div>
    </div>
  );
}

export default Presentacion;
