import "./PresentacionRopa.css";

const PresentacionRopa = () => {
  return (
    <div className="productoRopa">
    <img src="public/presentacionRopa-img.jpg" alt="Presentación de ropa urbana" />
    <div className="productoRopa__texto">
      <h2>HAZ QUE TE MIREN DOS VECES</h2>
      <p>Tu estilo no sigue tendencias. Las crea.</p>
      <button>VER COLECCIÓN</button>
    </div>
  </div>
  );
};

export default PresentacionRopa;
