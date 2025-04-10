import { useState, useEffect } from "react";
import "../components/ListarProductos.css";

const ListarProductos = () => {
  const [productos, setProductos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/producto")
      .then((response) => response.json())
      .then((data) => {
        setProductos(data);
      })
      .catch((error) => {
        console.error("Error al obtener productos:", error);
      });
  }, []);

  return (
    <section className="lista">
      <h1 className="lista__titulo">Colección Urbana</h1>
      <div className="lista__productos">
        {productos.length > 0 ? (
          productos.map((producto) => (
            <div className="producto-card" key={producto.id_Producto}>
              <img
                src={producto.producto_imagen}
                alt={producto.producto_nombre}
                className="producto-card__imagen"
              />
              <h2 className="producto-card__nombre">{producto.producto_nombre}</h2>
              <p className="producto-card__precio">${producto.producto_precio}</p>
            </div>
          ))
        ) : (
          <p className="lista__vacio">No hay productos disponibles</p>
        )}
      </div>
    </section>
  );
};

export default ListarProductos;
