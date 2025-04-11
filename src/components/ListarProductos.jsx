import { useState, useEffect, useContext } from "react";
import { CarritoContext } from "../context/CarritoContext";
import "../components/ListarProductos.css";
import PresentacionRopa from "./PresentacionRopa";
import PresentacionAccesorios from "./PresentacionAccesorios";

const ListarProductos = () => {
  const [zapatillas, setZapatillas] = useState([]);
  const [ropa, setRopa] = useState([]);
  const [accesorios, setAccesorios] = useState([]);
  const { agregarAlCarrito } = useContext(CarritoContext);

  useEffect(() => {
    fetch("http://localhost:8080/productos")
      .then((response) => response.json())
      .then((data) => {
        const zapas = data.filter((p) => p.producto_categoria === "Zapatillas");
        const ropita = data.filter((p) => p.producto_categoria === "Ropa");
        const acc = data.filter((p) => p.producto_categoria === "Accesorios");

        setZapatillas(zapas);
        setRopa(ropita);
        setAccesorios(acc);
      })
      .catch((error) => console.error("Error al obtener productos:", error));
  }, []);

  const renderProductos = (productos) => (
    <div className="lista__productos">
      {productos.length > 0 ? (
        productos.map((producto) => (
          <div className="producto-card" key={producto.id_Producto}>
            <img
              src={producto.producto_imagen || "/img/placeholder.png"}
              alt={producto.producto_nombre}
              className="producto-card__imagen"
            />
            <h2 className="producto-card__nombre">{producto.producto_nombre}</h2>
            <p className="producto-card__marca">Marca: {producto.producto_marca}</p>
            <p className="producto-card__precio">
              ${Number(producto.producto_precio).toLocaleString("es-CO")}
            </p>
            <button
              className="producto-card__boton"
              onClick={() => agregarAlCarrito(producto)}
            >
              Agregar al carrito
            </button>
          </div>
        ))
      ) : (
        <p className="lista__vacio">No hay productos disponibles</p>
      )}
    </div>
  );

  return (
    <section className="lista">
      <section>
        <h1 className="lista__titulo">Zapatillas</h1>
        {renderProductos(zapatillas)}
      </section>

      <section className="seccion-ropa">
        <PresentacionRopa />
        <h1 className="lista__titulo">Ropa</h1>
        {renderProductos(ropa)}
      </section>

      <section className="seccion-categoria">
        <PresentacionAccesorios/>
        <h1 className="lista__titulo">Accesorios</h1>
        {renderProductos(accesorios)}
      </section>
    </section>
  );
};

export default ListarProductos;
