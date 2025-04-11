import { useContext } from "react";
import Header from "../components/Header";
import ListarProductos from "../components/ListarProductos";
import "../pages/Home.css";
import Presentacion from "../components/Presentacion";
import Categoria from "../components/Categoria";
import Carrito from "../components/Carrito";
import { ModalCarritoContext } from "../context/ModalCarritoContext";
import "../components/Carrito.css";
import PresentacionRopa from "../components/PresentacionRopa";


const Home = () => {
  const { toggleModal } = useContext(ModalCarritoContext);

  return (
    <>
      <section>
        <Header />
        <Categoria />
      </section>

      <section className="contenido-principal">
        <Presentacion />
        <ListarProductos />
      
        <Carrito />
      

        {/* Botón fijo del carrito 🛒 */}
        <button
          onClick={toggleModal}
          className="carrito__boton-flotante"
          aria-label="Ver carrito"
        >
          🛒
        </button>
      </section>
    </>
  );
};

export default Home;
