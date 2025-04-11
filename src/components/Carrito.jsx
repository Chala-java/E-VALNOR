import { useContext, useEffect, useState } from "react";
import { CarritoContext } from "../context/CarritoContext";
import { ModalCarritoContext } from "../context/ModalCarritoContext";
import { FaShoppingCart } from "react-icons/fa"; // ⬅️ El nuevo fichaje estrella
import "./Carrito.css";

const Carrito = () => {
  const { carrito, vaciarCarrito } = useContext(CarritoContext);
  const { modalAbierto, cerrarModal, abrirModal } = useContext(ModalCarritoContext);
  const [tamanoPrevio, setTamanoPrevio] = useState(0);

  useEffect(() => {
    if (carrito.length > tamanoPrevio) {
      abrirModal();
    }
    setTamanoPrevio(carrito.length);
  }, [carrito]);

  return (
    <>
      {modalAbierto && (
        <div className="carrito__modal-fondo">
          <div className="carrito__modal-contenido">
            <h2>🛒 Tu carrito</h2>

            {carrito.length === 0 ? (
              <p>El carrito está vacío.</p>
            ) : (
              <ul>
                {carrito.map((producto, index) => (
                  <li key={index} className="carrito__producto">
                    <img src={producto.producto_imagen} alt={producto.producto_nombre} />
                    <div className="carrito__producto-detalle">
                      <p><strong>{producto.producto_nombre}</strong></p>
                      <p>Precio: ${Number(producto.producto_precio).toLocaleString("es-CO")}</p>
                      <p>Cantidad: {producto.producto_cantidad}</p>
                    </div>
                  </li>
                ))}
              </ul>
            )}

            <div className="carrito__botones">
              {carrito.length > 0 && (
                <button onClick={vaciarCarrito}>Vaciar carrito</button>
              )}
              <button onClick={cerrarModal}>Cerrar</button>
            </div>
          </div>
        </div>
      )}

      {!modalAbierto && (
        <div className="carrito__flotante" onClick={abrirModal}>
          <FaShoppingCart className="carrito__icono" />
          {carrito.length > 0 && (
            <span className="carrito__badge">{carrito.length}</span>
          )}
        </div>
      )}
    </>
  );
};

export default Carrito;
